package com.reinek.forohub.forohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinek.forohub.forohub.topico.DatosActualizacionTopico;
import com.reinek.forohub.forohub.topico.DatosListadoTopico;
import com.reinek.forohub.forohub.topico.DatosRegistroTopico;
import com.reinek.forohub.forohub.topico.Topico;
import com.reinek.forohub.forohub.topico.TopicoRepository;

import jakarta.transaction.Transactional;
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
    @GetMapping
    //Monstrando Topico en formato json
    public Page<DatosListadoTopico> mostrarTopico(@PageableDefault(page = 0, size = 1,sort="nombre") Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new); 
    }
    //actualizar
    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizacionTopico datosActualizacionTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizacionTopico.id());
        topico.atualizarInformacion(datosActualizacionTopico);
    }
    //Eliminar topico
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.desactivar();
}

}
