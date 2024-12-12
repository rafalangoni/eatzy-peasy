package com.langoni.eatzy_peasy.repository;

import com.langoni.eatzy_peasy.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurant> listAllRestaurant(){
        TypedQuery<Restaurant> query = entityManager.createQuery("select r from Restaurant r", Restaurant.class);
        return query.getResultList();
    }
}
