package hu.bme.iemqra.mobsoft.mobsoft.interactor.exam;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.LoginUserEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.RegisterUserEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.AppApi;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;


public class UserInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    AppApi appApi;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void loginUser(String email, String password) {
        LoginUserEvent event = new LoginUserEvent();
        try {
            User user = repository.getUser(email, password);
            event.setUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void registerUser(String firstName, String lastName, String email, String password) {
        RegisterUserEvent event = new RegisterUserEvent();
        try {
            long userId = repository.registerUser(firstName, lastName, email, password);
            event.setUserId(userId);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
