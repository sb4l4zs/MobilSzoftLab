package hu.bme.iemqra.mobsoft.mobsoft.ui.registration;

import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class RegisterPresenter extends Presenter<RegisterSceen> {
    public RegisterPresenter() {
    }

    @Override
    public void attachScreen(RegisterSceen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    void registerUser(String firstName, String lastName, String email, String password){}
}
