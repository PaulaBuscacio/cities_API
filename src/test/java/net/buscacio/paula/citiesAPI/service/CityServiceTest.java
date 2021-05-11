package net.buscacio.paula.citiesAPI.service;

import net.buscacio.paula.citiesAPI.entity.City;
import net.buscacio.paula.citiesAPI.exception.ResourceNotFoundException;
import net.buscacio.paula.citiesAPI.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {


    @Mock
    private CityRepository cityRepository;

    static City createFakeCity() {
        City city = new City(1L, "CityTest", 32, 28);

        return city;
    }

    @Test
    void testfindCityById() throws ResourceNotFoundException {
        assertEquals(createFakeCity().getId(), 1L);
    }

    @Test
    void testfindCityByIdUnhappyPath() throws ResourceNotFoundException {
        assertNotEquals(createFakeCity().getId(), 2L);
    }

    @Test
    void testFindAll() {
        cityRepository.findAll();
    }
}
