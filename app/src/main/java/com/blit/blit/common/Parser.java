package com.blit.blit.common;

import com.blit.blit.models.City;
import com.blit.blit.models.Ticket;

import java.util.ArrayList;
import java.util.Date;

public abstract class Parser {
    public abstract String getSearchPath(City c1, City c2, Date date);
    public abstract ArrayList<Ticket> getTickets(City c1, City c2, Date date);
}
