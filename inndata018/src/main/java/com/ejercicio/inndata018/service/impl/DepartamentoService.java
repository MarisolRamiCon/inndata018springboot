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
        return departamentoRepository.findAll().stream().filter(departamento -> departamento.getActivo().equals(true)).toList();
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
            Departamento departamentoModificado= departamento1.get();
            //Modificar solo los atributos que se deben modificar, m2 y precio
            try {
                departamentoModificado.setM2(departamento.getM2());
                departamentoModificado.setPrecio(departamento.getPrecio());
                departamentoRepository.save(departamentoModificado);
                return ("Departamento actualizado");
            } catch (Exception e) {
                return "Tienes que modificar todos los campos excepto el id";
            }
        }else{
            return "No esta ese departamento";
        }
    }

    @Override
    public String delete(Integer id) {
        Optional<Departamento> departamento= departamentoRepository.findById(id);
        if(departamento.isPresent()) {
            Departamento departamento1= departamento.get();
            departamento1.setActivo(false);
            departamentoRepository.save(departamento1);
            return "El departamento ha sido borrado";
        }else{
            return "No hay tal departamento";
        }
    }
}
