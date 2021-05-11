package net.buscacio.paula.citiesAPI.repository;

import net.buscacio.paula.citiesAPI.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
