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
public class RestaurantRepositoryImpl implements RestaurantRepositoryImplInterface {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurant> listAllRestaurantCustomizedInterface(String name, BigDecimal initialDeliveryFee, BigDecimal finalDeliveryFee) {

//        var jpql = "select r from Restaurant r where r.name like :name " +
//                "and r.deliveryFee between :initialDeliveryFee and :finalDeliveryFee ";

        StringBuilder jpql = new StringBuilder();
        jpql.append("select r from Restaurant r where 0=0 ");

        var parameters = new HashMap<String, Object>();

        if(StringUtils.hasLength(name)){
            jpql.append(" and r.name like :name ");
            parameters.put("name", "%" + name + "%");
        }

        if(initialDeliveryFee != null){
            jpql.append(" and r.deliveryFee >= :initialFee");
            parameters.put("initialFee", initialDeliveryFee);
        }

        if(finalDeliveryFee != null){
            jpql.append(" and r.deliveryFee <= :finalFee ");
            parameters.put("finalFee", finalDeliveryFee);
        }

        TypedQuery<Restaurant> query = entityManager.createQuery(jpql.toString(), Restaurant.class);

        parameters.forEach((key, value)-> query.setParameter(key,value));

        return query.getResultList();

//        return entityManager.createQuery(jpql.toString(), Restaurant.class)
//                .setParameter("name", "%" + name + "%")
//                .setParameter("initialDeliveryFee", initialDeliveryFee)
//                .setParameter("finalDeliveryFee", finalDeliveryFee)
//                .getResultList();
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
