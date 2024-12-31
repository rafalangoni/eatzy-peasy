package com.langoni.eatzy_peasy.infra.repository.specification;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

public class RestaurantByNameSpec implements Specification<Restaurant> {

    private final String parameterName;

    public RestaurantByNameSpec(String parameterName){
        this.parameterName = parameterName;
    }

    @Override
    public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), "%" + parameterName + "%");
    }
}
