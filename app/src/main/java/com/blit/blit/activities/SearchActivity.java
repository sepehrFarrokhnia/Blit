package com.blit.blit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.blit.blit.R;
import com.blit.blit.models.City;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    public static ArrayList<City> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void loadCities(){
        City mashhad = new City("MHD","فارسی","Mashhad");
        City tehran = new City("THR","تهران","Tehran");
        cities.add(mashhad);
        cities.add(tehran);

    }

}
