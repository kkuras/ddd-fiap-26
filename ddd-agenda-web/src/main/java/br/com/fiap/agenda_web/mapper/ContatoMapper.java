package br.com.fiap.agenda_web.mapper;

import br.com.fiap.agenda_web.dto.ContatoRequestDTO;
import br.com.fiap.agenda_web.dto.ContatoResponseDTO;
import br.com.fiap.agenda_web.models.Contato;

// vai converter dto e dto ->
public class ContatoMapper {

    public static Contato toEntity (ContatoRequestDTO dto) {
        Contato contato = new Contato();
        contato.setId(dto.id());
        contato.setNome(dto.nome());
        contato.setEmail(dto.email());
        contato.setInstagram(dto.instagram());
        contato.setTipo(dto.tipo());
        contato.setEndereco(dto.endereco());
        return contato;
    }

    public static ContatoResponseDTO toRecordDTO(Contato contato) {
        return new ContatoResponseDTO(
                contato.getId(),
                contato.getNome(),
                contato.getCelular(),
                contato.getEmail(),
                contato.getInstagram(),
                contato.getTipo(),
                contato.getEndereco()
        );
    }

    public static Contato recordToEntity (ContatoRequestDTO dto) {
        Contato contato = new Contato();
        contato.setId(dto.id());
        contato.setNome(dto.nome());
        contato.setCelular(dto.celular());
        contato.setEmail(dto.email());
        contato.setInstagram(dto.instagram());
        contato.setTipo(dto.tipo());
        contato.setEndereco(dto.endereco());
        return contato;
    }
}
