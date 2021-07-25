package com.hermawan.wisatabalikpapan.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hermawan.wisatabalikpapan.UserRepository;
import com.hermawan.wisatabalikpapan.data.TravelRepository;
import com.hermawan.wisatabalikpapan.data.entity.About;

import java.util.List;

public class UserViewModel extends ViewModel {
    //Constructor
    private final UserRepository userRepository;
    public UserViewModel(UserRepository mUserRepository) {
        this.userRepository = mUserRepository;
    }


}
