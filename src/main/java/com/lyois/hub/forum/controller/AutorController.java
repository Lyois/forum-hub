package com.lyois.hub.forum.controller;

import com.lyois.hub.forum.domain.autor.Autor;
import com.lyois.hub.forum.domain.autor.AutorRepository;
import com.lyois.hub.forum.domain.autor.DadosCadastroDoAutor;
import com.lyois.hub.forum.domain.autor.DadosDoAutor;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("autores")
@SecurityRequirement(name = "bearer-key")
public class AutorController {
    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroAutor(@RequestBody @Valid DadosCadastroDoAutor dados, UriComponentsBuilder uriBuilder) {
        var autor = new Autor(dados);
        repository.save(autor);
        var uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDoAutor(autor));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarAutor(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDoAutor(user));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDoAutor>> listarAutores(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosDoAutor::new);
        return ResponseEntity.ok(page);
    }

}
