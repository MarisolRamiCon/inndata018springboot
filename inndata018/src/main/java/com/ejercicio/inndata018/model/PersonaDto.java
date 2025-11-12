package com.ejercicio.inndata018.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonaDto {
    private Integer id;
    private String nombre;
    private Integer edad;
    private Integer idDepartamento;
}
