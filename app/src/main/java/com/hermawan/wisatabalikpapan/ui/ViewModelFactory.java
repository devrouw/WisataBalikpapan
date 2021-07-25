package com.hermawan.wisatabalikpapan.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.hermawan.wisatabalikpapan.data.TravelRepository;
import com.hermawan.wisatabalikpapan.ui.about.AboutViewModel;
import com.hermawan.wisatabalikpapan.ui.list.ListViewModel;
/*
 *
 * Kelas untuk memudahkan pemanggilan ViewModel pada setiap Activity
 *
 * */
public class ViewModelFactory implements ViewModelProvider.Factory {
    private static volatile ViewModelFactory INSTANCE;
    private final TravelRepository mTravelRepository;

    private ViewModelFactory(TravelRepository travelRepository) {
        mTravelRepository = travelRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(TravelRepository.getInstance(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        //Jika ingin menambahkan viewmodel baru maka tambahkanlah disini
        if (modelClass.isAssignableFrom(ListViewModel.class)) {
            return (T) new ListViewModel(mTravelRepository);
        } else if (modelClass.isAssignableFrom(AboutViewModel.class)) {
            return (T) new AboutViewModel(mTravelRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
