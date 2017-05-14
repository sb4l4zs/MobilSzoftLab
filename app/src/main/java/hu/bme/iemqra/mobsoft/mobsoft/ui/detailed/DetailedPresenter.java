package hu.bme.iemqra.mobsoft.mobsoft.ui.detailed;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.ExamInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.RemoveExamEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.SaveExamEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.UpdateExamEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainActivity;

import static hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication.injector;
import static java.util.UUID.randomUUID;

public class DetailedPresenter extends Presenter<DetailedScreen> {
    @Inject
    ExamInteractor examInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(DetailedScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    void getDetailsByID(int id) {
    }

    void modifyExam(final Exam exam) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                examInteractor.updateExam(exam);
            }
        });
    }

    void addNewExam(final String title, final String description, final String date, final String place, final String pageUrl, final boolean global) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                examInteractor.addExam(new Exam(randomUUID().getMostSignificantBits() & Long.MAX_VALUE, MainActivity.loggedInUser, title, description, date, place, pageUrl, global));
            }
        });
    }

    void deleteExam(final Exam exam) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                examInteractor.removeExam(exam);
            }
        });
    }

    public void onEventMainThread(SaveExamEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError("Something went wrong!");
            }
        } else {
            if (screen != null) {
                if (event.getExam() != null) {
                    screen.addedOk("New exam added successfully!");
                } else {
                    screen.showError("Something went wrong!");
                }
            }
        }
    }

    public void onEventMainThread(RemoveExamEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError("Something went wrong!");
            }
        } else {
            if (screen != null) {
                if (event.getExam() != null) {
                    screen.removedOk("Exam removed successfully!");
                } else {
                    screen.showError("Something went wrong!");
                }
            }
        }
    }

    public void onEventMainThread(UpdateExamEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError("Something went wrong!");
            }
        } else {
            if (screen != null) {
                screen.modifiedOk("Exam modified successfully!");
            }
        }
    }
}
