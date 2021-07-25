package com.hermawan.wisatabalikpapan.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
/*
 *
 * Table Event untuk Database
 *
 * */

@Entity(tableName = "event")
public class Event implements Parcelable {

    //Deklarasi field untuk table

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idEvent")
    private int idEvent = 0;

    @ColumnInfo(name = "titleEvent")
    private String titleEvent;

    @ColumnInfo(name = "descEvent")
    private String descEvent;

    @ColumnInfo(name = "imageEvent")
    private String imageEvent;

    //Fungsi getter dan setter untuk Event

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getTitleEvent() {
        return titleEvent;
    }

    public void setTitleEvent(String titleEvent) {
        this.titleEvent = titleEvent;
    }

    public String getDescEvent() {
        return descEvent;
    }

    public void setDescEvent(String descEvent) {
        this.descEvent = descEvent;
    }

    public String getImageEvent() {
        return imageEvent;
    }

    public void setImageEvent(String imageEvent) {
        this.imageEvent = imageEvent;
    }

    //Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idEvent);
        dest.writeString(this.titleEvent);
        dest.writeString(this.descEvent);
        dest.writeString(this.imageEvent);
    }

    @Ignore
    public Event(){}

    public Event(String titleEvent, String descEvent, String imageEvent){
        this.titleEvent = titleEvent;
        this.descEvent = descEvent;
        this.imageEvent = imageEvent;
    }

    private Event(Parcel in) {
        this.idEvent = in.readInt();
        this.titleEvent = in.readString();
        this.descEvent = in.readString();
        this.imageEvent = in.readString();
    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }
        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
