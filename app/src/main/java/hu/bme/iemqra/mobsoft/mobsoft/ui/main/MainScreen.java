package hu.bme.iemqra.mobsoft.mobsoft.ui.main;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;

public interface MainScreen {
    void showMessage(String text);

    void showExams(List<Exam> examList);
}
