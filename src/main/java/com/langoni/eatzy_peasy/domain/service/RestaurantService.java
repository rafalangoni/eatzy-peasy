package com.langoni.eatzy_peasy.domain.service;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import com.langoni.eatzy_peasy.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> listAllRestaurant() {
        return restaurantRepository.findAll();
    }

//    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
//        return restaurantRepository.updateRestaurant(id, restaurant);
//    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public Optional<Restaurant> findRestaurantById(Long id) {
        return restaurantRepository.findById(id);

    }

    public void deleteRestaurant(Long id) {
        var restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            restaurantRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Restaurant with id " + id + " does not exist.");
        }
    }
}
