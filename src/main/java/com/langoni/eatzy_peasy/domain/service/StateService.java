package com.langoni.eatzy_peasy.domain.service;

import com.langoni.eatzy_peasy.domain.model.State;
import com.langoni.eatzy_peasy.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> listALlStates(){
        return stateRepository.findAll();
    }

    public Optional<State> findById(Long id){
        return stateRepository.findById(id);
    }

    public State addState(State state){
        return stateRepository.save(state);
    }

    public void removeState(Long id){
        stateRepository.deleteById(id);
    }
}
