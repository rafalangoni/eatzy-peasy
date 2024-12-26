package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.Kitchen;

import java.util.List;

public interface KitchenRepository {
    List<Kitchen> listAllKitchens();
    List<Kitchen> listAllByName(String name);
    Kitchen addKitchen(Kitchen kitchen);
    Kitchen findKitchenById(Long id);
    void removeKitchen(Long id);
    void removeKitchen(Kitchen kitchen);
}
