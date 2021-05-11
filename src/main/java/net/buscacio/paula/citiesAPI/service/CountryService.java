package net.buscacio.paula.citiesAPI.service;

import net.buscacio.paula.citiesAPI.entity.Country;
import net.buscacio.paula.citiesAPI.exception.ResourceNotFoundException;
import net.buscacio.paula.citiesAPI.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Page<Country> findAll(Pageable page) {
        return countryRepository.findAll(page);
    }

    public Country findById(Long id) throws ResourceNotFoundException {
        return countryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
    }

}
