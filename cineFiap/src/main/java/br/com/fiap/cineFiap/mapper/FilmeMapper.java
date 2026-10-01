package br.com.fiap.cineFiap.mapper;

import br.com.fiap.cineFiap.dto.FilmeResponseDTO;
import br.com.fiap.cineFiap.dto.FilmeResquestDTO;
import br.com.fiap.cineFiap.models.Filme;

import java.util.List;

public class FilmeMapper {

    public static Filme toEntity(FilmeResquestDTO dto) {
        Filme filme = new Filme();
        filme.setNome(dto.getNome());
        filme.setDuracao(dto.getDuracao());
        filme.setAno(dto.getAno());
        filme.setCapa(dto.getCapa());
        filme.setDiretor(dto.getDiretor());
        filme.setElenco(dto.getElenco());
        filme.setDescricao(dto.getDescricao());
        filme.setAvaliacao(dto.getAvaliacao());
        filme.setCategoria(dto.getCategoria());
        filme.setClassificacao(dto.getClassificacao());
        filme.setEmCartaz(dto.getEmCartaz());
        return filme;
    }

    public static FilmeResponseDTO toDTO(Filme filme) {
        FilmeResponseDTO dto = new FilmeResponseDTO();
        dto.setId(filme.getId());
        dto.setNome(filme.getNome());
        dto.setDuracao(filme.getDuracao());
        dto.setAno(filme.getAno());
        dto.setCapa(filme.getCapa());
        dto.setDiretor(filme.getDiretor());
        dto.setElenco(filme.getElenco());
        dto.setDescricao(filme.getDescricao());
        dto.setAvaliacao(filme.getAvaliacao());
        dto.setCategoria(filme.getCategoria());
        dto.setClassificacao(filme.getClassificacao());
        dto.setEmCartaz(filme.getEmCartaz());
        return dto;
    }

    public static List<FilmeResponseDTO> toDTOList(List<Filme> filmes) {
        return filmes.stream().map(FilmeMapper::toDTO).toList();
    }
}
