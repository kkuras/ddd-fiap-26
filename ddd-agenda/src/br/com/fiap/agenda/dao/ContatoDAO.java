package br.com.fiap.agenda.dao;


import br.com.fiap.agenda.models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// classe responsavel pelo crud de contato
public class ContatoDAO {
    private Connection conexao;


    // CRUD -> create
    public void cadastrar(Contato contato) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "insert into tbl_contato (ID_CONTATO, NOME_CONTATO, CELULAR_CONTATO, " +
                    "EMAIL_CONTATO, INSTAGRAM, TIPO)" +
                    "values(?, ?, ?, ?, ?, ?)";

            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, contato.getId());
            comandoSQL.setString(2, contato.getNome());
            comandoSQL.setString(3, contato.getCelular());
            comandoSQL.setString(4, contato.getEmail());
            comandoSQL.setString(5, contato.getInstagram());
            comandoSQL.setString(6, contato.getTipo());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // crud -> read
    public Contato buscarID(int id) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement ps = null;
        Contato contato = new Contato();

        try {
            ps = conexao.prepareStatement("select * from TBL_CONTATO where id_contato = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                contato.setId(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setCelular(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setInstagram(rs.getString(5));
                contato.setTipo(rs.getString(6));
            }
            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contato;

    }

    public List<Contato> listar() {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement ps = null;
        List<Contato> contatos = new ArrayList<>();
        try {
            ps = conexao.prepareStatement("select * from TBL_CONTATO");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Contato c = new Contato();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setCelular(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setInstagram(rs.getString(5));
                c.setTipo(rs.getString(6));
                contatos.add(c);
            }
            ps.close();
            conexao.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contatos;
    }


    public void alterar(Contato contato) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement ps = null;
        try{
            String sql = "UPDATE TBL_CONTATO SET NOME_CONTATO = ?, " +
                    "CELULAR_CONTATO = ?, EMAIL_CONTATO = ?, " +
                    "INSTAGRAM = ?, TIPO = ? WHERE ID_CONTATO = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getCelular());
            ps.setString(3, contato.getEmail());
            ps.setString(4, contato.getInstagram());
            ps.setString(5, contato.getTipo());
            ps.setInt(6, contato.getId());
            ps.executeUpdate();
            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(int id) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement(
                    "DELETE FROM TBL_CONTATO WHERE ID_CONTATO = ?");

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conexao.close();


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
