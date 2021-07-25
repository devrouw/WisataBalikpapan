package com.hermawan.wisatabalikpapan.ui.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hermawan.wisatabalikpapan.data.TravelRepository;
import com.hermawan.wisatabalikpapan.data.entity.Accommodation;
import com.hermawan.wisatabalikpapan.data.entity.Event;
import com.hermawan.wisatabalikpapan.data.entity.Food;
import com.hermawan.wisatabalikpapan.data.entity.Hotel;
import com.hermawan.wisatabalikpapan.data.entity.Travel;

import java.util.List;

public class ListViewModel extends ViewModel {

    //Constructor
    private final TravelRepository travelRepository;
    public ListViewModel(TravelRepository mTravelRepository) {
        this.travelRepository = mTravelRepository;
    }

    //Fungsi untuk mendapatkan data Travel dari Repository
    public LiveData<List<Travel>> getTravel() {
        return travelRepository.getTravel();
    }

    //Fungsi untuk mendapatkan data Hotel dari Repository
    public LiveData<List<Hotel>> getHotel() {
        return travelRepository.getHotel();
    }

    //Fungsi untuk mendapatkan data Food dari Repository
    public LiveData<List<Food>> getFood() {
        return travelRepository.getFood();
    }

    //Fungsi untuk mendapatkan data Event dari Repository
    public LiveData<List<Event>> getEvent() {
        return travelRepository.getEvent();
    }

    //Fungsi untuk mendapatkan data Accommodation dari Repository
    public LiveData<List<Accommodation>> getAccommodation() {
        return travelRepository.getAccommodation();
    }
}
