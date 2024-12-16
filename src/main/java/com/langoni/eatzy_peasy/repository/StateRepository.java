package com.langoni.eatzy_peasy.repository;

import com.langoni.eatzy_peasy.model.State;

import java.util.List;

public interface StateRepository {
    List<State> listAllStates();
    State findStateById(Long id);
    State saveState(State state);
    void removeState(State state);
    void removeState(Long id);
}
