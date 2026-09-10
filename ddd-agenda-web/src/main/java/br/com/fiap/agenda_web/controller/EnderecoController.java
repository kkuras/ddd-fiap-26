package br.com.fiap.agenda_web.controller;

import br.com.fiap.agenda_web.dao.EnderecoDAO;
import br.com.fiap.agenda_web.models.Endereco;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {


    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    public List<Endereco> listar() {
        return enderecoDAO.buscarTodosEnderecos();
    }

    @GetMapping("/")
    public Endereco buscarporId(int id) {
        var endereco = enderecoDAO.buscarPorId(id);
        return endereco;
    }

    @PostMapping
    public void cadastrar(@RequestBody Endereco endereco) {
        enderecoDAO.inserir(endereco);
    }






}
