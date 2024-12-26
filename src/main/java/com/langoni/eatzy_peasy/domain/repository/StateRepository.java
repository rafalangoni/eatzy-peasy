package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
//    List<State> listAllStates();
//
//    State findStateById(Long id);
//
//    State saveState(State state);
//
//    void removeState(State state);
//
//    void removeState(Long id);
}
