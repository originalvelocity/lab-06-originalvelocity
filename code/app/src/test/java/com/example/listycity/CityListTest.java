package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCities() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        City city2 = new City("Vancouver", "British Columbia");
        cityList.add(city2);

        assertTrue(cityList.hasCity(city));
        assertTrue(cityList.hasCity(city2));

        assertFalse(cityList.hasCity(new City("Los Angeles", "California")));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        cityList.delete(city);

        assertFalse(cityList.hasCity(city));

        City city1 = new City("Vancouver", "Alberta");
        cityList.add(city1);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });

        cityList.delete(city1);

        assertFalse(cityList.hasCity(city1));
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Vancouver", "British Columbia"));
        cityList.add(new City("Los Angeles", "California"));

        assertEquals(3, cityList.countCities());

        cityList.add(new City("Calgary", "Alberta"));

        assertEquals(4, cityList.countCities());

        cityList.delete(new City("Edmonton", "Alberta"));
        cityList.delete(new City("Vancouver", "British Columbia"));
        cityList.delete(new City("Los Angeles", "California"));
        cityList.delete(new City("Calgary", "Alberta"));

        assertEquals(0, cityList.countCities());
    }
}