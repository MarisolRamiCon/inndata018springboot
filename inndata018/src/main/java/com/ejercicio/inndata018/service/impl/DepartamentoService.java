package com.ejercicio.inndata018.service.impl;

import com.ejercicio.inndata018.entity.Departamento;
import com.ejercicio.inndata018.repository.DepartamentoRepository;
import com.ejercicio.inndata018.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    //INYECCION DE DEPENDENCIA
    DepartamentoRepository departamentoRepository;
    @Override
    public List<Departamento> readAll() {
        return departamentoRepository.findAll();
    }
}
