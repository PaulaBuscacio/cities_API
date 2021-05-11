package net.buscacio.paula.citiesAPI.service;

import net.buscacio.paula.citiesAPI.entity.State;
import net.buscacio.paula.citiesAPI.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StateServiceTest {

    @Mock
    private StateService stateService;

    State createFakeState() {

        State state = new State(1L, "Test", "TS", 888);
        return state;
    }

    @Test
    void testSave() {
        stateService.save(1L, "Test", "TS", 888);
    }

    @Test
    void testfindTestById() throws ResourceNotFoundException {
        assertEquals(createFakeState().getId(), 1L);
    }

    @Test
    void findAll() {
        stateService.findAll();
    }

}


