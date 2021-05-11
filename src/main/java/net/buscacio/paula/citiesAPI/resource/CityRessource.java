package net.buscacio.paula.citiesAPI.resource;

import net.buscacio.paula.citiesAPI.entity.City;
import net.buscacio.paula.citiesAPI.exception.ResourceNotFoundException;
import net.buscacio.paula.citiesAPI.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityRessource {

    public CityService cityService;

    public CityRessource(CityService cityService) {
        this.cityService = cityService;
    }

    //get cities by pages
    @GetMapping
    public ResponseEntity<Page<City>> getAllCountries(Pageable page) {
        return new ResponseEntity<>(cityService.findAll(page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findCityById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(cityService.findById(id), HttpStatus.OK);
    }

}
