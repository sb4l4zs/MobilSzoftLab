package hu.bme.iemqra.mobsoft.mobsoft.network.api;

import java.math.BigDecimal;
import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

public interface ExamAppApi {
    /**
     *
     * Add new exam.
     * @param userId Publisher id.
     * @param title Exam title.
     * @param description Exam description.
     * @param date Exam date.
     * @param place Exam place.
     * @param pageUrl Exam webpage.
     * @param isGlobal Exam is global or not.
     * @return Call<Exam>
     */

    @POST("Exams/AddExam")
    Call<Exam> examsAddExamPost(
            @Query("userId") BigDecimal userId, @Query("title") String title, @Query("description") String description, @Query("date") String date, @Query("place") String place, @Query("pageUrl") String pageUrl, @Query("isGlobal") Boolean isGlobal
    );


    /**
     *
     * Get exam details.
     * @param id Exam id.
     * @return Call<Exam>
     */

    @GET("Exams/GetExamDetails")
    Call<Exam> examsGetExamDetailsGet(
            @Query("id") BigDecimal id
    );


    /**
     *
     * Get exams belonging to user.
     * @param email User email.
     * @param from From index.
     * @param count Query amount.
     * @return Call<List<Exam>>
     */

    @GET("Exams/GetExamsByUser")
    Call<List<Exam>> examsGetExamsByUserGet(
            @Query("email") String email, @Query("from") BigDecimal from, @Query("count") BigDecimal count
    );


    /**
     *
     * Delete exam by exam id.
     * @param id Exam id.
     * @return Call<Void>
     */

    @DELETE("Exams/RemoveExam")
    Call<Void> examsRemoveExamDelete(
            @Query("id") BigDecimal id
    );


    /**
     *
     * Update existing exam.
     * @param title Exam title.
     * @param description Exam description.
     * @param date Exam date.
     * @param place Exam place.
     * @param pageUrl Exam webpage.
     * @param isGlobal Exam is global or not.
     * @return Call<Exam>
     */

    @POST("Exams/UpdateExam")
    Call<Exam> examsUpdateExamPost(
            @Query("title") String title, @Query("description") String description, @Query("date") String date, @Query("place") String place, @Query("pageUrl") String pageUrl, @Query("isGlobal") Boolean isGlobal
    );


    /**
     *
     * User login call
     * @param email User email.
     * @param password User password.
     * @return Call<User>
     */

    @GET("User/Login")
    Call<User> userLoginGet(
            @Query("email") String email, @Query("password") String password
    );


    /**
     *
     * User login call
     * @param email User email.
     * @param password User password.
     * @param firstName User first name.
     * @param lastName User last name.
     * @return Call<User>
     */

    @POST("User/Register")
    Call<User> userRegisterPost(
            @Query("email") String email, @Query("password") String password, @Query("firstName") String firstName, @Query("lastName") String lastName
    );


}
