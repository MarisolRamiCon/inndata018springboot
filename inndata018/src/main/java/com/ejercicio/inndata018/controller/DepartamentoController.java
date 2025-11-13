package com.ejercicio.inndata018.controller;

import com.ejercicio.inndata018.entity.Departamento;
import com.ejercicio.inndata018.service.impl.DepartamentoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DepartamentoController {
    @Autowired
    DepartamentoService departamentoService;
    //METODOS CRUD C>CREATE, R>READ. U> UPDATE, D> DELETE
    //GETMAPPING POSTMAPPING PUTMAPPING DELETEMAPPING
    @GetMapping("/departamentos")
    public List<Departamento> readAll(){
        return departamentoService.readAll();
    }
    @GetMapping("/departamentos/{id}")
    public Optional<Departamento> readById(@PathVariable Integer id){
        return departamentoService.readById(id);
    }

    // Cuando el metodo es para crear se usa POSTMAPPING
    @PostMapping("/departamento")
    public Departamento create(@RequestBody Departamento departamento){
        return departamentoService.create(departamento);
    }

    @PutMapping("/departamentos")
    public Departamento update(@RequestBody Departamento departamento){
        return departamentoService.update(departamento);
    }

    @PutMapping("/departamentos/{id}")
    public String updateById(@PathVariable Integer id, @RequestBody Departamento departamento){
        return departamentoService.updateById(id,departamento);
    }

    @DeleteMapping("/departamentos")
    public String delete(@PathParam("id") Integer id){
        return departamentoService.delete(id);
    }

    @GetMapping("/departamentosPrecio")
    public List<Departamento> findByPrecio(@PathParam("precio") Double precio){
        return departamentoService.findByPrecio(precio);
    }

    @GetMapping("/departamentosPrecioM2")
    public List<Departamento> findByM2Precio(@PathParam("m2") Integer m2, @PathParam("precio") Double precio){
        return departamentoService.findByM2Precio(m2,precio);
    }

    @GetMapping("/departamentos/queryprecio")
    public List<Departamento> m2AndPrecio(@PathParam("m2") Integer m2,@PathParam("precio") Double precio){
        return departamentoService.m2AndPrecio(m2,precio);
    }


}
