package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
//    List<City> listAllCities();
//    City findCityById(Long id);
//    City saveCity(City city);
//    void removeCity(Long id);
//    void removeCity(City city);
}
