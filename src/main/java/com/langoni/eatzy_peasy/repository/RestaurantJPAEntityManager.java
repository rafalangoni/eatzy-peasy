package com.langoni.eatzy_peasy.repository;

import com.langoni.eatzy_peasy.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class RestaurantJPAEntityManager {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurant> listAllRestaurant() {
        TypedQuery<Restaurant> query = entityManager.createQuery("select r from Restaurant r", Restaurant.class);
        return query.getResultList();
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        var retrievedRestaurant = entityManager.find(Restaurant.class, id);
        retrievedRestaurant.setName(restaurant.getName());
        return entityManager.merge(retrievedRestaurant);
    }

    @Transactional
    public void addRestaurant(Restaurant restaurant) {
        entityManager.persist(restaurant);
    }

    public Restaurant findById(Long id) {
        return entityManager.find(Restaurant.class, id);
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        var restaurantToRemove = findById(id);
        entityManager.remove(restaurantToRemove);
    }
}
