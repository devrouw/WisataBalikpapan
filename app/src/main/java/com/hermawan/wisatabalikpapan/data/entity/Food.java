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
 * Table Food untuk Database
 *
 * */

@Entity(tableName = "food")
public class Food implements Parcelable {

    //Deklarasi field untuk table

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idFood")
    private int idFood = 0;

    @ColumnInfo(name = "titleFood")
    private String titleFood;

    @ColumnInfo(name = "descFood")
    private String descFood;

    @ColumnInfo(name = "imageFood")
    private String imageFood;

    //Fungsi getter dan setter untuk Food

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public String getTitleFood() {
        return titleFood;
    }

    public void setTitleFood(String titleFood) {
        this.titleFood = titleFood;
    }

    public String getDescFood() {
        return descFood;
    }

    public void setDescFood(String descFood) {
        this.descFood = descFood;
    }

    public String getImageFood() {
        return imageFood;
    }

    public void setImageFood(String imageFood) {
        this.imageFood = imageFood;
    }

    //Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idFood);
        dest.writeString(this.titleFood);
        dest.writeString(this.descFood);
        dest.writeString(this.imageFood);
    }

    @Ignore
    public Food(){}

    public Food(String titleFood, String descFood, String imageFood){
        this.titleFood = titleFood;
        this.descFood = descFood;
        this.imageFood = imageFood;
    }

    private Food(Parcel in) {
        this.idFood = in.readInt();
        this.titleFood = in.readString();
        this.descFood = in.readString();
        this.imageFood = in.readString();
    }

    public static final Parcelable.Creator<Food> CREATOR = new Parcelable.Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel source) {
            return new Food(source);
        }
        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };
}
