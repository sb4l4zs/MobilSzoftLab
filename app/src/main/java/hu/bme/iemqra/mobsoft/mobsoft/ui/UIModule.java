package hu.bme.iemqra.mobsoft.mobsoft.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.ui.detailed.DetailedPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.login.LoginPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.registration.RegistrationPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public RegistrationPresenter provideRegistrationPresenter() {
        return new RegistrationPresenter();
    }

    @Provides
    @Singleton
    public DetailedPresenter provideDetailedPresenter() {
        return new DetailedPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }


}
