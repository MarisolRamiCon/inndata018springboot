package com.ejercicio.inndata018.service;

import com.ejercicio.inndata018.entity.Departamento;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {
    public List<Departamento> readAll();
    public Optional<Departamento> readById(Integer id);
    //METODOS CRUD C>CREATE, R>READ. U> UPDATE, D> DELETE
    public Departamento create(Departamento departamento);
    public Departamento update(Departamento departamento);
    public String updateById(Integer id, Departamento departamento);
    public String delete(Integer id);

    //Metodos personalizados por medio de palabras claves de JpaRepository
    public List<Departamento> findByPrecio (Double precio);
    public List<Departamento> findByM2Precio (Integer m2, Double precio);
    public List<Departamento> m2AndPrecio(Integer m2,Double precio);
}
