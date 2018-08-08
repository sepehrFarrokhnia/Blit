package com.blit.blit.models;

import java.util.Calendar;
import java.util.Date;

public class Ticket {
    public enum TicketType
    {
        BUS,
        TRAIN,
        AIRPLANE
    }

    private long price;
    private String detail;
    private City destinationCity;
    private City beginningCity;
    private Calendar calendar;
    private String company;
    private TicketType ticketType;

    public Ticket() {
    }

    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public City getBeginningCity() {
        return beginningCity;
    }

    public void setBeginningCity(City beginningCity) {
        this.beginningCity = beginningCity;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", detail='" + detail + '\'' +
                ", destinationCity=" + destinationCity +
                ", beginningCity=" + beginningCity +
                ", calendar=" + calendar +
                ", company='" + company + '\'' +
                ", ticketType=" + ticketType +
                '}';
    }
}
