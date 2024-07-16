package com.lyois.hub.forum.domain.postagem.topico;

import com.lyois.hub.forum.domain.autor.DadosDoAutor;
import com.lyois.hub.forum.domain.postagem.Curso;

import java.time.LocalDateTime;

public record DadosDoTopico(Long id,
                            String titulo,
                            String mensagem,
                            LocalDateTime data,
                            Boolean duvidaResolvida,
                            DadosDoAutor autor,
                            Curso curso) {
}
