package com.langoni.eatzy_peasy.api.controller;

import com.langoni.eatzy_peasy.domain.model.City;
import com.langoni.eatzy_peasy.domain.service.CityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> listAllCities(){
        return cityService.listAllCities();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<City> addCity(@RequestBody City city){
        cityService.addCity(city);
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCity(@PathVariable Long id){
        cityService.removeCity(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city){
        var retrievedCity = cityService.findById(id);
        BeanUtils.copyProperties(city, retrievedCity, "id");
        City addedCity = cityService.addCity(retrievedCity);
        return ResponseEntity.ok(addedCity);
    }
}
