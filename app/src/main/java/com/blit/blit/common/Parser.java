package com.blit.blit.common;

import com.blit.blit.models.City;
import com.blit.blit.models.Ticket;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public abstract class Parser {

    /**
     * build target website path based on website standard
     * @param c1 beginning city
     * @param c2 destination city
     * @param calendar target day
     * @return target url
     */
    public abstract String getSearchPath(City c1, City c2, Calendar calendar);

    /**
     * fetch ticket information from target website
     * @param c1 beginning city
     * @param c2 destination city
     * @param calendar target day
     * @return list of tickets
     */
    public abstract ArrayList<Ticket> getTickets(City c1, City c2, Calendar calendar);
}
