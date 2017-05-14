package hu.bme.iemqra.mobsoft.mobsoft.ui.login;


public interface LoginScreen {
    void userLoginOK(String userId);

    void userLoginFailed(String text);
}
