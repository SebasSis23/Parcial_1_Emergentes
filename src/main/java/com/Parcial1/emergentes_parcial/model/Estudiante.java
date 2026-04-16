package com.Parcial1.emergentes_parcial.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "nombre", "apellido", "edad", "carrera", "matricula" })
public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private String matricula;
}