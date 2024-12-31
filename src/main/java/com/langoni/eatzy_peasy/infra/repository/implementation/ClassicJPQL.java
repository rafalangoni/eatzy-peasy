package com.langoni.eatzy_peasy.infra.repository.implementation;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import com.langoni.eatzy_peasy.domain.repository.RestaurantRepositoryImplInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ClassicJPQL implements RestaurantRepositoryImplInterface {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurant> listAllRestaurantCustomizedInterface(String name, BigDecimal initialDeliveryFee, BigDecimal finalDeliveryFee) {

        var jpql = "select r from Restaurant r where r.name like :name " +
                "and r.deliveryFee between :initialDeliveryFee and :finalDeliveryFee ";

        return entityManager.createQuery(jpql.toString(), Restaurant.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("initialDeliveryFee", initialDeliveryFee)
                .setParameter("finalDeliveryFee", finalDeliveryFee)
                .getResultList();
    }

    @Override
    public List<Restaurant> byNameLike(String name) {
        return List.of();
    }
}

