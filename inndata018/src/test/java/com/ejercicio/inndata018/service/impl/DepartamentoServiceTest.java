package com.ejercicio.inndata018.service.impl;

import com.ejercicio.inndata018.entity.Departamento;
import com.ejercicio.inndata018.repository.DepartamentoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {

    Departamento d1= new Departamento(1,100,500.,true);
    Departamento d2= new Departamento(2,200,600.,true);
    Departamento d3= new Departamento(3,300,700.,true);

    @InjectMocks
    DepartamentoService departamentoService;

    @Mock
    DepartamentoRepository departamentoRepository;

    @BeforeEach
    void setUp() {
        System.out.println("se esta ejecutando before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Se esta ejecutando after");
    }


    @Test
    void suma() {
        int num1= departamentoService.suma(9,5);
        //resultado esperado 14
        assertEquals(14,num1);
    }

    @Test
    void updateById() {
        Mockito.when(departamentoRepository.findById(1)).thenReturn(Optional.of(d1));
        d1.setM2(150);
        d1.setPrecio(550.5);
        Mockito.when(departamentoRepository.save(d1)).thenReturn(d1);
        assertEquals("Departamento actualizado",departamentoService.updateById(1,d1));
    }

    @Test
    void UpdateByIdElse() {
        Departamento d4= new Departamento();
        Mockito.when(departamentoRepository.findById(4)).thenReturn(Optional.empty());
        assertEquals("No esta ese departamento", departamentoService.updateById(4,d4));
    }
}