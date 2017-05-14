package hu.bme.iemqra.mobsoft.mobsoft.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.ExamInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.exam.UserInteractor;

@Module
public class InteractorModule {
    @Provides
    public UserInteractor provideUsers() {
        return new UserInteractor();
    }

    @Provides
    public ExamInteractor provideExams() {
        return new ExamInteractor();
    }


}
