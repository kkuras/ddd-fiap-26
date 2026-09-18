package br.com.fiap.cineFiap.service;

import br.com.fiap.cineFiap.dao.FilmeDAO;
import br.com.fiap.cineFiap.enums.CategoriaFilmeEnum;
import br.com.fiap.cineFiap.models.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeDAO filmeDAO;


    public FilmeService() {
        filmeDAO = new FilmeDAO();
    }

    public List<Filme> listar() {
        return filmeDAO.listar();
    }

    public void cadastrar(Filme filme) {
        if (filme.getNome() != null)
            filmeDAO.cadastrar(filme);
        else
            throw new RuntimeException("Filme nao cadastrado completamente");
    }

    public void excluir(int id) {
        Filme filmeexiste = filmeDAO.buscarPorId(id);
        if (filmeexiste == null)
            throw new IllegalArgumentException("Contato não encontrado");

        filmeDAO.deletar(id);
    }

    public void atualizar(int id, Filme filme) {
        if(id != filme.getId())
            throw new IllegalArgumentException("O código do contato não corresponde ao código informado");

        Filme contatoExiste = filmeDAO.buscarPorId(id);
        if (contatoExiste == null)
            throw new IllegalArgumentException("Contato não encontrado");
    }

    public Filme buscarPorId(int id) {
        var filme = filmeDAO.buscarPorId(id);
        return filme;
    }

    public List<Filme> buscarPorCategoria(CategoriaFilmeEnum categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria inválida");
        }
        return filmeDAO.buscarPorCategoria(categoria);
    }
}
