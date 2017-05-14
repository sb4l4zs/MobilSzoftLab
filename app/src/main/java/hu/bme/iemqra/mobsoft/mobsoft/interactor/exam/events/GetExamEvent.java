package hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events;

import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;


public class GetExamEvent {
    private int code;
    private Exam exam;
    private Throwable throwable;

    public GetExamEvent() {
    }

    public GetExamEvent(int code, Exam exam, Throwable throwable) {
        this.code = code;
        this.exam = exam;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
