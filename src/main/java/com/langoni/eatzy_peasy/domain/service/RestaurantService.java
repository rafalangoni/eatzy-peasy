package com.langoni.eatzy_peasy.domain.service;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import com.langoni.eatzy_peasy.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> listAllRestaurant() {
        return restaurantRepository.listAllRestaurant();
    }

//    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
//        return restaurantRepository.updateRestaurant(id, restaurant);
//    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
    }

    public Restaurant findRestaurantById(Long id) {
        return restaurantRepository.findRestaurantById(id);

    }

    public void deleteRestaurant(Long id) {
        var restaurant = restaurantRepository.findRestaurantById(id);
        if (restaurant != null) {
            restaurantRepository.deleteRestaurant(id);
        } else {
            throw new EntityNotFoundException("Restaurant with id " + id + " does not exist.");
        }
    }
}
