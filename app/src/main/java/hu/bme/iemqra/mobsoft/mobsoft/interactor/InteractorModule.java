package hu.bme.iemqra.mobsoft.mobsoft.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.ExamsInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.UserInteractor;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

@Module
public class InteractorModule {
    @Provides
    public ExamsInteractor provideExams() {
        return new ExamsInteractor();
    }

    @Provides
    public UserInteractor provideUser() {
        return new UserInteractor();
    }
}
