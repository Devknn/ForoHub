package com.reinek.forohub.forohub.domain.curso;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCurso(
    @NotBlank
    String nombre_curso,
    @NotNull
    @Valid
    Categoria categoria
) {

}
