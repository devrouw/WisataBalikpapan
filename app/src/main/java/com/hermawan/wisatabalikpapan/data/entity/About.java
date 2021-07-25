package com.hermawan.wisatabalikpapan.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
/*
*
* Table About untuk Database
*
* */

@Entity(tableName = "about")
public class About {

    //Deklarasi field pada table

    @PrimaryKey
    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "contact")
    private String contact;

    @ColumnInfo(name = "vision")
    private String vision;

    @ColumnInfo(name = "mission")
    private String mission;

    //Fungsi getter dan setter untuk About

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
