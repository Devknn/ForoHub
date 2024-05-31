package com.reinek.forohub.forohub.controller;

import com.reinek.forohub.forohub.domain.autor.DatosAutor;

public record DatosDetalladoTopico(
    String titulo, 
    String mensaje, 
    DatosAutor autor) 
    {

} 