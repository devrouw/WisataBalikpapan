package com.hermawan.wisatabalikpapan.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hermawan.wisatabalikpapan.R;
import com.hermawan.wisatabalikpapan.databinding.ActivityLoginBinding;
import com.hermawan.wisatabalikpapan.session.Config;
import com.hermawan.wisatabalikpapan.ui.list.ListViewModel;
import com.hermawan.wisatabalikpapan.util.BaseApiService;
import com.hermawan.wisatabalikpapan.util.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 *
 * Activity About menyimpan semua kode dari tampilan menu login
 *
 * */

public class LoginActivity extends AppCompatActivity {

    BaseApiService mApiService;
    ProgressDialog loading;

    Config session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Menghilangkan toolbar
        Objects.requireNonNull(getSupportActionBar()).hide();

        session = new Config(getApplicationContext());

        //Memanggil viewmodel
        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        ListViewModel viewModel = new ViewModelProvider(this, factory).get(ListViewModel.class);

        mApiService = UtilsApi.getAPIService(this);

        //Kode pada tombol login
        binding.btnLogin.setOnClickListener(v -> {
            loading = ProgressDialog.show(LoginActivity.this, null, "Mencoba login...", true, false);
            String email = Objects.requireNonNull(binding.edtEmail.getText()).toString();
            String password = Objects.requireNonNull(binding.edtPassword.getText()).toString();
            mApiService.login("login",email,password).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()){
                        try {
                            JSONObject jsonRESULTS = new JSONObject(response.body().string());
                            if (jsonRESULTS.getString("code").equals("200")){
                                JSONArray jsonArray = jsonRESULTS.getJSONArray("data");
                                for(int i=0; i<jsonArray.length(); i++){
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String id = jsonObject.getString("id");
                                    String name = jsonObject.getString("name");
                                    String email = jsonObject.getString("email");
                                    session.createLoginSession(id,name,email);

                                    loading.dismiss();
                                    Toast.makeText(LoginActivity.this, "Berhasil login", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                    finish();
                                }
                            } else {
                                loading.dismiss();
                                Toast.makeText(LoginActivity.this, "Gagal login", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException | IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        });

        //Kode pada tombol register
        binding.btnRegister.setOnClickListener( v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}