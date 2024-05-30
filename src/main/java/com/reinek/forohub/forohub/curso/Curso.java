package com.reinek.forohub.forohub.curso;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Curso {
    private String nombre_curso;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosCurso datosCurso){
        this.nombre_curso = datosCurso.nombre_curso();
        this.categoria = datosCurso.categoria();
    }

}
