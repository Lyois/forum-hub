package com.lyois.hub.forum.domain.postagem.topico;

import com.lyois.hub.forum.domain.postagem.Curso;
import jakarta.validation.constraints.NotNull;

public record DadosCriacaoDoTopico(@NotNull
                                   String titulo,
                                   @NotNull
                                   String mensagem,
                                   @NotNull
                                   Long idAutor,
                                   @NotNull
                                   @NotNull
                                   Curso curso) {
}
