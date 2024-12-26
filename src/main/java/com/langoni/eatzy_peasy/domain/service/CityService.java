package com.langoni.eatzy_peasy.domain.service;

import com.langoni.eatzy_peasy.domain.model.City;
import com.langoni.eatzy_peasy.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> listAllCities() {
        return cityRepository.listAllCities();
    }

    public City addCity(City city) {
        return cityRepository.saveCity(city);
    }

    public City findById(Long id){
        return cityRepository.findCityById(id);
    }

    public void removeCity(Long id){
        cityRepository.removeCity(id);
    }


}
