package com.ejercicio.inndata018.controller;

import com.ejercicio.inndata018.model.request.PersonaRequest;
import com.ejercicio.inndata018.model.response.PersonaResponse;
import com.ejercicio.inndata018.service.impl.PersonaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @GetMapping("/personas")
    public List<PersonaResponse> readAll(){
        return personaService.readAll();
    }
    @PutMapping("/personas")
    public PersonaResponse update(@PathParam("id") Integer id, @RequestBody PersonaRequest personaRequest){
        return personaService.update(id,personaRequest);
    }
}
