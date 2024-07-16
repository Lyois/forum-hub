package com.lyois.hub.forum.domain.autor;

public record DadosDoAutor(
        Long id,
        String nome) {

    public DadosDoAutor(Autor autor) {
        this(autor.getId(), autor.getNome());
    }

}