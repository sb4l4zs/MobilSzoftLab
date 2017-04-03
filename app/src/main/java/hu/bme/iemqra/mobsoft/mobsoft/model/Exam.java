package hu.bme.iemqra.mobsoft.mobsoft.model;

import com.orm.dsl.Table;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

@Table
public class Exam {
    private Long id = null;
    private String userId;
    private String title;
    private String description;
    private String date;
    private String place;
    private String pageUrl;
    private boolean isGlobal;

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
