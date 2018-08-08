package com.blit.blit.models;

public class City {

    public City(String shortName, String faName, String enName) {
        this.shortName = shortName;
        this.faName = faName;
        this.enName = enName;
    }

    private String shortName;
    private String faName;
    private String enName;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    @Override
    public String toString()
    {
        return getFaName();
    }
}
