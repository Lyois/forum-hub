package com.lyois.hub.forum.domain.postagem.topico;

import com.lyois.hub.forum.domain.ValidacaoException;
import com.lyois.hub.forum.domain.autor.Autor;
import com.lyois.hub.forum.domain.autor.AutorRepository;
import com.lyois.hub.forum.domain.autor.DadosDoAutor;
import com.lyois.hub.forum.domain.usuario.Usuario;
import com.lyois.hub.forum.domain.usuario.UsuarioRepository;
import com.lyois.hub.forum.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public DadosDetalhamentoDoTopico criarTopico(DadosCriacaoDoTopico dados) {

        Autor autor = autorRepository.getReferenceById(dados.idAutor());
        var topico = new Topico(dados, autor);
        topicoRepository.save(topico);
        return null;
    }

    public DadosDetalhamentoDoTopico atualizarTopico(Long id, DadosAtualizacaoDoTopico dados) {
        findTopicoById(id);
        var topico = topicoRepository.getReferenceById(id);
        topico.atualizarInformacoes(dados);

        return new DadosDetalhamentoDoTopico(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(),
                topico.getDuvidaResolvida(), new DadosDoAutor(topico.getAutor()), topico.getCurso());

    }

    public DadosDetalhamentoDoTopico detalharTopico(Long id) {
        findTopicoById(id);
        var topico = topicoRepository.getReferenceById(id);
        return new DadosDetalhamentoDoTopico(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(),
                topico.getDuvidaResolvida(), new DadosDoAutor(topico.getAutor()), topico.getCurso());
    }

    public Long deletarTopico(Long id) {
        findTopicoById(id);
        topicoRepository.deleteById(id);
        return id;
    }

    public Topico findTopicoById(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Tópico com ID " + id + " não encontrado"));
    }
}