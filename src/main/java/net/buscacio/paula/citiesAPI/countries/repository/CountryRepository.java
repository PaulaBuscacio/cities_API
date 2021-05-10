package net.buscacio.paula.citiesAPI.countries.repository;

import net.buscacio.paula.citiesAPI.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
