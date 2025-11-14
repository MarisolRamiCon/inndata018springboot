package com.ejercicio.inndata018.controller;

import com.ejercicio.inndata018.model.Viaje;
import com.ejercicio.inndata018.service.impl.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ViajeController {
    @Autowired
    ViajeService viajeService;
    @GetMapping("viaje")
    List<Viaje> readAll(){
        return viajeService.readAll();
    }
}
