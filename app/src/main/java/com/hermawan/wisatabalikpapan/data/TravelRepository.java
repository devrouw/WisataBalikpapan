package com.hermawan.wisatabalikpapan.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.hermawan.wisatabalikpapan.data.entity.About;
import com.hermawan.wisatabalikpapan.data.entity.Accommodation;
import com.hermawan.wisatabalikpapan.data.entity.Event;
import com.hermawan.wisatabalikpapan.data.entity.Food;
import com.hermawan.wisatabalikpapan.data.entity.Hotel;
import com.hermawan.wisatabalikpapan.data.entity.Travel;

import java.util.List;

/*
 *
 * Class repository yang berfungsi untuk jembatan antara backend dan frontend.
 * Repository juga digunakan untuk memudahkan bila ada data yang didapat dari internet bisa ditampung lewat sini terlebih dahulu.
 * dengan kata lain apabila ada 2 sumber data yaitu local dan remote, repository lah yang akan menghandle data mana yang akan ditampilkan.
 *
 * */

public class TravelRepository {
    private static TravelRepository INSTANCE;
    private final TravelDao travelDao;

    public TravelRepository(TravelDao travelDao) {
        this.travelDao = travelDao;
    }

    public static TravelRepository getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TravelRepository.class) {
                if (INSTANCE == null) {
                    TravelDatabase travelDatabase = TravelDatabase.getDatabase(context);
                    INSTANCE = new TravelRepository(travelDatabase.travelDao());
                }
                return INSTANCE;
            }
        }
        return INSTANCE;
    }

    public LiveData<List<Travel>> getTravel() {
        return travelDao.getTravel();
    }

    public LiveData<List<Hotel>> getHotel() {
        return travelDao.getHotel();
    }

    public LiveData<List<Food>> getFood() {
        return travelDao.getFood();
    }

    public LiveData<List<Event>> getEvent() {
        return travelDao.getEvent();
    }

    public LiveData<List<Accommodation>> getAccommodation() {
        return travelDao.getAccommodation();
    }

    public LiveData<List<About>> getAbout() {
        return travelDao.getAbout();
    }
}
