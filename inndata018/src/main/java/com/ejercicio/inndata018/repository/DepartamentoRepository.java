package com.ejercicio.inndata018.repository;

import com.ejercicio.inndata018.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    //Metodos personalizados con palabras claves de Jpa
    public List<Departamento> findByPrecioGreaterThan(Double precio);
    //buscar los departamentos donde los m2 son menor o igual que 100 y precio es mayor o igual que 1500
    public List<Departamento> findByM2LessThanEqualAndPrecioGreaterThanEqual(Integer m2, Double precio);
    //Metodos personalizados por medio de Query
    @Query(value = "select * from departamento where m2<=:m2 and precio >=:precio", nativeQuery = true)
    public List<Departamento> m2AndPrecio(Integer m2, Double precio);


}
