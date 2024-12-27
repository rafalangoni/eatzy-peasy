package com.langoni.eatzy_peasy.infra.repository.implementation;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurant> listAllRestaurantCustomizedInterface(String name, BigDecimal initialDeliveryFee, BigDecimal finalDeliveryFee) {

        var jpql = "select r from Restaurant r where r.name like :name " +
                "and r.deliveryFee between :initialDeliveryFee and :finalDeliveryFee ";

        return entityManager.createQuery(jpql, Restaurant.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("initialDeliveryFee", initialDeliveryFee)
                .setParameter("finalDeliveryFee", finalDeliveryFee)
                .getResultList();
    }
}

//    @Override
//    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
//        return entityManager.merge(id, restaurant);
//    }

////    @Override
//    @Transactional
//    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
//        var retrievedRestaurant = entityManager.find(Restaurant.class, id);
//        BeanUtils.copyProperties(restaurant, retrievedRestaurant, "id");
////        retrievedRestaurant.setName(restaurant.getName());
//        return entityManager.merge(retrievedRestaurant);
//    }

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
