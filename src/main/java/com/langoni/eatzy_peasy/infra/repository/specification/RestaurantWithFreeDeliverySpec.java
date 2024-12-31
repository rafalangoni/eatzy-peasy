package com.langoni.eatzy_peasy.infra.repository.specification;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class RestaurantWithFreeDeliverySpec implements Specification<Restaurant> {
    @Override
    public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("deliveryFee"), BigDecimal.ZERO);
    }
}
