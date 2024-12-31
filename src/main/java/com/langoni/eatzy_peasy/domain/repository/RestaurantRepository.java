package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends
        CustomJpaRepository<Restaurant, Long>,
        RestaurantRepositoryImplInterface,
        JpaSpecificationExecutor<Restaurant> {

//    @Query("select r from Restaurant r where r.name like %:nameParameter%")
    List<Restaurant> findByNameSqlLike(@Param("nameParameter") String name);



//    List<Restaurant> listAllRestaurant();
////    Restaurant updateRestaurant(Long id, Restaurant restaurant);
//    void addRestaurant(Restaurant restaurant);
//    Restaurant findRestaurantById(Long id);
//    void deleteRestaurant(Long id);
}
