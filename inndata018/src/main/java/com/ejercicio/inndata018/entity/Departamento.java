package com.ejercicio.inndata018.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor //Anotation para el constructor sin argumentos
@AllArgsConstructor //para el constructor con todos los argumentos
@Data //para los getter y setter


@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "m2")
    private Integer m2;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "activo")
    private Boolean activo=true;

}
