package com.langoni.eatzy_peasy.api.controller;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import com.langoni.eatzy_peasy.infra.repository.implementation.RestaurantRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepositoryImpl restaurantRepository;

    @GetMapping
    public List<Restaurant> getAll(){
        return restaurantRepository.listAllRestaurant();
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant){
        return restaurantRepository.updateRestaurant(id, restaurant);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant){
        restaurantRepository.addRestaurant(restaurant);
    }

    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable Long id){
        return restaurantRepository.findRestaurantById(id);
    }

    @DeleteMapping("/{id}")
    public void removeRestaurant(@PathVariable Long id){
        restaurantRepository.deleteRestaurant(id);
    }
}
