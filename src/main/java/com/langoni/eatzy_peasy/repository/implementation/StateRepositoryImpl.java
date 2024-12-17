package com.langoni.eatzy_peasy.repository.implementation;

import com.langoni.eatzy_peasy.model.State;
import com.langoni.eatzy_peasy.repository.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<State> listAllStates() {
        TypedQuery<State> query = entityManager.createQuery("select s from State s", State.class);
        return query.getResultList();
    }

    @Override
    public State findStateById(Long id) {
       return entityManager.find(State.class, id);
    }

    @Override
    @Transactional
    public State saveState(State state) {
        entityManager.persist(state);
        return state;
    }

    @Override
    @Transactional
    public void removeState(State state) {
        entityManager.remove(findStateById(state.getId()));
    }

    @Override
    @Transactional
    public void removeState(Long id) {
        entityManager.remove(findStateById(id));
    }
}
