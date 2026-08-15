package br.com.fiap.agenda.dao;


import br.com.fiap.agenda.models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// classe responsavel pelo crud de contato
public class ContatoDAO {
    private Connection conexao;

    public void cadastrar(Contato contato) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "insert into tbl_contato (ID_CONTATO, NOME_CONTATO, CELULAR_CONTATO, EMAIL_CONTATO, INSTAGRAM, TIPO)" +
                    "values(?, ?, ?, ?, ?, ?)";

            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, contato.getId());
            comandoSQL.setString(2, contato.getNome());
            comandoSQL.setString(3, contato.getCelular());
            comandoSQL.setString(4, contato.getEmail());
            comandoSQL.setString(5, contato.getInstagram());
            comandoSQL.setString(6, contato.getTipo());

            comandoSQL.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
