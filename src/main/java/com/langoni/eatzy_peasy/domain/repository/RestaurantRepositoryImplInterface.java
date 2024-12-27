package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestaurantRepositoryImplInterface {

    List<Restaurant> listAllRestaurantCustomizedInterface(String name, BigDecimal initialDeliveryFee, BigDecimal finalDeliveryFee);
}
