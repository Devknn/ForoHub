package com.reinek.forohub.forohub.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.reinek.forohub.forohub.domain.topico.DatosActualizacionTopico;
import com.reinek.forohub.forohub.domain.topico.DatosListadoTopico;
import com.reinek.forohub.forohub.domain.topico.DatosRegistroTopico;
import com.reinek.forohub.forohub.domain.topico.Topico;
import com.reinek.forohub.forohub.domain.topico.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class ForoHubController {
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    //Registrando Topico
     public ResponseEntity<DatosRespuestaTopico> registarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopicos,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopicos));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri(); 
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
    @GetMapping
    //Monstrando Topico en formato json
    public ResponseEntity<Page<DatosListadoTopico>> mostrarTopico(@PageableDefault(page = 0, size = 1,sort="nombre") Pageable paginacion){
        var page = topicoRepository.findAll(paginacion).map(DatosListadoTopico::new); 
        return ResponseEntity.ok(page);
    }
    //actualizar
    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizacionTopico datosActualizacionTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizacionTopico.id());
        topico.atualizarInformacion(datosActualizacionTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje()));


    }
    //Eliminar topico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.remover();
        return ResponseEntity.noContent().build();

        }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopicos = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje());
        return ResponseEntity.ok(datosTopicos);
    }


}
