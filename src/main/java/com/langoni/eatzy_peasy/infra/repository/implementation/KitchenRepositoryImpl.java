package com.langoni.eatzy_peasy.infra.repository.implementation;

import com.langoni.eatzy_peasy.domain.model.Kitchen;
import com.langoni.eatzy_peasy.domain.repository.KitchenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Kitchen> listAllByName(String name) {
        TypedQuery<Kitchen> query = entityManager.createQuery("select k from Kitchen k where name like :name", Kitchen.class);
        return query.setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    @Transactional
    public Kitchen addKitchen(Kitchen kitchen) {
        entityManager.persist(kitchen);
        return kitchen;
    }

    @Override
    public Kitchen findKitchenById(Long id) {
        return entityManager.find(Kitchen.class, id);
    }

    @Override
    @Transactional
    public void removeKitchen(Long id) {
        entityManager.remove(findKitchenById(id));
    }

    @Override
    @Transactional
    public void removeKitchen(Kitchen kitchen) {
        entityManager.remove(findKitchenById(kitchen.getId()));
    }
}
