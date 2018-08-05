package com.blit.blit.parsers;

import android.content.Intent;

import com.blit.blit.common.Parser;
import com.blit.blit.common.PersianCalendar;
import com.blit.blit.models.City;
import com.blit.blit.models.Ticket;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * sample parser propose is help with testing UI components
 */
public class SampleParser extends Parser {
    @Override
    public String getSearchPath(City c1, City c2, Calendar calendar) {
        return null;
    }

    @Override
    public ArrayList<Ticket> getTickets(City c1, City c2, Calendar calendar) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for(int i = 0;i<10;i++)
        {
            Ticket ticket = new Ticket();
            ticket.setBeginningCity(c1);
            ticket.setDestinationCity(c2);
            ticket.setCompany("Co"+ Integer.toString(i));
            ticket.setDetail("it's sample");
            ticket.setPrice(new Random().nextInt(200000));
            ticket.setCalendar(calendar);
        }
        return tickets;
    }
}
