package com.blit.blit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blit.blit.R;
import com.blit.blit.common.Parser;
import com.blit.blit.models.City;
import com.blit.blit.models.Ticket;
import com.blit.blit.parsers.SampleParser;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Parser> parsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerParsers();
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


}
