package com.hermawan.wisatabalikpapan.ui.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hermawan.wisatabalikpapan.R;
import com.hermawan.wisatabalikpapan.databinding.ActivityListBinding;
import com.hermawan.wisatabalikpapan.model.ListTravel;
import com.hermawan.wisatabalikpapan.model.Travel;
import com.hermawan.wisatabalikpapan.ui.ViewModelFactory;
import com.hermawan.wisatabalikpapan.ui.list.adapter.AccommodationAdapter;
import com.hermawan.wisatabalikpapan.ui.list.adapter.EventAdapter;
import com.hermawan.wisatabalikpapan.ui.list.adapter.FoodAdapter;
import com.hermawan.wisatabalikpapan.ui.list.adapter.HotelAdapter;
import com.hermawan.wisatabalikpapan.ui.list.adapter.TravelAdapter;
import com.hermawan.wisatabalikpapan.util.BaseApiService;
import com.hermawan.wisatabalikpapan.util.UtilsApi;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 *
 * Activity List menyimpan semua kode dari tampilan menu list
 *
 * */
public class ListActivity extends AppCompatActivity {
    //Deklarasi variabel untuk passing data dari menu home ke menu list
    private ActivityListBinding binding;
    public static final String EXTRA_TYPE = "extra_type";
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Menampilkan tombol kembali pada toolbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mApiService = UtilsApi.getAPIService(this);

        //Setting recyclerview untuk menampilkan list
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);

        //Memanggil viewmodel
        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        ListViewModel viewModel = new ViewModelProvider(this, factory).get(ListViewModel.class);

        //Mengambil data hasil passing dari main menu
        String type = getIntent().getStringExtra(EXTRA_TYPE);
        if (type != null) {
            //Menampilkan tampilan konten dan menyembunyikan loading
            binding.pb.setVisibility(View.GONE);
            binding.recyclerView.setVisibility(View.VISIBLE);
            //Menampilkan data sesuai tipe ke tampilan UI

            switch (type){
                case "Travel":
                    getSupportActionBar().setTitle(getResources().getString(R.string.actionbar_title, getResources().getString(R.string.travel)));
                    apiCall(type);
                    break;
                case "Hotel":
                    getSupportActionBar().setTitle(getResources().getString(R.string.actionbar_title, getResources().getString(R.string.hotel)));
                    apiCall(type);
                    break;
                case "Food":
                    getSupportActionBar().setTitle(getResources().getString(R.string.actionbar_title, getResources().getString(R.string.food)));
                    apiCall(type);
                    break;
                case "Event":
                    getSupportActionBar().setTitle(getResources().getString(R.string.actionbar_title, getResources().getString(R.string.event)));
                    apiCall(type);
                    break;
                case "Accommodation":
                    apiCall(type);
                    break;
            }
        }
    }

    private void apiCall(String type){
        mApiService.getTravel(type).enqueue(new Callback<ListTravel>() {
            @Override
            public void onResponse(Call<ListTravel> call, Response<ListTravel> response) {
                if(response.isSuccessful()){
                    try{
                        String status = response.body().getStatus();
                        if(status.equals("404")){
                            Toast.makeText(ListActivity.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
                        }else{
                            generateTravelList(response.body().getDataList(), type);
                        }
                    }catch (Exception e){
                        Log.d("exception", e.getMessage());
                    }
                }else{
                    Toast.makeText(ListActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListTravel> call, Throwable t) {
                Toast.makeText(ListActivity.this, "Koneksi Internet tidak tersedia", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateTravelList(ArrayList<Travel> dataList, String type) {
        TravelAdapter adapter = new TravelAdapter();
        adapter.setListData(dataList);
        adapter.setType(type);
        binding.recyclerView.setAdapter(adapter);
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