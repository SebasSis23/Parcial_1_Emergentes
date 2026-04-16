package com.Parcial1.emergentes_parcial.controller;

import com.Parcial1.emergentes_parcial.model.Estudiante;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private List<Estudiante> listaEstudiantes = new ArrayList<>();

    // Esto agregará datos automáticamente al iniciar
    public EstudianteController() {
        Estudiante e1 = new Estudiante();
        e1.setNombre("Sebastian");
        e1.setApellido("FLores");
        e1.setEdad(19);
        e1.setCarrera("Ingeniería de Sistemas");
        e1.setMatricula("Sis");

        Estudiante e2 = new Estudiante();
        e2.setNombre("Ana");
        e2.setApellido("Fuertes");
        e2.setEdad(22);
        e2.setCarrera("Ingeniería de Sistemas");
        e2.setMatricula("Mat");

        listaEstudiantes.add(e1);
        listaEstudiantes.add(e2);
    }

    @GetMapping
    public List<Estudiante> listar() {
        return listaEstudiantes;
    }

    @PostMapping
    public String guardar(@RequestBody Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
        return "Estudiante registrado correctamente";
    }

    @PutMapping("/{indice}")
    public String actualizar(@PathVariable int indice, @RequestBody Estudiante estudiante) {
        if (indice >= 0 && indice < listaEstudiantes.size()) {
            listaEstudiantes.set(indice, estudiante);
            return "Datos del estudiante actualizados";
        }
        return "Error: Estudiante no encontrado";
    }

    @DeleteMapping("/{indice}")
    public String eliminar(@PathVariable int indice) {
        if (indice >= 0 && indice < listaEstudiantes.size()) {
            listaEstudiantes.remove(indice);
            return "Estudiante eliminado con éxito";
        }
        return "Error: No se pudo eliminar";
    }
}