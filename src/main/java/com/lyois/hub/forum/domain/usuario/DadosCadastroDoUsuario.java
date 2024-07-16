package com.lyois.hub.forum.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDoUsuario(@NotBlank
                                     String login,
                                     @NotBlank
                                     String senha,
                                     @NotBlank
                                     @Email
                                     String email) {
}
