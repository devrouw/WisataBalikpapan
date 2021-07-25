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
 * Table Travel untuk Database
 *
 * */

@Entity(tableName = "travel")
public class Travel implements Parcelable {

    //Deklarasi field untuk table

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTravel")
    private int idTravel = 0;

    @ColumnInfo(name = "titleTravel")
    private String titleTravel;

    @ColumnInfo(name = "descTravel")
    private String descTravel;

    @ColumnInfo(name = "imageTravel")
    private String imageTravel;

    //Fungsi getter dan setter untuk Travel

    public int getIdTravel() {
        return idTravel;
    }

    public void setIdTravel(int idTravel) {
        this.idTravel = idTravel;
    }

    public String getTitleTravel() {
        return titleTravel;
    }

    public void setTitleTravel(String titleTravel) {
        this.titleTravel = titleTravel;
    }

    public String getDescTravel() {
        return descTravel;
    }

    public void setDescTravel(String descTravel) {
        this.descTravel = descTravel;
    }

    public String getImageTravel() {
        return imageTravel;
    }

    public void setImageTravel(String imageTravel) {
        this.imageTravel = imageTravel;
    }

    //Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idTravel);
        dest.writeString(this.titleTravel);
        dest.writeString(this.descTravel);
        dest.writeString(this.imageTravel);
    }

    @Ignore
    public Travel(){}

    public Travel(String titleTravel, String descTravel, String imageTravel){
        this.titleTravel = titleTravel;
        this.descTravel = descTravel;
        this.imageTravel = imageTravel;
    }

    private Travel(Parcel in) {
        this.idTravel = in.readInt();
        this.titleTravel = in.readString();
        this.descTravel = in.readString();
        this.imageTravel = in.readString();
    }

    public static final Parcelable.Creator<Travel> CREATOR = new Parcelable.Creator<Travel>() {
        @Override
        public Travel createFromParcel(Parcel source) {
            return new Travel(source);
        }
        @Override
        public Travel[] newArray(int size) {
            return new Travel[size];
        }
    };
}
