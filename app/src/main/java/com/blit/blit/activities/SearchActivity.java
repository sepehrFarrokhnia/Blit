package com.blit.blit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.blit.blit.R;
import com.blit.blit.models.City;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = SearchActivity.class.getName();

    private AutoCompleteTextView beginningView;
    private AutoCompleteTextView destinationView;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        beginningView = findViewById(R.id.searchBeginningCity);
        destinationView = findViewById(R.id.searchDestinationCity);
        searchButton = findViewById(R.id.ticketSearchButton);

        setupAutoTextView(beginningView);
        setupAutoTextView(destinationView);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                City c1 = MainActivity.cityDao.findCityByFaName(beginningView.getText().toString());
                City c2 = MainActivity.cityDao.findCityByFaName(destinationView.getText().toString());
                if(c1 == null)
                    beginningView.setError(getString(R.string.cityNotFound));
                else if(c2 == null)
                    destinationView.setError(getString(R.string.cityNotFound));
                else if(c1 == c2)
                    destinationView.setError(getString(R.string.destinationCityAndBeginningCityAreSame));
                else
                {
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    intent.putExtra(MainActivity.BEGINNING_CITY, c1.getShortName());
                    intent.putExtra(MainActivity.DESTINATION_CITY, c2.getShortName());
                    startActivity(intent);

                }
            }
        });
    }

    /**
     * set adapter and other stuff
     */
    void setupAutoTextView(AutoCompleteTextView view)
    {
        ArrayAdapter<City> adapter = new ArrayAdapter<> (this,android.R.layout.simple_list_item_1,MainActivity.cityDao.getCities());
        view.setAdapter(adapter);
    }

}
