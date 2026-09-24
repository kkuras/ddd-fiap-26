package br.com.fiap.cineFiap.service;

import br.com.fiap.cineFiap.dao.FilmeDAO;
import br.com.fiap.cineFiap.exceptions.FilmeNaoEncontradoException;
import br.com.fiap.cineFiap.models.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeDAO filmeDAO;

    public FilmeService() {
        this.filmeDAO = new FilmeDAO();
    }

    public void cadastrar(Filme filme){
        if (filme == null)
            throw new IllegalArgumentException("Filme não pode ser nulo");

        filmeDAO.cadastrar(filme);
    }

    public List<Filme> buscarPorCategoria(String categoria){
        if (categoria == null || categoria.isBlank())
            throw new IllegalArgumentException("Categoria não pode ser vazia");

        var filmes = filmeDAO.buscarPorCategoria(categoria);

        if (filmes.isEmpty())
            throw new FilmeNaoEncontradoException("Nenhum filme encontrado para a categoria: " + categoria);

        return filmes;
    }

    public List<Filme> buscarEmCartaz(){
        var filmes = filmeDAO.buscarEmCartaz();

        if (filmes.isEmpty())
            throw new FilmeNaoEncontradoException("Nenhum filme em cartaz no momento");

        return filmes;
    }

    public List<Filme> buscarPorNome(String nome){
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser vazio");

        var filmes = filmeDAO.buscarPorNome(nome);

        if (filmes.isEmpty())
            throw new FilmeNaoEncontradoException("Nenhum filme encontrado com o nome: " + nome);

        return filmes;
    }

    public List<Filme> buscarPorAno(int ano){
        if (ano <= 0)
            throw new IllegalArgumentException("Ano inválido");

        var filmes = filmeDAO.buscarPorAno(ano);

        if (filmes.isEmpty())
            throw new FilmeNaoEncontradoException("Nenhum filme encontrado para o ano: " + ano);

        return filmes;
    }

    public Filme buscarPorId(Integer id){
        if (id == null)
            throw new IllegalArgumentException("Id não pode ser nulo");

        var filme = filmeDAO.buscarPorId(id);

        if (filme.getId() == 0)
            throw new FilmeNaoEncontradoException("Filme não encontrado");

        return filme;
    }

    public void alterar(Filme filme){
        if (filme == null)
            throw new IllegalArgumentException("Filme não pode ser nulo");
        if (filme.getId() == 0)
            throw new IllegalArgumentException("Id do filme deve ser informado");

        buscarPorId(filme.getId());

        filmeDAO.alterar(filme);
    }

    public void excluir(Integer id){
        if (id == null)
            throw new IllegalArgumentException("Id não pode ser nulo");

        buscarPorId(id);

        filmeDAO.excluir(id);
    }



}
