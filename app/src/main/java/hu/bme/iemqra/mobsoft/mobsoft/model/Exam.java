package hu.bme.iemqra.mobsoft.mobsoft.model;

import com.orm.dsl.Table;

import com.google.gson.annotations.SerializedName;


@Table
public class Exam {
    @SerializedName("id")
    private Long id = null;

    @SerializedName("userId")
    private String userId = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("date")
    private String date = null;

    @SerializedName("place")
    private String place = null;

    @SerializedName("pageUrl")
    private String pageUrl = null;

    @SerializedName("isGlobal")
    private Boolean isGlobal = null;

    public Exam() {
    }

    public Exam(Long id, String userId, String title, String description, String date, String place, String pageUrl, boolean isGlobal) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.place = place;
        this.pageUrl = pageUrl;
        this.isGlobal = isGlobal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setGlobal(boolean global) {
        isGlobal = global;
    }
}
