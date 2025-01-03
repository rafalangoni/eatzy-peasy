package com.langoni.eatzy_peasy.infra.repository.implementation;

import com.langoni.eatzy_peasy.domain.model.City;
import com.langoni.eatzy_peasy.domain.repository.CityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
//public class CityRepositoryImpl implements CityRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<City> listAllCities() {
//        TypedQuery<City> query = entityManager.createQuery("select c from City c" , City.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public City findCityById(Long id) {
//        return entityManager.find(City.class, id);
//    }
//
//    @Override
//    @Transactional
//    public City saveCity(City city) {
//        entityManager.persist(city);
//        return city;
//    }
//
//    @Override
//    @Transactional
//    public void removeCity(Long id) {
//        entityManager.remove(findCityById(id));
//    }
//
//    @Override
//    @Transactional
//    public void removeCity(City city) {
//        entityManager.remove(findCityById(city.getId()));
//    }
//}
