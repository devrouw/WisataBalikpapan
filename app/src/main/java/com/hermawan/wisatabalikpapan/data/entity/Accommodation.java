package com.hermawan.wisatabalikpapan.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/*
*
* Table Accommodation untuk Database
*
* */

@Entity(tableName = "accommodation")
public class Accommodation implements Parcelable {

    //Deklarasi field pada table

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idAccommodation")
    private int idAccommodation = 0;

    @ColumnInfo(name = "titleAccommodation")
    private String titleAccommodation;

    @ColumnInfo(name = "descAccommodation")
    private String descAccommodation;

    @ColumnInfo(name = "imageAccommodation")
    private String imageAccommodation;

    //Fungsi getter dan setter untuk Accommodation

    public int getIdAccommodation() {
        return idAccommodation;
    }

    public void setIdAccommodation(int idAccommodation) {
        this.idAccommodation = idAccommodation;
    }

    public String getTitleAccommodation() {
        return titleAccommodation;
    }

    public void setTitleAccommodation(String titleAccommodation) {
        this.titleAccommodation = titleAccommodation;
    }

    public String getDescAccommodation() {
        return descAccommodation;
    }

    public void setDescAccommodation(String descAccommodation) {
        this.descAccommodation = descAccommodation;
    }

    public String getImageAccommodation() {
        return imageAccommodation;
    }

    public void setImageAccommodation(String imageAccommodation) {
        this.imageAccommodation = imageAccommodation;
    }

    //Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idAccommodation);
        dest.writeString(this.titleAccommodation);
        dest.writeString(this.descAccommodation);
        dest.writeString(this.imageAccommodation);
    }

    @Ignore
    public Accommodation(){}

    public Accommodation(String titleAccommodation, String descAccommodation, String imageAccommodation){
        this.titleAccommodation = titleAccommodation;
        this.descAccommodation = descAccommodation;
        this.imageAccommodation = imageAccommodation;
    }

    private Accommodation(Parcel in) {
        this.idAccommodation = in.readInt();
        this.titleAccommodation = in.readString();
        this.descAccommodation = in.readString();
        this.imageAccommodation = in.readString();
    }

    public static final Parcelable.Creator<Accommodation> CREATOR = new Parcelable.Creator<Accommodation>() {
        @Override
        public Accommodation createFromParcel(Parcel source) {
            return new Accommodation(source);
        }
        @Override
        public Accommodation[] newArray(int size) {
            return new Accommodation[size];
        }
    };
}
