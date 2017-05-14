package hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events;

public class UpdateExamEvent {
    private int code;
    private String text;
    private Throwable throwable;

    public UpdateExamEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public UpdateExamEvent(int code, String text, Throwable throwable) {

        this.code = code;
        this.text = text;
        this.throwable = throwable;
    }
}
