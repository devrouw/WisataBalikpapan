package com.hermawan.wisatabalikpapan.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hermawan.wisatabalikpapan.data.TravelRepository;
import com.hermawan.wisatabalikpapan.data.entity.About;

import java.util.List;

/*
 *
 * ViewModel berfungsi sebagai penyimpan fungsi yang berhubungan dengan data dari repository pada activity
 * ViewModel juga berguna agar kode pada Activity digunakan hanya sebagai kode pada tampilan
 * sedangkan ViewModel merupakan tempat kode untuk memanipulasi data
 *
 * */

public class AboutViewModel extends ViewModel {
    //Constructor
    private final TravelRepository travelRepository;
    public AboutViewModel(TravelRepository mTravelRepository) {
        this.travelRepository = mTravelRepository;
    }

    //Fungsi mendapatkan data about dari Repository menggunakan LiveData
    public LiveData<List<About>> getAbout() {
        return travelRepository.getAbout();
    }
}
