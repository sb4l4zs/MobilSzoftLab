package hu.bme.iemqra.mobsoft.mobsoft.ui.detailed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainActivity;

public class DetailedActivity extends AppCompatActivity implements DetailedScreen {
    @Inject
    DetailedPresenter detailsPresenter;

    public static Exam exam;

    private EditText title;
    private EditText description;
    private EditText date;
    private EditText place;
    private EditText url;
    private CheckBox global;
    private Button delete;
    private Button modify;
    private Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        MobSoftApplication.injector.inject(this);

        title = (EditText) findViewById(R.id.detail_title_field);
        description = (EditText) findViewById(R.id.detail_desc_field);
        date = (EditText) findViewById(R.id.detail_date_field);
        place = (EditText) findViewById(R.id.detail_place_field);
        url = (EditText) findViewById(R.id.detail_page_field);
        global = (CheckBox) findViewById(R.id.detail_global_checkbox_field);

        delete = (Button) findViewById(R.id.detail_button_delete);
        modify = (Button) findViewById(R.id.detail_button_modify);
        add = (Button) findViewById(R.id.detail_button_add);

        initScreen();
    }

    private void initScreen() {
        if (exam == null) {
            delete.setEnabled(false);
            modify.setEnabled(false);
            add.setEnabled(true);
        } else {
            delete.setEnabled(true);
            modify.setEnabled(true);
            add.setEnabled(false);

            title.setText(exam.getTitle());
            description.setText(exam.getDescription());
            date.setText(exam.getDate());
            place.setText(exam.getPlace());
            url.setText(exam.getPageUrl());
            global.setActivated(exam.isGlobal());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }


    @Override
    public void showDetails() {

    }

    @Override
    public void showError(String text) {

    }

    @Override
    public void addedOk(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void removedOk(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void modifiedOk(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void modifyExam(View view) {
        exam.setTitle(title.getText().toString());
        exam.setDescription(description.getText().toString());
        exam.setDate(date.getText().toString());
        exam.setPlace(place.getText().toString());
        exam.setPageUrl(url.getText().toString());
        exam.setGlobal(global.isChecked());
        detailsPresenter.modifyExam(exam);
    }

    public void deleteExam(View view) {
        detailsPresenter.deleteExam(exam);
    }

    public void addNewExam(View view) {
        detailsPresenter.addNewExam(title.getText().toString(), description.getText().toString(), date.getText().toString(), place.getText().toString(), url.getText().toString(), global.isChecked());
    }
}
