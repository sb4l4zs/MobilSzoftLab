package hu.bme.iemqra.mobsoft.mobsoft.repository;

import android.content.Context;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public interface Repository {
    void open(Context context);

    void close();

    List<Exam> getExams();

    void saveExam(Exam exam);

    void updateExams(List<Exam> exams);

    void updateExam(Exam exam);

    void removeExam(Exam exam);

    boolean isInDB(Exam exam);
}
