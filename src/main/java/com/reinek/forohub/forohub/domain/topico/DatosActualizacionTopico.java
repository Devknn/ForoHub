package com.reinek.forohub.forohub.domain.topico;



import com.reinek.forohub.forohub.domain.autor.DatosAutor;
import com.reinek.forohub.forohub.domain.curso.DatosCurso;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record  DatosActualizacionTopico(
    @NotNull
    Long id,
    String titulo,
    String mensaje,
    @Valid
    DatosAutor autor,
    @Valid
    DatosCurso curso
) {

}
