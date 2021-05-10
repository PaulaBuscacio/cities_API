package net.buscacio.paula.citiesAPI.cities;

import net.buscacio.paula.citiesAPI.countries.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityRessource {

    public CityRepository cityRepository;

    public CityRessource(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public Page<City> getAllCountries(Pageable page) {
        return cityRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getOne(@PathVariable Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if(cityOptional.isPresent()) {
            return ResponseEntity.ok().body(cityOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
