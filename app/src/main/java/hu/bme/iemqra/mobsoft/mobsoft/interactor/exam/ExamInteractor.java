package hu.bme.iemqra.mobsoft.mobsoft.interactor.exam;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.GetExamsEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.RemoveExamEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.SaveExamEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.UpdateExamEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.AppApi;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;

/**
 * Created by Balazs on 2017. 05. 14..
 */

public class ExamInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    AppApi appApi;

    public ExamInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getExams(String userId) {
        GetExamsEvent event = new GetExamsEvent();
        try {
            List<Exam> exams = repository.getExams(userId);
            event.setExams(exams);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void addExam(Exam exam) {

        SaveExamEvent event = new SaveExamEvent();
        event.setExam(exam);
        try {
            repository.addExam(exam);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateExam(Exam exam) {
        UpdateExamEvent event = new UpdateExamEvent();
        try {
            repository.updateExam(exam);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
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
