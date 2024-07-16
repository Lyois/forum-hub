package com.lyois.hub.forum.domain.postagem.topico;

import com.lyois.hub.forum.domain.autor.DadosDoAutor;
import com.lyois.hub.forum.domain.postagem.Curso;

import java.time.LocalDateTime;

public record DadosDetalhamentoDoTopico(Long id,
                                        String titulo,
                                        String mensagem,
                                        LocalDateTime data,
                                        Boolean duvidaResolvida,
                                        DadosDoAutor autor,
                                        Curso curso) {

    public DadosDetalhamentoDoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(),
                topico.getDuvidaResolvida(), new DadosDoAutor(topico.getAutor()), topico.getCurso());
    }
}
