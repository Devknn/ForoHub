package com.reinek.forohub.forohub.topico;

import com.reinek.forohub.forohub.autor.Autor;
import com.reinek.forohub.forohub.curso.Curso;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="Topico")
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Boolean estado;
    private String titulo;
    private String mensaje;
    @Embedded
    private Autor autor;
    private Curso curso;

    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.estado = true;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.autor = new Autor(datosRegistroTopico.autor());
        this.curso = new Curso(datosRegistroTopico.curso());

    }
    public void atualizarInformacion(DatosActualizacionTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if (datos.autor() != null){
            this.autor = autor.actualizarDatos(datos.autor());
        }
    }
    public void desactivar() {
        this.estado = false;
    }


}
