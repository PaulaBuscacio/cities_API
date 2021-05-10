package net.buscacio.paula.citiesAPI;

import net.buscacio.paula.citiesAPI.countries.Country;
import net.buscacio.paula.citiesAPI.countries.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")
public class CountryResource {

    private CountryRepository countryRepository;

    public CountryResource(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    //get countries by pages
    @GetMapping
    public Page<Country> getAllCountries(Pageable page) {
        return countryRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id) {
        Optional<Country> countryOptional = countryRepository.findById(id);
        if(countryOptional.isPresent()) {
            return ResponseEntity.ok().body(countryOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
