package com.ejercicio.inndata018.service;

import com.ejercicio.inndata018.entity.Departamento;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {
    public List<Departamento> readAll();
    public Optional<Departamento> readById(Integer id);
}
