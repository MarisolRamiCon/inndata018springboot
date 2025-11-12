package com.ejercicio.inndata018.repository;

import com.ejercicio.inndata018.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
