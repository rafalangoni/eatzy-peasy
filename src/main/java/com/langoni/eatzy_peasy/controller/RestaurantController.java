package com.langoni.eatzy_peasy.controller;

import com.langoni.eatzy_peasy.model.Restaurant;
import com.langoni.eatzy_peasy.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
