package com.reinek.forohub.forohub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinek.forohub.forohub.topico.DatosListadoTopico;
import com.reinek.forohub.forohub.topico.DatosRegistroTopico;
import com.reinek.forohub.forohub.topico.Topico;
import com.reinek.forohub.forohub.topico.TopicoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class ForoHubController {
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    //Registrando Topico
    public void registarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopicos) {
        topicoRepository.save(new Topico(datosRegistroTopicos)); 
    }
    //Monstrando Topico en formato json

}
