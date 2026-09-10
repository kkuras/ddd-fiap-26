package fiap.com.br.agendaweb.controller;

import fiap.com.br.agendaweb.models.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ContatoController {
    /*
    @GetMapping
    public String mensagem() {
        return "la ele";
    }
    */

    public Aluno exibirAluno(@PathVariable int id) {
        Aluno aluno = new Aluno("flavio", 1);
        return aluno;
    }

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return aluno;
    }

    @PutMapping("/{id}")
    public Aluno alterar(@RequestBody Aluno aluno,
                         @PathVariable int id){
        Aluno a = new Aluno("Maria", id);
        a.setNome(aluno.getNome());
        return a;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) {
        System.out.println("excluido");
    }

    List<Aluno> alunos = List.of(new Aluno("ana", 1),
            new Aluno("eliane", 2),
            new Aluno("maria", 3));

    @GetMapping
    public List<Aluno> listar() {
        return alunos;
    }


}
