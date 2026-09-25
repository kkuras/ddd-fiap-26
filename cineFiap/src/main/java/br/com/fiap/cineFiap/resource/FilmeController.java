package br.com.fiap.cineFiap.resource;

import br.com.fiap.cineFiap.models.Filme;
import br.com.fiap.cineFiap.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeService service;

    public FilmeController() {
        this.service = new FilmeService();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Integer id){
        var filme = service.buscarPorId(id);
        if (filme != null)
            return ResponseEntity.ok(filme);
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/em-cartaz")
    public ResponseEntity  <List<Filme>> filmesEmCartaz() {
        return ResponseEntity.ok(service.filmesEmCartaz());
    }

    @PostMapping
    public ResponseEntity <String> cadastrar(@RequestBody Filme filme) {
        try {
            service.cadastrar(filme);
            return ResponseEntity.status(HttpStatus.CREATED).body("cadastro sim");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erro ao cadastrar");
        }

    }

    @GetMapping
    public ResponseEntity <List<Filme>> listar {
        return ResponseEntity.ok(service.listartodos());

    }





}