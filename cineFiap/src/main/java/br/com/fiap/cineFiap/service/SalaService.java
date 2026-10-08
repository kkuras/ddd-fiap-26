package br.com.fiap.cineFiap.service;

import br.com.fiap.cineFiap.dao.SalaDAO;
import br.com.fiap.cineFiap.dto.SalaRequestDTO;
import br.com.fiap.cineFiap.dto.SalaResponseDTO;
import br.com.fiap.cineFiap.exceptions.SalaNaoEncontradaException;
import br.com.fiap.cineFiap.mapper.SalaMapper;
import br.com.fiap.cineFiap.models.Sala;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaService {

    private final SalaDAO salaDAO;


    public SalaService(SalaDAO salaDAO) {
        this.salaDAO = salaDAO;
    }

    public void cadastrar(SalaRequestDTO request) {
        validar(request);
        salaDAO.cadastrar(SalaMapper.toEntity(request));
    }

    public List<SalaResponseDTO> listar() {
        // O DAO traz todas, inclusive as com exclusão lógica; aqui ficam só as ativas
        var salas = salaDAO.listar().stream()
                .filter(s -> s.getDataExclusao() == null)
                .toList();

        if (salas.isEmpty())
            throw new SalaNaoEncontradaException("Nenhuma sala cadastrada");

        return SalaMapper.toDTO(salas);
    }

    public SalaResponseDTO buscarPorId(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Id não pode ser nulo");

        var sala = salaDAO.buscarPorId(id);

        // Sala vazia devolvida pelo DAO = não encontrou
        if (sala.getId() == null)
            throw new SalaNaoEncontradaException("Sala não encontrada com o id: " + id);

        return SalaMapper.toDTO(sala);
    }

    public SalaResponseDTO alterar(Long id, SalaRequestDTO request) {
        validar(request);
        buscarPorId(id); // lança exceção se não existir

        Sala sala = SalaMapper.toEntity(request);
        sala.setId(id);

        salaDAO.alterar(sala);
        return SalaMapper.toDTO(sala);
    }

    // Exclusão física: apaga a linha do banco
    public void excluir(Long id) {
        buscarPorId(id);
        salaDAO.excluir(id);
    }

    // Exclusão lógica: só marca DT_EXCLUSAO
    public void deletar(Long id) {
        buscarPorId(id);
        salaDAO.deletar(id);
    }

    private void validar(SalaRequestDTO request) {
        if (request == null)
            throw new IllegalArgumentException("Sala não pode ser nula");

        if (request.nome() == null || request.nome().isBlank())
            throw new IllegalArgumentException("Nome é obrigatório");

        if (request.preco() <= 0)
            throw new IllegalArgumentException("Preço deve ser maior que zero");
    }

}
