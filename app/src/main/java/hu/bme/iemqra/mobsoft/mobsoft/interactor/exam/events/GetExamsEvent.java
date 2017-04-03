package hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class GetExamsEvent {
    private int code;
    private List<Exam> exams;
    private Throwable throwable;

    public GetExamsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
