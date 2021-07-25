package com.hermawan.wisatabalikpapan.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hermawan.wisatabalikpapan.data.entity.About;
import com.hermawan.wisatabalikpapan.data.entity.Accommodation;
import com.hermawan.wisatabalikpapan.data.entity.Event;
import com.hermawan.wisatabalikpapan.data.entity.Food;
import com.hermawan.wisatabalikpapan.data.entity.Hotel;
import com.hermawan.wisatabalikpapan.data.entity.Travel;

import java.util.List;
/*
 *
 * Interface untuk menyimpan query2 yang akan dibutuhkan pada aplikasi
 *
 * */

@Dao
public interface TravelDao {
    @Query("SELECT * FROM travel")
    LiveData<List<Travel>> getTravel();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllTravel(Travel travel);

    @Query("SELECT * FROM hotel")
    LiveData<List<Hotel>> getHotel();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllHotel(Hotel hotel);

    @Query("SELECT * FROM food")
    LiveData<List<Food>> getFood();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllFood(Food food);

    @Query("SELECT * FROM event")
    LiveData<List<Event>> getEvent();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllEvent(Event event);

    @Query("SELECT * FROM accommodation")
    LiveData<List<Accommodation>> getAccommodation();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllAccommodation(Accommodation accommodation);

    @Query("SELECT * FROM about")
    LiveData<List<About>> getAbout();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllAbout(About about);
}
