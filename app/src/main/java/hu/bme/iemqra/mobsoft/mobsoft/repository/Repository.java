package hu.bme.iemqra.mobsoft.mobsoft.repository;

import android.content.Context;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;

public interface Repository {

    void open(Context context);

    void close();

    User getUser(String username, String password);

    long registerUser(String firstName, String lastName, String username, String password);

    void removeUser();

    List<Exam> getExams(String userId);

    void addExam(Exam exam);

    void updateExams(List<Exam> exams);

    void updateExam(Exam exam);

    void removeExam(Exam exam);

    boolean isInDB(Exam exam);
}
