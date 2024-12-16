package com.langoni.eatzy_peasy.repository;

import com.langoni.eatzy_peasy.model.Kitchen;

import java.util.List;

public interface KitchenRepository {
    List<Kitchen> listAllKitchens();
    Kitchen addKitchen(Kitchen kitchen);
    Kitchen findKitchenById(Long id);
    void removeKitchen(Long id);
    void removeKitchen(Kitchen kitchen);
}
