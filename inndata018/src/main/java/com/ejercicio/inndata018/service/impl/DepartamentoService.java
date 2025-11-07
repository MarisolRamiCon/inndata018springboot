package com.ejercicio.inndata018.service.impl;

import com.ejercicio.inndata018.entity.Departamento;
import com.ejercicio.inndata018.repository.DepartamentoRepository;
import com.ejercicio.inndata018.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    //INYECCION DE DEPENDENCIA
    DepartamentoRepository departamentoRepository;
    @Override
    public List<Departamento> readAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public Optional<Departamento> readById(Integer id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public Departamento create(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento update(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public String updateById(Integer id, Departamento departamento) {
        Optional<Departamento> departamento1= departamentoRepository.findById(id);
        if(departamento1.isPresent()){
            departamentoRepository.save(departamento);
            return("Departamento actualizado");
        }else{
            return "No esta ese departamento";
        }


    }


}
