package hu.bme.iemqra.mobsoft.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.InteractorModule;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.ExamsInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.repository.RepositoryModule;
import hu.bme.iemqra.mobsoft.mobsoft.ui.UIModule;
import hu.bme.iemqra.mobsoft.mobsoft.ui.details.DetailsActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.login.LoginActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.registration.RegisterActivity;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(RegisterActivity registerActivity);

    void inject(DetailsActivity detailsActivity);

    void inject(ExamsInteractor examsInteractor);
}