package br.com.fiap.agenda_web.service;

import br.com.fiap.agenda_web.dao.EnderecoDAO;
import br.com.fiap.agenda_web.models.Endereco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoDAO enderecoDAO;
    private final ViaCepService viaCepService;

    public EnderecoService(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
        enderecoDAO = new EnderecoDAO();
    }

    public List<Endereco> listar(){
        return enderecoDAO.buscarTodosEnderecos();
    }

    public Endereco buscarPorId(int id){
        var endereco = enderecoDAO.buscarPorId(id);
        return endereco;
    }

    public Endereco buscarPorCep(String cep){
        var enderecoDTO = viaCepService.consultarCep(cep);
        var endereco = new Endereco();
        endereco.setCep(enderecoDTO.cep());
        endereco.setUf(enderecoDTO.uf());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setRua(enderecoDTO.logradouro());
        endereco.setCidade(enderecoDTO.localidade());
        endereco.setEstado(enderecoDTO.estado());
        return endereco;
    }

    public void cadastrar( Endereco endereco){
        if(endereco.getCep() != null )
            enderecoDAO.inserir(endereco);
        else
            throw new RuntimeException("Endereço incompleto");
    }

    public void atualizar( int id, Endereco endereco){
        if(id != endereco.getCodigo())
            throw new IllegalArgumentException("O código do endereço não corresponde ao código informado");

        Endereco enderecoExiste = buscarPorId(id);
        if(enderecoExiste == null)
            throw new IllegalArgumentException("Endereço não encontrado");

        enderecoDAO.alterar(endereco);
    }

    public void excluir(int id){
        Endereco enderecoExiste = buscarPorId(id);
        if(enderecoExiste == null)
            throw new IllegalArgumentException("Endereço não encontrado");

        enderecoDAO.excluir(id);
    }

}