package com.ejercicio.inndata018.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaRequest {
    private String nombre;
    private Integer edad;
}
