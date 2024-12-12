package com.langoni.eatzy_peasy.controller;

import com.langoni.eatzy_peasy.model.Restaurant;
import com.langoni.eatzy_peasy.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping
    public List<Restaurant> getAll(){
        return restaurantRepository.listAllRestaurant();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantRepository.addRestaurant(restaurant);
    }

    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable Long id){
        return restaurantRepository.findById(id);
    }
}
