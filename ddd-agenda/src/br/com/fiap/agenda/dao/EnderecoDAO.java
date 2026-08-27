package br.com.fiap.agenda.dao;

import br.com.fiap.agenda.models.Contato;
import br.com.fiap.agenda.models.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    private Connection conexao;

    public void inserir(Endereco endereco) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "insert into endereco_agenda (codigo, logradouro, cep, bairro, cidade, estado, uf, " +
                    "numero, complemento)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, endereco.getCodigo());
            comandoSQL.setString(2, endereco.getLogradouro());
            comandoSQL.setString(3, endereco.getCep());
            comandoSQL.setString(4, endereco.getBairro());
            comandoSQL.setString(5, endereco.getCidade());
            comandoSQL.setString(6, endereco.getEstado());
            comandoSQL.setString(7, endereco.getUf());
            comandoSQL.setString(8, endereco.getNumero());
            comandoSQL.setString(9, endereco.getComplemento());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Endereco buscarID(int id) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement ps = null;
        Endereco endereco = new Endereco();

        try {
            ps = conexao.prepareStatement("select * from endereco_agenda where id_contato = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                endereco.setCodigo(rs.getInt(1));
                endereco.setLogradouro(rs.getString(2));
                endereco.setCep(rs.getString(3));
                endereco.setBairro(rs.getString(4));
                endereco.setCidade(rs.getString(5));
                endereco.setEstado(rs.getString(6));
                endereco.setUf(rs.getString(7));
                endereco.setNumero(rs.getString(8));
                endereco.setComplemento(rs.getString(9));
            }
            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return endereco;

    }

    public List<Endereco> listar() {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement ps = null;
        List<Endereco> enderecos = new ArrayList<>();
        try {
            ps = conexao.prepareStatement("select * from endereco_agenda");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Endereco e = new Endereco();
                e.setCodigo(rs.getInt(1));
                e.setLogradouro(rs.getString(2));
                e.setCep(rs.getString(3));
                e.setBairro(rs.getString(4));
                e.setCidade(rs.getString(5));
                e.setEstado(rs.getString(6));
                e.setUf(rs.getString(7));
                e.setNumero(rs.getString(8));
                e.setComplemento(rs.getString(9));
                enderecos.add(e);
            }
            ps.close();
            conexao.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enderecos;
    }


    public void alterar(Endereco endereco) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement ps = null;
        try{
            String sql = "UPDATE endereco_agenda SET logradouro = ?, cep = ?, " +
                    "bairro = ?, cidade = ?, estado = ?, estado = ?, uf = ?, " +
                    "numero = ?, complemento = ? WHERE codigo = ?";
            ps = conexao.prepareStatement(sql);

            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getEstado());
            ps.setString(6, endereco.getUf());
            ps.setString(7, endereco.getNumero());
            ps.setString(8, endereco.getComplemento());
            ps.setInt(9, endereco.getCodigo());
            ps.executeUpdate();
            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(int id) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement(
                    "DELETE FROM endereco_agenda WHERE ID_CONTATO = ?");

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conexao.close();


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
