package com.hermawan.wisatabalikpapan.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
/*
 *
 *
 * Table Hotel untuk Database
 *
 * */

@Entity(tableName = "hotel")
public class Hotel implements Parcelable {

    //Deklarasi field untuk table

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idHotel")
    private int idHotel = 0;

    @ColumnInfo(name = "titleHotel")
    private String titleHotel;

    @ColumnInfo(name = "descHotel")
    private String descHotel;

    @ColumnInfo(name = "imageHotel")
    private String imageHotel;

    //Fungsi getter dan setter untuk Hotel

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getTitleHotel() {
        return titleHotel;
    }

    public void setTitleHotel(String titleHotel) {
        this.titleHotel = titleHotel;
    }

    public String getDescHotel() {
        return descHotel;
    }

    public void setDescHotel(String descHotel) {
        this.descHotel = descHotel;
    }

    public String getImageHotel() {
        return imageHotel;
    }

    public void setImageHotel(String imageHotel) {
        this.imageHotel = imageHotel;
    }

    //Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idHotel);
        dest.writeString(this.titleHotel);
        dest.writeString(this.descHotel);
        dest.writeString(this.imageHotel);
    }

    @Ignore
    public Hotel(){}

    public Hotel(String titleHotel, String descHotel, String imageHotel){
        this.titleHotel = titleHotel;
        this.descHotel = descHotel;
        this.imageHotel = imageHotel;
    }

    private Hotel(Parcel in) {
        this.idHotel = in.readInt();
        this.titleHotel = in.readString();
        this.descHotel = in.readString();
        this.imageHotel = in.readString();
    }

    public static final Parcelable.Creator<Hotel> CREATOR = new Parcelable.Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel source) {
            return new Hotel(source);
        }
        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };
}
