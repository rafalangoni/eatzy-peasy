package com.langoni.eatzy_peasy.infra.repository.implementation;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import com.langoni.eatzy_peasy.domain.repository.RestaurantRepository;
import com.langoni.eatzy_peasy.domain.repository.RestaurantRepositoryImplInterface;
import com.langoni.eatzy_peasy.infra.repository.specification.RestaurantSpecsFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepositoryImplInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Lazy
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> listAllRestaurantCustomizedInterface(String name, BigDecimal initialDeliveryFee, BigDecimal finalDeliveryFee) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Restaurant> criteria = criteriaBuilder.createQuery(Restaurant.class);

        Root<Restaurant> rootRestaurant = criteria.from(Restaurant.class);

        var predicates = new ArrayList<Predicate>();

        if(StringUtils.hasLength(name)){
            predicates.add(criteriaBuilder.like(rootRestaurant.get("name"), "%"+ name + "%"));
        }
        if(initialDeliveryFee != null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(rootRestaurant.get("deliveryFee"), initialDeliveryFee));
        }

        if(finalDeliveryFee!= null){
            predicates.add(criteriaBuilder.lessThanOrEqualTo(rootRestaurant.get("deliveryFee"), finalDeliveryFee));
        }

        Predicate[] predicateArray = predicates.toArray(new Predicate[0]);

        criteria.where(predicateArray);

        TypedQuery<Restaurant> query = entityManager.createQuery(criteria);
        return query.getResultList();

    }

    @Override
    public List<Restaurant> byNameLike(String name) {
        return restaurantRepository.findAll(
                RestaurantSpecsFactory.withFreeDelivery().and(RestaurantSpecsFactory.byNameLike(name)));
    }
}

