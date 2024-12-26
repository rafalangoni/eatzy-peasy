package com.langoni.eatzy_peasy.infra.repository.implementation;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import com.langoni.eatzy_peasy.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
//public class RestaurantRepositoryImpl implements RestaurantRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Restaurant> listAllRestaurant() {
//        TypedQuery<Restaurant> query = entityManager.createQuery("select r from Restaurant r", Restaurant.class);
//        return query.getResultList();
//    }
//
////    @Override
////    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
////        return entityManager.merge(id, restaurant);
////    }
//
//////    @Override
////    @Transactional
////    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
////        var retrievedRestaurant = entityManager.find(Restaurant.class, id);
////        BeanUtils.copyProperties(restaurant, retrievedRestaurant, "id");
//////        retrievedRestaurant.setName(restaurant.getName());
////        return entityManager.merge(retrievedRestaurant);
////    }
//
//    @Override
//    @Transactional
//    public void addRestaurant(Restaurant restaurant) {
//        entityManager.merge(restaurant);
//    }
//
//    @Override
//    public Restaurant findRestaurantById(Long id) {
//        return entityManager.find(Restaurant.class, id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteRestaurant(Long id) {
//        entityManager.remove(findRestaurantById(id));
//    }
//}
