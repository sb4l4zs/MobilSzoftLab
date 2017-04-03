package hu.bme.iemqra.mobsoft.mobsoft.interactor.exam;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.LoginUserEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.RegisterUserEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class UserInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void loginUser() {
        LoginUserEvent event = new LoginUserEvent();
        try {
            User user = repository.getUser();
            event.setUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void registerUser() {
        RegisterUserEvent event = new RegisterUserEvent();
        try {
            User user = repository.getUser();
            event.setUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
