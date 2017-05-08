package hu.bme.iemqra.mobsoft.mobsoft.model;

import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("code")
    private Integer code = null;

    @SerializedName("message")
    private String message = null;

    @SerializedName("fields")
    private String fields = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}
