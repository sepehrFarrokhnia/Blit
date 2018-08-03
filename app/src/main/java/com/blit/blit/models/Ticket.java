package com.blit.blit.models;

import java.util.Date;

public class Ticket {
    private long price;
    private String detail;
    private City destinationCity;
    private City beginningCity;
    private Date date;
    private String company;
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

    public City getBeginingCity() {
        return beginningCity;
    }

    public void setBeginingCity(City beginingCity) {
        this.beginningCity = beginingCity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
