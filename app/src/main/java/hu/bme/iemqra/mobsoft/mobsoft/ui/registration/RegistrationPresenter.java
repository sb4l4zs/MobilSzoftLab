package hu.bme.iemqra.mobsoft.mobsoft.ui.registration;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.UserInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.RegisterUserEvent;
import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;

import static hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication.injector;


public class RegistrationPresenter extends Presenter<RegistrationScreen> {
    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(RegistrationScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    void registerUser(final String firstName, final String lastName, final String email, final String password) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.registerUser(firstName, lastName, email, password);
            }
        });
    }

    public void onEventMainThread(RegisterUserEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError("Something went wrong!");
            }
        } else {
            if (screen != null) {
                if (event.getUserId() != 0) {
                    screen.registrationOK();
                } else {
                    screen.showError("Another user already registered with this mail address!");
                }
            }
        }
    }
}
