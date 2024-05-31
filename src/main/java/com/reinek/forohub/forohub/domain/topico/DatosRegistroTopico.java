package com.reinek.forohub.forohub.domain.topico;

import com.reinek.forohub.forohub.domain.autor.DatosAutor;
import com.reinek.forohub.forohub.domain.curso.DatosCurso;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
    @NotBlank
    String titulo,
    @NotBlank
    String mensaje,
    // fechaCreacion
    //status
    @NotNull
    @Valid
    DatosAutor autor,
    @NotNull
    @Valid
    DatosCurso curso  
) {

}
