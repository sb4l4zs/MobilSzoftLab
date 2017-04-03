package hu.bme.iemqra.mobsoft.mobsoft.interactor.exam;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.GetExamsEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.RemoveExamEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.SaveExamEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class ExamsInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public ExamsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getExams() {
        GetExamsEvent event = new GetExamsEvent();
        try {
            List<Exam> exams = repository.getExams();
            event.setExams(exams);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveExam(Exam exam) {

        SaveExamEvent event = new SaveExamEvent();
        event.setExam(exam);
        try {
            repository.saveExam(exam);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateExams(List<Exam> exams) {
        try {
            repository.updateExams(exams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeExam(Exam exam) {
        RemoveExamEvent event = new RemoveExamEvent();
        event.setExam(exam);
        try {
            repository.removeExam(exam);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
