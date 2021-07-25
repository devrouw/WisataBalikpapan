package com.hermawan.wisatabalikpapan.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListTravel {
    @SerializedName("code")
    private String code;
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private ArrayList<Travel> dataList;
    @SerializedName("message")
    private String message;

    public ArrayList<Travel> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<Travel> dataList) {
        this.dataList = dataList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
