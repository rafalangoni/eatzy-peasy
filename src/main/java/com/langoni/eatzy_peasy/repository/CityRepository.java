package com.langoni.eatzy_peasy.repository;

import com.langoni.eatzy_peasy.model.City;

import java.util.List;

public interface CityRepository {
    List<City> listAllCities();
    City findCityById(Long id);
    City saveCity(City city);
    void removeCity(Long id);
    void removeCity(City city);
}
