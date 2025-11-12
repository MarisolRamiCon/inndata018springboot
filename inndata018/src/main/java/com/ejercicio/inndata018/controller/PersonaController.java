package com.ejercicio.inndata018.controller;

import com.ejercicio.inndata018.entity.Persona;
import com.ejercicio.inndata018.model.PersonaDto;
import com.ejercicio.inndata018.service.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @GetMapping("/personas")
    public List<PersonaDto> readAll(){
        return personaService.readAll();
    }
}
