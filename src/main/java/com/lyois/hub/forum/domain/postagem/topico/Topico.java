package com.lyois.hub.forum.domain.postagem.topico;

import com.lyois.hub.forum.domain.autor.Autor;
import com.lyois.hub.forum.domain.postagem.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data;
    private Boolean duvidaResolvida;
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DadosCriacaoDoTopico dados, Autor autor){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = LocalDateTime.now();
        this.duvidaResolvida = false;
        this.autor = autor;
        this.curso = dados.curso();
    }

    public void atualizarInformacoes(DadosAtualizacaoDoTopico dados){
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.duvidaResolvida() != null){
            this.duvidaResolvida = dados.duvidaResolvida();
        }
    }
}
