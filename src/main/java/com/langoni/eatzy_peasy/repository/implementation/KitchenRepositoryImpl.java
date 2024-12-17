package com.langoni.eatzy_peasy.repository.implementation;

import com.langoni.eatzy_peasy.model.Kitchen;
import com.langoni.eatzy_peasy.repository.KitchenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Kitchen> listAllKitchens() {
        TypedQuery<Kitchen> query = entityManager.createQuery("select k from Kitchen k", Kitchen.class);
        return query.getResultList();
    }

    @Override
    public Kitchen addKitchen(Kitchen kitchen) {
        entityManager.persist(kitchen);
        return kitchen;
    }

    @Override
    public Kitchen findKitchenById(Long id) {
        return entityManager.find(Kitchen.class, id);
    }

    @Override
    public void removeKitchen(Long id) {
        entityManager.remove(findKitchenById(id));
    }

    @Override
    public void removeKitchen(Kitchen kitchen) {
        entityManager.remove(findKitchenById(kitchen.getId()));
    }
}
