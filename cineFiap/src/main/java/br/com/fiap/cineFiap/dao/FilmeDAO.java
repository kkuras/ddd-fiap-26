package br.com.fiap.cineFiap.dao;

import br.com.fiap.cineFiap.models.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilmeDAO {
    private Connection conexao;

    public void cadastrar(Filme filme) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "insert into tbl_filmes (ID_FILME, TX_NOME, NR_DURACAO, TP_CATEGORIA, TP_CLASSIFICACAO" +
                    "NR_ANO, TX_CAPA, TX_DIRETOR, TX_ELENCO, TX_DESCRICAO, NR_AVALIACAO, CHK_EM_CARTAZ)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setLong(1, filme.getId());
            comandoSQL.setString(2, filme.getId());
            comandoSQL.setInt(3, filme.getId());
            comandoSQL.setInt(4, filme.getId());
            comandoSQL.setLong(5, filme.getId());
            comandoSQL.setLong(6, filme.getId());
            comandoSQL.setLong(7, filme.getId());
            comandoSQL.setLong(8, filme.getId());
            comandoSQL.setLong(9, filme.getId());
            comandoSQL.setLong(10, filme.getId());
            comandoSQL.setLong(11, filme.getId());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
