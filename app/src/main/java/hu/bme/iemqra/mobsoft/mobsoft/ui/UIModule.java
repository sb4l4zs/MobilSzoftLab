package hu.bme.iemqra.mobsoft.mobsoft.ui;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.iemqra.mobsoft.mobsoft.ui.details.DetailsPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.login.LoginPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.registration.RegisterPresenter;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

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
    public RegisterPresenter provideRegisterPresenter() {
        return new RegisterPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }
}
