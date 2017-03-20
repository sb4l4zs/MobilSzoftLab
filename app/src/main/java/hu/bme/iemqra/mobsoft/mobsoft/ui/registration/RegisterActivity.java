package hu.bme.iemqra.mobsoft.mobsoft.ui.registration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class RegisterActivity extends AppCompatActivity implements RegisterSceen {
    @Inject
    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    public void registerUser(String firstName, String lastName, String email, String password) {

    }
}
