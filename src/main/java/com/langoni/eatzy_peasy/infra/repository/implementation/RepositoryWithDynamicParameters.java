package com.langoni.eatzy_peasy.infra.repository.implementation;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import com.langoni.eatzy_peasy.domain.repository.RestaurantRepositoryImplInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Repository
public class RepositoryWithDynamicParameters implements RestaurantRepositoryImplInterface {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurant> listAllRestaurantCustomizedInterface(String name, BigDecimal initialDeliveryFee, BigDecimal finalDeliveryFee) {


        // Below we have some dynamic query, where I can set the parameters depending on it's filled or not
        StringBuilder jpql = new StringBuilder();
        jpql.append("select r from Restaurant r where 0=0 ");

        var parameters = new HashMap<String, Object>();

        if (StringUtils.hasLength(name)) {
            jpql.append(" and r.name like :name ");
            parameters.put("name", "%" + name + "%");
        }

        if (initialDeliveryFee != null) {
            jpql.append(" and r.deliveryFee >= :initialFee");
            parameters.put("initialFee", initialDeliveryFee);
        }

        if (finalDeliveryFee != null) {
            jpql.append(" and r.deliveryFee <= :finalFee ");
            parameters.put("finalFee", finalDeliveryFee);
        }

        TypedQuery<Restaurant> query = entityManager.createQuery(jpql.toString(), Restaurant.class);

        parameters.forEach((key, value) -> query.setParameter(key, value));

        return query.getResultList();

    }

    @Override
    public List<Restaurant> byNameLike(String name) {
        return List.of();
    }
}
