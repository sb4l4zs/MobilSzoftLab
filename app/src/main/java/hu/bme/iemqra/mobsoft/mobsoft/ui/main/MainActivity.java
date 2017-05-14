package hu.bme.iemqra.mobsoft.mobsoft.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.ui.detailed.DetailedActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;


    public static String loggedInUser;

    private Tracker mTracker;

    private RecyclerView recyclerViewExams;
    private TextView placeHolder;
    private FloatingActionButton fab;

    private List<Exam> examsList;
    private ExamsAdapter examsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);


        // Obtain the shared Tracker instance.
        MobSoftApplication application = (MobSoftApplication) getApplication();
        mTracker = application.getDefaultTracker();

        initScreen();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        mTracker.setScreenName("Image~MainActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_crash:
                crashIt();
                return true;
            case R.id.menu_logout:
                loggedInUser = null;
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void initScreen() {
        if (loggedInUser == null) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            fab = (FloatingActionButton) findViewById(R.id.main_fab);
            fab.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    newExam();
                }
            });

            placeHolder = (TextView) findViewById(R.id.main_list_placeholder);
            recyclerViewExams = (RecyclerView) findViewById(R.id.main_list_view);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerViewExams.setLayoutManager(llm);

            examsList = new ArrayList<>();
            examsAdapter = new ExamsAdapter(this, examsList);
            recyclerViewExams.setAdapter(examsAdapter);

            mainPresenter.getExams(loggedInUser);
        }
    }

    public void loadExams(List<Exam> exams) {
        examsList.clear();
        examsList.addAll(exams);
        examsAdapter.notifyDataSetChanged();

        if (examsList.isEmpty()) {
            recyclerViewExams.setVisibility(View.GONE);
            placeHolder.setVisibility(View.VISIBLE);
        } else {
            recyclerViewExams.setVisibility(View.VISIBLE);
            placeHolder.setVisibility(View.GONE);
        }
    }

    public void crashIt() {
        throw new RuntimeException("This is a crash");
    }

    public void newExam() {
        DetailedActivity.exam = null;
        startActivity(new Intent(this, DetailedActivity.class));
    }

    @Override
    public void showExams(List<Exam> examList) {
        loadExams(examList);
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
