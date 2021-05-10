package net.buscacio.paula.citiesAPI.states;

import net.buscacio.paula.citiesAPI.countries.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResource {

    private StateRepository stateRepository;

    public StateResource(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getOne(@PathVariable Long id) {
        Optional<State> stateOptional = stateRepository.findById(id);
        if(stateOptional.isPresent()) {
            return ResponseEntity.ok().body(stateOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
