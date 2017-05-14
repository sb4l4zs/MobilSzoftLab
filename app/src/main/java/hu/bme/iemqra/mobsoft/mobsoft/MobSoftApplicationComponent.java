package hu.bme.iemqra.mobsoft.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.InteractorModule;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.ExamInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.UserInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.network.NetworkModule;
import hu.bme.iemqra.mobsoft.mobsoft.repository.RepositoryModule;
import hu.bme.iemqra.mobsoft.mobsoft.ui.UIModule;
import hu.bme.iemqra.mobsoft.mobsoft.ui.detailed.DetailedActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.detailed.DetailedPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.login.LoginActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.login.LoginPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.registration.RegistrationActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.registration.RegistrationPresenter;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, NetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(RegistrationActivity registrationActivity);

    void inject(DetailedActivity detailedActivity);

    void inject(UserInteractor userInteractor);

    void inject(ExamInteractor examInteractor);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainPresenter mainPresenter);

    void inject(LoginPresenter loginPresenter);

    void inject(RegistrationPresenter registrationPresenter);

    void inject(DetailedPresenter detailedPresenter);
}
