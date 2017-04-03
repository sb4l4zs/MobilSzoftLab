package hu.bme.iemqra.mobsoft.mobsoft.repository;

import android.content.Context;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

public class MemoryRepository implements Repository {
    private static final long MINUTE = 60 * 1000;

    public static List<Exam> exams;
    public static User user;

    @Override
    public void open(Context context) {
        Exam exam1 = new Exam(1L, "testelek@gmail.com", "Analizis 1", "masodik zh", "2017.03.20", "E1A", "wwww.analizis.bme.hu", true);
        Exam exam2 = new Exam(2L, "diak@bme.hu", "Ergonomia", "szabval cucc elso zh", "2017.04.20", "AUDMAX", "wwww.ergonomia.bme.hu", false);

        exams = new ArrayList<>();
        exams.add(exam1);
        exams.add(exam2);
    }

    @Override
    public void close() {

    }

    @Override
    public User getUser() { return user; }

    @Override
    public void removeUser() { user = null; }

    @Override
    public List<Exam> getExams() {
        return exams;
    }

    @Override
    public void saveExam(Exam exam) {
        exams.add(exam);
    }

    @Override
    public void updateExams(List<Exam> exams) {
        for (int i = 0; i < this.exams.size(); i++) {
            Exam favourite = this.exams.get(i);
            for (Exam exam : exams) {
                if (exam.getId().equals(favourite.getId())) {
                    this.exams.set(i, exam);
                }
            }
        }
    }

    @Override
    public void updateExam(Exam exam) {
        exams.set(Ints.checkedCast(exam.getId()), exam);
    }

    @Override
    public void removeExam(Exam exam) {
        exams.remove(exam);
    }

    @Override
    public boolean isInDB(Exam exam) {
        return exams.contains(exam);
    }
}
