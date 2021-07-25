package com.hermawan.wisatabalikpapan.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hermawan.wisatabalikpapan.databinding.ActivityRegisterBinding;
import com.hermawan.wisatabalikpapan.util.BaseApiService;
import com.hermawan.wisatabalikpapan.util.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    BaseApiService mApiService;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mApiService = UtilsApi.getAPIService(this);

        //Menghilangkan toolbar
        Objects.requireNonNull(getSupportActionBar()).hide();

        //Kode pada tombol travel
       binding.btnRegister.setOnClickListener(v -> {
           loading = ProgressDialog.show(RegisterActivity.this, null, "Mengirim data...", true, false);
           String name = Objects.requireNonNull(binding.edtName.getText()).toString();
           String email = Objects.requireNonNull(binding.edtEmail.getText()).toString();
           String password = Objects.requireNonNull(binding.edtPassword.getText()).toString();

           mApiService.register("daftar",name, email, password).enqueue(new Callback<ResponseBody>() {
               @Override
               public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                   if (response.isSuccessful()){
                       try {
                           JSONObject jsonRESULTS = new JSONObject(response.body().string());
                           if (jsonRESULTS.getString("code").equals("200")){
                               loading.dismiss();
                               Toast.makeText(RegisterActivity.this, "Berhasil mendaftar", Toast.LENGTH_SHORT).show();
                               finish();
                           } else {
                               loading.dismiss();
                               Toast.makeText(RegisterActivity.this, "Gagal mendaftar", Toast.LENGTH_SHORT).show();
                           }
                       } catch (JSONException e) {
                           e.printStackTrace();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   } else {
                       Toast.makeText(RegisterActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                   }
               }

               @Override
               public void onFailure(Call<ResponseBody> call, Throwable t) {
                   Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
               }
           });
       });
    }
}
