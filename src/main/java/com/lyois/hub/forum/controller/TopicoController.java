package com.lyois.hub.forum.controller;

import com.lyois.hub.forum.domain.postagem.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity criarTopico(@RequestBody @Valid DadosCriacaoDoTopico dados){
        topicoService.criarTopico(dados);
        return ResponseEntity.ok(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoDoTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"curso"}) Pageable pageable){
        var page = topicoRepository.findAll(pageable).map(DadosDetalhamentoDoTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhesTopico(@PathVariable Long id){
        var dto = topicoService.detalharTopico(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoDoTopico dados){
        var dto = topicoService.atualizarTopico(id, dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTopico(@PathVariable Long id){
        var delete = topicoService.deletarTopico(id);
        return ResponseEntity.noContent().build();
    }

}
