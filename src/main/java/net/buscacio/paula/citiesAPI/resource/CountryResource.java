package net.buscacio.paula.citiesAPI.resource;

import net.buscacio.paula.citiesAPI.entity.Country;
import net.buscacio.paula.citiesAPI.exception.ResourceNotFoundException;
import net.buscacio.paula.citiesAPI.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/countries")
public class CountryResource {

    private CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    //get countries by pages
    @GetMapping
    public ResponseEntity<Page<Country>> getAllCountries(Pageable page) {
        return new ResponseEntity<>(countryService.findAll(page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountryById(@PathVariable Long id) throws ResourceNotFoundException {
       return new ResponseEntity<>(countryService.findById(id), HttpStatus.OK);
    }


}
