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
       // PersonaResponse personaResponse= new PersonaResponse();
        Persona persona1 = new Persona();

        if(persona.isPresent()){
            persona1= persona.get();
            persona1.setNombre(personaRequest.getNombre());
            persona1.setEdad(personaRequest.getEdad());
            persona1=personaRepository.save(persona1);

            return new PersonaResponse(id,persona1.getNombre(),persona1.getEdad(),
                    persona1.getIdDepartamento().getId());
        }else {
            return new PersonaResponse();
        }

    }
}
