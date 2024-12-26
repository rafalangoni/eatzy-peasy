package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
//    List<Restaurant> listAllRestaurant();
////    Restaurant updateRestaurant(Long id, Restaurant restaurant);
//    void addRestaurant(Restaurant restaurant);
//    Restaurant findRestaurantById(Long id);
//    void deleteRestaurant(Long id);
}
