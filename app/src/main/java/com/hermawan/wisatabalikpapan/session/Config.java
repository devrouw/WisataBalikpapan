package com.hermawan.wisatabalikpapan.session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.hermawan.wisatabalikpapan.ui.LoginActivity;

import java.util.HashMap;

public class Config {

    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Context _context;

    int PRIVATE_MODE = 0;

    public static final String SHARED_PREF_NAME = "myloginapp";
    public static final String LOGGEDIN = "loggedin";
    public static final String KEY_NAME = "name";
    public static final String KEY_ID = "id_user";
    public static final String KEY_EMAIL = "email";

    public Config(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(SHARED_PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String id,String name, String email){
        editor.putBoolean(LOGGEDIN, true);
        editor.putString(KEY_ID,id);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }

    public void checkLogin(){
        if(!this.isLoggedIn()){
            Intent i = new Intent(_context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);
        }
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_ID, pref.getString(KEY_ID, null));
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        return user;
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        _context.startActivity(i);
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(LOGGEDIN, false);
    }
}
