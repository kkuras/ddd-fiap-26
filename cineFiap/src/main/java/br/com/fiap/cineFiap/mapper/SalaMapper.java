package br.com.fiap.cineFiap.mapper;

import br.com.fiap.cineFiap.dto.SalaRequestDTO;
import br.com.fiap.cineFiap.dto.SalaResponseDTO;
import br.com.fiap.cineFiap.models.Sala;

import java.util.List;

public class SalaMapper {

    // Request -> Entity (sem id: ele é definido depois, pelo banco ou pela URL)
    public static Sala toEntity(SalaRequestDTO request) {
        Sala sala = new Sala();
        sala.setNome(request.nome());
        sala.setPreco(request.preco());
        return sala;
    }

    // Entity -> Response (record é imutável: tudo vai direto no construtor)
    public static SalaResponseDTO toDTO(Sala sala) {
        return new SalaResponseDTO(sala.getId(), sala.getNome(), sala.getPreco());
    }

    public static List<SalaResponseDTO> toDTO(List<Sala> salas) {
        return salas.stream().map(SalaMapper::toDTO).toList();
    }
}
