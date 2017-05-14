package hu.bme.iemqra.mobsoft.mobsoft.repository;

import android.content.Context;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;

import static java.util.UUID.randomUUID;

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60 * 1000;

    public static List<Exam> exams;
    public static List<User> users;

    @Override
    public void open(Context context) {

        Exam exam1 = new Exam(1L, "testelek@gmail.com", "Analizis 1", "masodik zh", "2017.03.20", "E1A", "wwww.analizis.bme.hu", true);
        Exam exam2 = new Exam(2L, "diak@bme.hu", "Ergonomia", "szabval cucc elso zh", "2017.04.20", "AUDMAX", "wwww.ergonomia.bme.hu", false);
        Exam exam3 = new Exam(3L, "a@b.c", "Ergonomia 1", "szabval cucc elso zh", "2017.03.20", "AUDMAX", "wwww.ergonomia.bme.hu", false);
        Exam exam4 = new Exam(4L, "a@b.c", "Ergonomia 2", "szabval cucc elso zh", "2017.04.20", "AUDMAX", "wwww.ergonomia.bme.hu", false);
        Exam exam5 = new Exam(5L, "a@b.c", "Ergonomia 3", "szabval cucc elso zh", "2017.05.20", "AUDMAX", "wwww.ergonomia.bme.hu", false);

        exams = new ArrayList<>();
        exams.add(exam1);
        exams.add(exam2);
        exams.add(exam3);
        exams.add(exam4);
        exams.add(exam5);

        User user1 = new User(1L, "teszt", "elek", "1234", "teszt@elek.hu");
        User user2 = new User(3L, "asdf", "jkle", "asdf", "a@b.c");

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }

    @Override
    public void close() {

    }

    @Override
    public User getUser(String userMail, String password) {
        for (User user : users) {
            if (user.getEmail().equals(userMail)) {
                if (user.getPassword().equals(password)) {
                    return user;
                } else
                    return null;
            }
        }
        return null;
    }

    @Override
    public long registerUser(String firstName, String lastName, String userMail, String password) {
        for (User user : users) {
            if (user.getEmail().equals(userMail)) {
                return 0;
            }
        }
        long id = randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        users.add(new User(id, firstName, lastName, userMail, password));
        return id;
    }

    @Override
    public void removeUser() {
    }

    @Override
    public List<Exam> getExams(String userId) {
        List<Exam> examsForUser = new ArrayList<>();
        for (Exam exam : exams) {
            if (exam.getUserId().equals(userId) || exam.isGlobal()) {
                examsForUser.add(exam);
            }
        }
        return examsForUser;
    }

    @Override
    public void addExam(Exam exam) {
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

