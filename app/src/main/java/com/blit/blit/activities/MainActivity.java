package com.blit.blit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.blit.blit.adapters.BlitRecyclerViewAdapter;
import com.blit.blit.R;
import com.blit.blit.common.Parser;
import com.blit.blit.dao.CityDao;
import com.blit.blit.models.City;
import com.blit.blit.models.Ticket;
import com.blit.blit.parsers.SampleParser;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String BEGINNING_CITY = "c1";
    public static final String DESTINATION_CITY = "c2";

    public static CityDao cityDao = new CityDao();

    private ArrayList<Parser> parsers = new ArrayList<>();
    private BlitRecyclerViewAdapter adapter;

    private City beginningCity;
    private City destinationCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String cityShortName1 = getIntent().getStringExtra(BEGINNING_CITY);
        String cityShortName2 = getIntent().getStringExtra(DESTINATION_CITY);
        beginningCity = cityDao.findCityByShortName(cityShortName1);
        destinationCity = cityDao.findCityByShortName(cityShortName2);
        Log.d(TAG, "onCreate: ");
        
        registerParsers();

        initRecyclerView();
        adapter.notifyDataSetChanged();
    }

    /**
     * register available parsers to parsers list
     */
    private void registerParsers() {
        parsers.add(new SampleParser());
    }

    /**
     * fetch ticket based on cities information from all registered parsers
     * @param c1 beginning city
     * @param c2 destination city
     * @param calendar target day
     * @return list of tickets
     */
    private ArrayList<Ticket> fetchTickets(City c1, City c2, Calendar calendar)
    {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for(Parser parser: parsers)
            tickets.addAll(parser.getTickets(c1, c2, calendar));
        return tickets;
    }
    private void initRecyclerView(){
        RecyclerView ticketRecyclerView=findViewById(R.id.blitRecyclerView);
        LinearLayoutManager ticketLinearLayout = new LinearLayoutManager(this,LinearLayout.VERTICAL,false);
        ticketRecyclerView.setAdapter(adapter);
        ticketRecyclerView.setLayoutManager(ticketLinearLayout);
        adapter = new BlitRecyclerViewAdapter(fetchTickets(beginningCity,destinationCity,null));

    }

}
