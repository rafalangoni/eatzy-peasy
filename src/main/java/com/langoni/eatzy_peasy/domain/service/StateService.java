package com.langoni.eatzy_peasy.domain.service;

import com.langoni.eatzy_peasy.domain.model.State;
import com.langoni.eatzy_peasy.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> listALlStates(){
        return stateRepository.listAllStates();
    }

    public State findById(Long id){
        return stateRepository.findStateById(id);
    }

    public State addState(State state){
        return stateRepository.saveState(state);
    }

    public void removeState(Long id){
        stateRepository.removeState(id);
    }
}
