package hu.bme.iemqra.mobsoft.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.iemqra.mobsoft.mobsoft.ui.UIModule;
import hu.bme.iemqra.mobsoft.mobsoft.ui.details.DetailsActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.login.LoginActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.registration.RegisterActivity;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(RegisterActivity registerActivity);

    void inject(DetailsActivity detailsActivity);
}