package net.buscacio.paula.citiesAPI.service;

import net.buscacio.paula.citiesAPI.entity.City;
import net.buscacio.paula.citiesAPI.exception.ResourceNotFoundException;
import net.buscacio.paula.citiesAPI.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    public CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Page<City> findAll(Pageable page) {
        return cityRepository.findAll(page);
    }

    public City findById(Long id) throws ResourceNotFoundException {
        return cityRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
    }
}
