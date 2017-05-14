package hu.bme.iemqra.mobsoft.mobsoft.ui.main;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.ExamInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.events.GetExamsEvent;
import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;

import static hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication.injector;


public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    ExamInteractor examInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getExams(final String userId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                examInteractor.getExams(userId);
            }
        });
    }

    public void onEventMainThread(GetExamsEvent event) {
        Log.d("test", "test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showExams(event.getExams());
            }
        }
    }

}
