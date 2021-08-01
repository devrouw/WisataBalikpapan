package com.hermawan.wisatabalikpapan.ui.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.hermawan.wisatabalikpapan.data.entity.Accommodation;
import com.hermawan.wisatabalikpapan.data.entity.Event;
import com.hermawan.wisatabalikpapan.data.entity.Food;
import com.hermawan.wisatabalikpapan.data.entity.Hotel;
import com.hermawan.wisatabalikpapan.databinding.ActivityDetailBinding;
import com.hermawan.wisatabalikpapan.model.Travel;
import com.hermawan.wisatabalikpapan.util.Constant;
import com.hermawan.wisatabalikpapan.util.DateFormat;

import java.util.Objects;
/*
 *
 * Activity Detail menyimpan semua kode dari tampilan menu detail
 *
 * */
public class DetailActivity extends AppCompatActivity {
    //Deklarasi variabel untuk passing data dari menu list ke menu detail
    public static final String EXTRA_TYPE = "extra_type";
    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Mengubah tampilan toolbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //Mengambil data hasil passing dari menu list
        String type = getIntent().getStringExtra(EXTRA_TYPE);
        if (type != null) {
            //Menampilkan tampilan konten dan menyembunyikan loading
            binding.pbDetail.setVisibility(View.GONE);
            binding.groupContentDetail.setVisibility(View.VISIBLE);
            //Menampilkan data sesuai tipe ke tampilan UI
            switch (type){
                case "Travel":
                case "Accommodation":
                    //Make layout invisible
                    binding.cvLokasi.setVisibility(View.GONE);
                    binding.btnOrder.setVisibility(View.GONE);
                    //---------------------

                    Travel travel = getIntent().getParcelableExtra(EXTRA_DATA);
                    Glide.with(this)
                            .load(Constant.IMAGE_TRAVEL + travel.getGambar())
                            .into(binding.ivImageDetail);
                    binding.tvAddress.setText(travel.getAlamat());
                    binding.tvHarga.setText(travel.getHarga());
                    binding.tvTitleDetail.setText(travel.getNama());
                    binding.tvDescDetail.setText(Html.fromHtml(travel.getDeskripsi()));
                    binding.ivMap.setOnClickListener(v -> {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(travel.getLinkLokasi()));
                        startActivity(browserIntent);
                    });
                    break;
                case "Hotel":
                    //Make layout invisible
                    binding.cvLokasi.setVisibility(View.GONE);
                    //---------------------

                    Travel hotel = getIntent().getParcelableExtra(EXTRA_DATA);
                    Glide.with(this)
                            .load(Constant.IMAGE_HOTEL + hotel.getGambar())
                            .into(binding.ivImageDetail);
                    binding.tvAddress.setText(hotel.getAlamat());
                    binding.tvHarga.setText(hotel.getHarga());
                    binding.tvTitleDetail.setText(hotel.getNama());
                    binding.tvDescDetail.setText(Html.fromHtml(hotel.getDeskripsi()));
                    binding.ivMap.setOnClickListener(v -> {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(hotel.getLinkLokasi()));
                        startActivity(browserIntent);
                    });
                    binding.btnOrder.setOnClickListener(v -> {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(hotel.getLinkOrder()));
                        startActivity(browserIntent);
                    });
                    break;
                case "Food":
                    //Make layout invisible
                    binding.cvLokasi.setVisibility(View.GONE);
                    binding.llPrices.setVisibility(View.GONE);
                    //---------------------

                    Travel food = getIntent().getParcelableExtra(EXTRA_DATA);
                    Glide.with(this)
                            .load(Constant.IMAGE_FOOD + food.getGambar())
                            .into(binding.ivImageDetail);
                    binding.tvAddress.setText(food.getAlamat());
//                    binding.tvHarga.setText(food.getHarga());
                    binding.tvTitleDetail.setText(food.getNama());
                    binding.tvDescDetail.setText(Html.fromHtml(food.getDeskripsi()));
                    binding.ivMap.setOnClickListener(v -> {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(food.getLinkLokasi()));
                        startActivity(browserIntent);
                    });
                    binding.btnOrder.setOnClickListener(v -> {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(food.getLinkOrder()));
                        startActivity(browserIntent);
                    });
                    break;
                case "Event":
                    //Make layout invisible
                    binding.llContent2.setVisibility(View.GONE);
                    binding.btnOrder.setVisibility(View.GONE);
                    //---------------------

                    Travel event = getIntent().getParcelableExtra(EXTRA_DATA);
                    Glide.with(this)
                            .load(Constant.IMAGE_EVENT + event.getGambar())
                            .into(binding.ivImageDetail);
                    binding.tvTitleDetail.setText(event.getJudul());
                    binding.tvDescDetail.setText(Html.fromHtml(event.getDeskripsi()));
                    binding.tvLokasi.setText(event.getLokasi());

                    //Parsing time
                    if(event.getWaktu()!= null){
                        DateFormat dateFormat = new DateFormat();
                        binding.tvDate.setText(dateFormat.localeDateParseDay(event.getWaktu()));
                        binding.tvMonth.setText(dateFormat.localeDateParseMonth(event.getWaktu()));
                        binding.tvTime.setText(dateFormat.localeTimeWithoutMinutes(event.getWaktu()));
                    }
//                    binding.tvAddress.setText(event.getAlamat());
//                    binding.tvHarga.setText(event.getHarga());
//                    binding.ivMap.setOnClickListener(v -> {
//                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(event.getLink()));
//                        startActivity(browserIntent);
//                    });


                    break;
            }
        }
    }

    //Kode pada tombol kembali
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