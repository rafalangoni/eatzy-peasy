package com.langoni.eatzy_peasy.domain.service;

import com.langoni.eatzy_peasy.domain.model.City;
import com.langoni.eatzy_peasy.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> listAllCities() {
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City findById(Long id){
        return cityRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("TESTEEE"));
    }

    public void removeCity(Long id){
        cityRepository.deleteById(id);
    }


}
