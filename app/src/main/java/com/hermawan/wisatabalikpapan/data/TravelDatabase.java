package com.hermawan.wisatabalikpapan.data;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.hermawan.wisatabalikpapan.R;
import com.hermawan.wisatabalikpapan.data.entity.About;
import com.hermawan.wisatabalikpapan.data.entity.Accommodation;
import com.hermawan.wisatabalikpapan.data.entity.Event;
import com.hermawan.wisatabalikpapan.data.entity.Food;
import com.hermawan.wisatabalikpapan.data.entity.Hotel;
import com.hermawan.wisatabalikpapan.data.entity.Travel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 *
 * Class untuk mendeklarasikan database
 *
 * */

@Database(entities = {
        Travel.class,
        Hotel.class,
        Food.class,
        Event.class,
        Accommodation.class,
        About.class
}, version = 1)
public abstract class TravelDatabase extends RoomDatabase {

    public abstract TravelDao travelDao();

    private static TravelDatabase INSTANCE;

    public static TravelDatabase getDatabase(final Context context) {
        //Mengecek apakah db sudah dibuat atau belum, jika belum maka akan dibuat db baru, jika sudah maka akan dilewatkan
        if (INSTANCE == null) {
            synchronized (TravelDatabase.class) {
                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        TravelDatabase.class,
                        "travel_db"
                ).addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        //Menambahkan data awal pada database, menggunakan thread baru agar Main Thread tidak terganggu untuk render aplikasi
                        ExecutorService ex = Executors.newSingleThreadExecutor();
                        ex.execute(() -> {
                            INSTANCE.fillWithStartingData(context, getDatabase(context).travelDao(), "travel");
                            INSTANCE.fillWithStartingData(context, getDatabase(context).travelDao(), "hotel");
                            INSTANCE.fillWithStartingData(context, getDatabase(context).travelDao(), "food");
                            INSTANCE.fillWithStartingData(context, getDatabase(context).travelDao(), "event");
                            INSTANCE.fillWithStartingData(context, getDatabase(context).travelDao(), "accommodation");
                            INSTANCE.fillWithStartingData(context, getDatabase(context).travelDao(), "about");
                        });
                        ex.shutdown();
                    }
                }).build();
            }
        }
        return INSTANCE;
    }

    //Fungsi untuk load file JSON yang telah disediakan
    private JSONArray loadJsonArray(Context context, String table) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader;
        String line;
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.dummy);
            reader = new BufferedReader((new InputStreamReader(inputStream)));
            do {
                line = reader.readLine();
                builder.append(line);
            } while (line != null);
            JSONObject json = new JSONObject(builder.toString());
            Log.d("LoadJsonArray", json.getJSONArray(table).toString());
            return json.getJSONArray(table);
        } catch (IOException | JSONException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    //Fungsi untuk menambahkan data pada JSON tadi ke table yang ditentukan
    private void fillWithStartingData(Context context, TravelDao dao, String table) {
        JSONArray task = loadJsonArray(context, table);
        try {
            if (task != null) {
                int i = 0;
                for (int length = task.length(); i < length; ++i ) {
                    JSONObject item = task.getJSONObject(i);
                    Log.d("Table", table);
                    Log.d("JSON", item.toString());
                    switch (table) {
                        case "travel":
                            Travel travel = new Travel();
                            travel.setIdTravel(item.getInt("idTravel"));
                            travel.setTitleTravel(item.getString("titleTravel"));
                            travel.setDescTravel(item.getString("descTravel"));
                            travel.setImageTravel(item.getString("imageTravel"));
                            Log.d("LoadDatabase", travel.getTitleTravel());
                            dao.insertAllTravel(travel);
                            break;
                        case "hotel":
                            Hotel hotel = new Hotel();
                            hotel.setIdHotel(item.getInt("idHotel"));
                            hotel.setTitleHotel(item.getString("titleHotel"));
                            hotel.setDescHotel(item.getString("descHotel"));
                            hotel.setImageHotel(item.getString("imageHotel"));
                            Log.d("LoadDatabase", hotel.getTitleHotel());
                            dao.insertAllHotel(hotel);
                            break;
                        case "food":
                            Food food = new Food();
                            food.setIdFood(item.getInt("idFood"));
                            food.setTitleFood(item.getString("titleFood"));
                            food.setDescFood(item.getString("descFood"));
                            food.setImageFood(item.getString("imageFood"));
                            Log.d("LoadDatabase", food.getTitleFood());
                            dao.insertAllFood(food);
                            break;
                        case "event":
                            Event event = new Event();
                            event.setIdEvent(item.getInt("idEvent"));
                            event.setTitleEvent(item.getString("titleEvent"));
                            event.setDescEvent(item.getString("descEvent"));
                            event.setImageEvent(item.getString("imageEvent"));
                            Log.d("LoadDatabase", event.getTitleEvent());
                            dao.insertAllEvent(event);
                            break;
                        case "accommodation":
                            Accommodation accommodation = new Accommodation();
                            accommodation.setIdAccommodation(item.getInt("idAccommodation"));
                            accommodation.setTitleAccommodation(item.getString("titleAccommodation"));
                            accommodation.setDescAccommodation(item.getString("descAccommodation"));
                            accommodation.setImageAccommodation(item.getString("imageAccommodation"));
                            Log.d("LoadDatabase", accommodation.getTitleAccommodation());
                            dao.insertAllAccommodation(accommodation);
                            break;
                        case "about":
                            About about = new About();
                            about.setName(item.getString("name"));
                            about.setAddress(item.getString("address"));
                            about.setContact(item.getString("contact"));
                            about.setVision(item.getString("vision"));
                            about.setMission(item.getString("mission"));
                            Log.d("LoadDatabase", about.getName());
                            dao.insertAllAbout(about);
                            break;
                    }
                }
            }
        } catch (JSONException exception) {
            exception.printStackTrace();
        }
    }
}
