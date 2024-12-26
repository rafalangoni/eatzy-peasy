package com.langoni.eatzy_peasy.api.controller;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import com.langoni.eatzy_peasy.domain.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAll(){
        return restaurantService.listAllRestaurant();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant){
        try {
            var retrievedRestaurant = restaurantService.findRestaurantById(restaurant.getId()).orElse(null);
            if(retrievedRestaurant != null){
                BeanUtils.copyProperties(restaurant, retrievedRestaurant, "id");
                restaurantService.addRestaurant(retrievedRestaurant);
                return ResponseEntity.status(HttpStatus.OK).body(retrievedRestaurant);
            }
            return ResponseEntity.notFound().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getById(@PathVariable Long id){
        return restaurantService.findRestaurantById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRestaurant(@PathVariable Long id){
        restaurantService.deleteRestaurant(id);
    }
}
