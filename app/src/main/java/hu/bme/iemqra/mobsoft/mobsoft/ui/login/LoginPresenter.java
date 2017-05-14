package hu.bme.iemqra.mobsoft.mobsoft.ui.login;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.UserInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.LoginUserEvent;
import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;

import static hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication.injector;


public class LoginPresenter extends Presenter<LoginScreen> {
    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    void loginUser(final String email, final String password) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.loginUser(email, password);
            }
        });
    }

    public void onEventMainThread(LoginUserEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.userLoginFailed("Something went wrong!");
            }
        } else {
            if (screen != null) {
                if (event.getUser() != null) {
                    screen.userLoginOK(event.getUser().getEmail());
                } else {
                    screen.userLoginFailed("Wrong password or non existing user!");
                }
            }
        }
    }
}