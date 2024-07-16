package com.lyois.hub.forum.domain.autor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDoAutor(@NotBlank
                                   String nome) {
}
