package com.langoni.eatzy_peasy.repository;

import com.langoni.eatzy_peasy.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> listAllRestaurant();
    Restaurant updateRestaurant(Long id, Restaurant restaurant);
    void addRestaurant(Restaurant restaurant);
    Restaurant findRestaurantById(Long id);
    void deleteRestaurant(Long id);
}
