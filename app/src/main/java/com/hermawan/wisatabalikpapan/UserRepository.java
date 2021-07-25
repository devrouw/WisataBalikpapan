package com.hermawan.wisatabalikpapan;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.hermawan.wisatabalikpapan.data.TravelDao;
import com.hermawan.wisatabalikpapan.data.TravelDatabase;
import com.hermawan.wisatabalikpapan.data.TravelRepository;
import com.hermawan.wisatabalikpapan.data.entity.About;
import com.hermawan.wisatabalikpapan.data.entity.Accommodation;
import com.hermawan.wisatabalikpapan.data.entity.Event;
import com.hermawan.wisatabalikpapan.data.entity.Food;
import com.hermawan.wisatabalikpapan.data.entity.Hotel;
import com.hermawan.wisatabalikpapan.data.entity.Travel;
import com.hermawan.wisatabalikpapan.model.RegisterData;
import com.hermawan.wisatabalikpapan.util.BaseApiService;
import com.hermawan.wisatabalikpapan.util.UtilsApi;

import java.util.List;

public class UserRepository {
    private static UserRepository INSTANCE;
    private final BaseApiService mApiService;

    public UserRepository(BaseApiService mApiService) {
        this.mApiService = mApiService;
    }

    public static UserRepository getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TravelRepository.class) {
                if (INSTANCE == null) {
                    BaseApiService mApiService = UtilsApi.getAPIService(context);
                    INSTANCE = new UserRepository(mApiService);
                }
                return INSTANCE;
            }
        }
        return INSTANCE;
    }

//    public LiveData<RegisterData> doRegister(String name, String email, String password) {
//        return mApiService.register("daftar",name, email, password);
//    }
}
