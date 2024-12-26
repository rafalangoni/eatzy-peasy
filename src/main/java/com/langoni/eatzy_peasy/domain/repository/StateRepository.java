package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository {
    List<State> listAllStates();

    State findStateById(Long id);

    State saveState(State state);

    void removeState(State state);

    void removeState(Long id);
}
