package hu.bme.iemqra.mobsoft.mobsoft.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.registration.RegistrationActivity;


public class LoginActivity extends AppCompatActivity implements LoginScreen {
    @Inject
    LoginPresenter loginPresenter;

    EditText userMail;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userMail = (EditText) findViewById(R.id.activity_login_username);
        password = (EditText) findViewById(R.id.activity_login_password);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }


    @Override
    public void userLoginOK(String userId) {
        MainActivity.loggedInUser = userId;
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void userLoginFailed(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void login(View view) {
        loginPresenter.loginUser(userMail.getText().toString(), password.getText().toString());
    }

    public void navigateToRegistration(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }
}