package com.hermawan.wisatabalikpapan.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.hermawan.wisatabalikpapan.databinding.ActivityMainBinding;
import com.hermawan.wisatabalikpapan.session.Config;
import com.hermawan.wisatabalikpapan.ui.about.AboutActivity;
import com.hermawan.wisatabalikpapan.ui.list.ListActivity;

import java.util.Objects;
/*
 *
 * Activity Main menyimpan semua kode dari tampilan menu utama
 *
 * */
public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Menghilangkan toolbar
        Objects.requireNonNull(getSupportActionBar()).hide();

        //Kode pada tombol travel
        binding.btnTravel.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra(ListActivity.EXTRA_TYPE, "Travel");
            startActivity(intent);
        });

        //Kode pada tombol hotel
        binding.btnHotel.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra(ListActivity.EXTRA_TYPE, "Hotel");
            startActivity(intent);
        });

        //Kode pada tombol food
        binding.btnFood.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra(ListActivity.EXTRA_TYPE, "Food");
            startActivity(intent);
        });

        //Kode pada tombol event
        binding.btnEvent.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra(ListActivity.EXTRA_TYPE, "Event");
            startActivity(intent);
        });

        //Kode pada tombol akomodasi
//        binding.btnAccommodation.setOnClickListener(v -> {
//            Intent intent = new Intent(this, ListActivity.class);
//            intent.putExtra(ListActivity.EXTRA_TYPE, "Accommodation");
//            startActivity(intent);
//        });

        //Kode pada tombol about
        binding.btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        });
    }
}