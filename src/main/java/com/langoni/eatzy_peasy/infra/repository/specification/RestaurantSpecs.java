package com.langoni.eatzy_peasy.infra.repository.specification;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class RestaurantSpecs {

    public static Specification<Restaurant> withFreeDelivery() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("deliveryFee"), BigDecimal.ZERO);
    }

    public static Specification<Restaurant> byNameLike(String name){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }
}
