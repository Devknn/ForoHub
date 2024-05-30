package com.reinek.forohub.forohub.autor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DatosAutor(
    @NotBlank
    String nombre,
    @NotBlank
    @Email
    String correo_electronico,
    @Pattern(regexp = "\\d{4,9}",message = "La contraseña debe de contener de 4 a 9 digitos.")
    String contrasena,
    @NotNull
    @Valid
    Perfil perfil
) {

}
