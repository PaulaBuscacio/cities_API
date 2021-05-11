package net.buscacio.paula.citiesAPI.resource;

import net.buscacio.paula.citiesAPI.entity.State;
import net.buscacio.paula.citiesAPI.exception.ResourceNotFoundException;
import net.buscacio.paula.citiesAPI.service.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource {

    private StateService stateService;

    public StateResource(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public ResponseEntity<List<State>> findAllStates() {
        return new ResponseEntity<>(stateService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> findStateById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(stateService.findById(id), HttpStatus.OK);
    }

}
