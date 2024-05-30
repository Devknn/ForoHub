package com.reinek.forohub.forohub.autor;

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
public class Autor {
    private String nombre;
    private String correo_electronico;
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    public Autor (DatosAutor datosAutor) {
    this.nombre = datosAutor.nombre();
    this.correo_electronico = datosAutor.correo_electronico();
    this.contrasena = datosAutor.contrasena();
    this.perfil = datosAutor.perfil();
    }

    public Autor actualizarDatos(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.correo_electronico = datosAutor.correo_electronico();
        this.contrasena = datosAutor.contrasena();
        this.perfil = datosAutor.perfil();
        return this;

    }


}
