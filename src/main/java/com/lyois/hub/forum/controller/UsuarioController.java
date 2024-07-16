package com.lyois.hub.forum.controller;

import com.lyois.hub.forum.domain.usuario.DadosDoUsuario;
import com.lyois.hub.forum.domain.usuario.Usuario;
import com.lyois.hub.forum.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosDoUsuario dados) throws SQLIntegrityConstraintViolationException {
        if (this.repository.findByLogin(dados.login()) != null) {
            return ResponseEntity.badRequest().body("Login já cadastrado!");
        }

        String encryptedSenha = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario novoUsuario = new Usuario(dados.login(), encryptedSenha, dados.email());

        this.repository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }
}