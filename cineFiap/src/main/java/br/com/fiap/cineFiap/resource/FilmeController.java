package br.com.fiap.cineFiap.resource;

import br.com.fiap.cineFiap.dto.FilmeResponseDTO;
import br.com.fiap.cineFiap.dto.FilmeResquestDTO;
import br.com.fiap.cineFiap.mapper.FilmeMapper;
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
    public ResponseEntity<FilmeResponseDTO> buscarPorId(@PathVariable Integer id) {
        var filme = service.buscarPorId(id);
        if (filme != null)
            return ResponseEntity.ok(FilmeMapper.toDTO(filme));
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/em-cartaz")
    public ResponseEntity<List<FilmeResponseDTO>> filmesEmCartaz() {
        return ResponseEntity.ok(FilmeMapper.toDTOList(service.filmesEmCartaz()));
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponseDTO>> listar() {
        return ResponseEntity.ok(FilmeMapper.toDTOList(service.listarTodos()));
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody FilmeResquestDTO dto) {
        try {
            service.cadastrar(FilmeMapper.toEntity(dto));
            return ResponseEntity.status(HttpStatus.CREATED).body("Filme cadastrado com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar: " + e.getMessage());
        }
    }





}