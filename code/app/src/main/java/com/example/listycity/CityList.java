package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method, given a city, will determine if it exists or not.
     * @param city
     *      This is the city that we want to check for
     * @return
     *      Whether or not the city is in a CityList
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Given a city, this method will remove it from CityList
     * @param city
     *      The city to remove
     * @throws IllegalArgumentException
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Return the number of cities in the list
     * @return
     *      A number representing the size of the list
     */
    public int countCities() {
        return cities.size();
    }
}