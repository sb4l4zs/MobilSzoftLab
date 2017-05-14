package hu.bme.iemqra.mobsoft.mobsoft.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.ui.login.LoginActivity;

public class RegistrationActivity extends AppCompatActivity implements RegistrationScreen {
    @Inject
    RegistrationPresenter registerPresenter;

    EditText firstName;
    EditText lastName;
    EditText userMail;
    EditText password;
    EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstName = (EditText) findViewById(R.id.activity_register_fname);
        lastName = (EditText) findViewById(R.id.activity_register_lname);
        userMail = (EditText) findViewById(R.id.activity_register_mail);
        password = (EditText) findViewById(R.id.activity_register_password);
        confirmPassword = (EditText) findViewById(R.id.activity_register_confirmPassword);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        registerPresenter.detachScreen();
    }


    @Override
    public void registrationOK() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void showError(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void registration(View view) {
        registerPresenter.registerUser(firstName.getText().toString(), lastName.getText().toString(), userMail.getText().toString(), password.getText().toString());
    }

    public void navigateToLogin(View view) {
        registrationOK();
    }
}