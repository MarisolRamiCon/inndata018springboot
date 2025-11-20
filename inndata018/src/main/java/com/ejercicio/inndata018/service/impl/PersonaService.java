package com.ejercicio.inndata018.service.impl;

import com.ejercicio.inndata018.entity.Persona;
import com.ejercicio.inndata018.model.request.PersonaRequest;
import com.ejercicio.inndata018.model.response.PersonaResponse;
import com.ejercicio.inndata018.repository.PersonaRepository;
import com.ejercicio.inndata018.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public List<PersonaResponse> readAll() {
        List<Persona> listaDePersonas=personaRepository.findAll();
        List<PersonaResponse> listaFinal= listaDePersonas.stream().map(
                persona -> {
                    PersonaResponse personaResponse =new PersonaResponse(persona.getId(),persona.getNombre(), persona.getEdad(),
                            persona.getIdDepartamento().getId());
                    return personaResponse;

                })
                .toList();
        return listaFinal;
    }

    @Override
    public PersonaResponse update(Integer id, PersonaRequest personaRequest) {
        Optional<Persona> persona= personaRepository.findById(id);
        if(persona.isPresent()){
            Persona persona2= persona.get();
            Persona personaResponse= new Persona();
            personaResponse.setId(id);
            personaResponse.setNombre(personaRequest.getNombre());
            personaResponse.setEdad(personaRequest.getEdad());
            personaResponse.setIdDepartamento(persona2.getIdDepartamento());
            personaRepository.save(personaResponse);
        }
        return new PersonaResponse(id,personaRequest.getNombre(),personaRequest.getEdad(),persona.get().getIdDepartamento().getId());
    }
}
