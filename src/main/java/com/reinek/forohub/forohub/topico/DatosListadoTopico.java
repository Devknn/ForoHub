package com.reinek.forohub.forohub.topico;

public record DatosListadoTopico(
   Long id,
    String titulo,
    String mensaje,
    String autor,
    String curso
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(), topico.getMensaje(), topico.getAutor().toString(), topico.getCurso().toString());
    }
    
}