package net.buscacio.paula.citiesAPI.service;

import net.buscacio.paula.citiesAPI.entity.State;
import net.buscacio.paula.citiesAPI.exception.ResourceNotFoundException;
import net.buscacio.paula.citiesAPI.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    public State findById(Long id) throws ResourceNotFoundException {
        return stateRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
    }

    public State save(Long id, String name, String uf, Integer ibgeCode) {
       State state = new State(id, name, uf,  ibgeCode);

       return stateRepository.save(state);
    }
}
