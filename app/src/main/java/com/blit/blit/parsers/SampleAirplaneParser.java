package com.blit.blit.parsers;

import android.content.Intent;

import com.blit.blit.common.Parser;
import com.blit.blit.models.City;
import com.blit.blit.models.Ticket;

import java.util.ArrayList;
import java.util.Calendar;

public class SampleAirplaneParser extends Parser{
    @Override
    public String getSearchPath(City c1, City c2, Calendar calendar) {
        return null;
    }

    @Override
    public ArrayList<Ticket> getTickets(City c1, City c2, Calendar calendar) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for(int i=0;i<15;i++)
        {
            Ticket t = new Ticket();
            t.setBeginningCity(c1);
            t.setDestinationCity(c2);
            t.setPrice(1000);
            t.setCalendar(calendar);
            t.setCompany("AirCo"+ Integer.toString(i));
            t.setDetail("haha hoho");
            t.setTicketType(Ticket.TicketType.AIRPLANE);
            tickets.add(t);
        }
        return tickets;
    }
}
