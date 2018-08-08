package com.blit.blit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.blit.blit.R;
import com.blit.blit.models.City;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = SearchActivity.class.getName();
    public static ArrayList<City> cities = new ArrayList<>();

    private AutoCompleteTextView beginningView;
    private AutoCompleteTextView destinationView;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        loadCities();
        beginningView = findViewById(R.id.searchBeginningCity);
        destinationView = findViewById(R.id.searchDestinationCity);
        searchButton = findViewById(R.id.ticketSearchButton);

        setupAutoTextView(beginningView);
        setupAutoTextView(destinationView);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    /**
     * set adapter and other stuff
     */
    void setupAutoTextView(AutoCompleteTextView view)
    {
        ArrayAdapter<City> adapter = new ArrayAdapter<> (this,android.R.layout.simple_list_item_1,cities);
        view.setAdapter(adapter);
    }

    /**
     * load cities information
     */
    public void loadCities(){
        City mashhad = new City("MHD","مشهد","Mashhad");
        City isfahan = new City("IFN","اصفهان","Isfahan");
        City shiraz = new City("SYZ","شیراز","Shiraz");
        City tehran = new City("THR","تهران","Tehran");
        cities.add(mashhad);
        cities.add(tehran);
        cities.add(isfahan);
        cities.add(shiraz);

    }

    /**
     * find city by faName
     * @param name faName of city
     * @return City Object otherwise null
     */
    public City findCityByName(String name)
    {
        for(City c:cities)
            if(c.getFaName().equals(name))
                return c;
        return null;
    }

}
