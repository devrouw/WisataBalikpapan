package com.hermawan.wisatabalikpapan.util;

import android.content.Context;

public class UtilsApi {
    // URL API.
    public static final String BASE_URL_API = "http://pariwisata.sha-dev.com/android/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(Context mContext){
        return RetrofitClient.getClient(mContext, BASE_URL_API).create(BaseApiService.class);
    }
}
