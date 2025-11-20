package com.ejercicio.inndata018.service;


import com.ejercicio.inndata018.model.request.PersonaRequest;
import com.ejercicio.inndata018.model.response.PersonaResponse;

import java.util.List;

public interface IPersonaService {
    public List<PersonaResponse> readAll();
    public PersonaResponse update(Integer id, PersonaRequest personaRequest);
}
