package com.hermawan.wisatabalikpapan.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RegisterData{
    @SerializedName("code")
    private String code;
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private String data;
    @SerializedName("message")
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}