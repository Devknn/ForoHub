package com.reinek.forohub.forohub.topico;

import com.reinek.forohub.forohub.autor.DatosAutor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record  DatosActualizacionTopico(
    @NotNull
    Long id,
    String titulo,
    String mensaje,
    @Valid
    DatosAutor autor
) {

}
