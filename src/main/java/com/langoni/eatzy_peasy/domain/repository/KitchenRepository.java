package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
//    List<Kitchen> listAllKitchens();
//    List<Kitchen> listAllByName(String name);
//    Kitchen addKitchen(Kitchen kitchen);
//    Kitchen findKitchenById(Long id);
//    void removeKitchen(Long id);
//    void removeKitchen(Kitchen kitchen);
}
