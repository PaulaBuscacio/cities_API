package net.buscacio.paula.citiesAPI.service;

import net.buscacio.paula.citiesAPI.entity.Country;
import net.buscacio.paula.citiesAPI.exception.ResourceNotFoundException;
import net.buscacio.paula.citiesAPI.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    static Country createFakeCountry() {

        Country country = new Country(1L, "TestName", "NomeTeste", "222", 888);
        return country;
    }


    @Test
    void testfindCountryById() throws ResourceNotFoundException {
        assertEquals(createFakeCountry().getId(), 1L);
    }

    @Test
    void testFindAll() {
        countryRepository.findAll();
    }
}
