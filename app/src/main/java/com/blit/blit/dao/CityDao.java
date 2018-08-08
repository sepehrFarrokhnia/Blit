package com.blit.blit.dao;

import com.blit.blit.models.City;

import java.util.ArrayList;

public class CityDao {
    private ArrayList<City> cities = new ArrayList<>();

    public CityDao() {
        loadCities();
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    /**
     * load cities information
     */
    public void loadCities(){
        City mashhad = new City("MHD","مشهد","Mashhad");
        City isfahan = new City("IFN","اصفهان","Isfahan");
        City shiraz = new City("SYZ","شیراز","Shiraz");
        City tehran = new City("THR","تهران","Tehran");
        cities.add(mashhad);
        cities.add(tehran);
        cities.add(isfahan);
        cities.add(shiraz);

    }

    /**
     * find city by faName
     * @param name faName of city
     * @return City Object otherwise null
     */
    public City findCityByFaName(String name)
    {
        for(City c:cities)
            if(c.getFaName().equals(name))
                return c;
        return null;
    }


    /**
     * find city by short name
     * @param name short name of city
     * @return City Object otherwise null
     */
    public City findCityByShortName(String name)
    {
        for(City c:cities)
            if(c.getShortName().equals(name))
                return c;
        return null;
    }

}
