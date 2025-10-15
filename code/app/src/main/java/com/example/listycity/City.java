package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Return the name of the city
     * @return
     *      String representation of city
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Return the name of the province
     * @return
     *      String representation of province
     */
    public String getProvinceName(){
        return this.province;
    }

    /**
     *
     * @param o the object to be compared.
     * @return
     *      Int value representing how similar a city is to another
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Override equals to specify how City objects be compared.
     * Two cities are the same if they have the same name and province
     * @param o
     *      Other object to compare to
     * @return
     *      Whether or not two cities are the same.
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City cityObj = (City) o;
        return this.city.equals(cityObj.getCityName()) && this.province.equals(cityObj.getProvinceName());
    }
}