package hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events;

import hu.bme.iemqra.mobsoft.mobsoft.model.User;


/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class LoginUserEvent {
    private int code;
    private User user;
    private Throwable throwable;

    public LoginUserEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
