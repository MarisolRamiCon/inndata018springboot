package com.ejercicio.inndata018.service.impl;

import com.ejercicio.inndata018.feign.ViajeClient;
import com.ejercicio.inndata018.model.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService implements ViajeClient {
    @Autowired
    ViajeClient viajeClient;
    @Override
    public List<Viaje> readAll() {
        return viajeClient.readAll();
    }
}