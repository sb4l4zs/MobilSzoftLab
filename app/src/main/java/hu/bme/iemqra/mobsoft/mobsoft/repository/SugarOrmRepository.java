package hu.bme.iemqra.mobsoft.mobsoft.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public User getUser(String username, String password) {
        return SugarRecord.listAll(User.class).get(0);
    }

    @Override
    public long registerUser(String firstName, String lastName, String username, String password) {
        return 0;
    }

    @Override
    public void removeUser() {
        SugarRecord.deleteAll(User.class);
    }

    @Override
    public List<Exam> getExams(String userId) {
        return SugarRecord.listAll(Exam.class);
    }

    @Override
    public void addExam(Exam exam) {
        SugarRecord.saveInTx(exam);
    }

    @Override
    public void updateExams(List<Exam> exams) {
        List<Exam> examsToUpdate = getExams("");
        List<Exam> toUpdate = new ArrayList<>(examsToUpdate.size());
        for (Exam examToUpdate : examsToUpdate) {
            for (Exam exam : exams) {
                if (exam.getId().equals(examToUpdate.getId())) {
                    toUpdate.add(exam);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void updateExam(Exam exam) {
        Exam toUpdate = SugarRecord.findById(Exam.class, exam.getId());
        if (exam.getId().equals(toUpdate.getId())) {
            toUpdate = exam;
            SugarRecord.saveInTx(toUpdate);
        }
    }

    @Override
    public void removeExam(Exam exam) {
        SugarRecord.deleteInTx(exam);
    }

    @Override
    public boolean isInDB(Exam exam) {
        return SugarRecord.findById(Exam.class, exam.getId()) != null;
    }

}
