package com.ejercicio.inndata018.service.impl;

import com.ejercicio.inndata018.entity.Persona;
import com.ejercicio.inndata018.model.PersonaDto;
import com.ejercicio.inndata018.repository.PersonaRepository;
import com.ejercicio.inndata018.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public List<PersonaDto> readAll() {
        List<Persona> listaDePersonas=personaRepository.findAll();
        List<PersonaDto> listaFinal= listaDePersonas.stream().map(
                persona -> {
                    PersonaDto personaDto=new PersonaDto(persona.getId(),persona.getNombre(), persona.getEdad(),
                            persona.getIdDepartamento().getId());
                    return personaDto;

                })
                .toList();
        return listaFinal;
    }
}
