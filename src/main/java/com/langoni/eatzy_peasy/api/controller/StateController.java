package com.langoni.eatzy_peasy.api.controller;

import com.langoni.eatzy_peasy.domain.model.State;
import com.langoni.eatzy_peasy.domain.service.StateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<State> listAll() {
        return stateService.listALlStates();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<State> addState(@RequestBody State state) {
        stateService.addState(state);
        return ResponseEntity.status(HttpStatus.CREATED).body(state);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeState(@PathVariable Long id) {
        stateService.removeState(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<State> updateState(@PathVariable Long id, @RequestBody State state) {
        try {
            State retrievedState = stateService.findById(id).orElse(null);
            if (retrievedState != null) {
                BeanUtils.copyProperties(state, retrievedState, "id");
                stateService.addState(retrievedState);
                return ResponseEntity.ok(retrievedState);
            }
        } catch (BeansException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
