package com.hermawan.wisatabalikpapan.ui.about;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.hermawan.wisatabalikpapan.R;
import com.hermawan.wisatabalikpapan.data.entity.About;
import com.hermawan.wisatabalikpapan.databinding.ActivityAboutBinding;
import com.hermawan.wisatabalikpapan.ui.ViewModelFactory;

import java.util.Objects;

/*
 *
 * Activity About menyimpan semua kode dari tampilan menu about
 *
 * */


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAboutBinding binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Mengubah toolbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.about));

        //Memanggil viewmodel
        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        AboutViewModel viewModel = new ViewModelProvider(this, factory).get(AboutViewModel.class);

        //Memanggil data about untuk ditampilkan
        viewModel.getAbout().observe(this, data -> {
            binding.pb.setVisibility(View.GONE);
            binding.groupContent.setVisibility(View.VISIBLE);
            About about = data.get(0);
            binding.tvTitleAbout.setText(about.getName());
            binding.tvAddress.setText(about.getAddress());
            binding.tvContact.setText(about.getContact());
            binding.tvVision.setText(about.getVision());
            binding.tvMission.setText(about.getMission());
        });
    }

    //Fungsi untuk tombol kembali pada toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            this.finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}