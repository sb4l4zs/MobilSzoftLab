package hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events;


/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class RegisterUserEvent {
    private int code;
    private long userId;
    private Throwable throwable;

    public RegisterUserEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
