package br.com.fiap.cineFiap.dao;

import br.com.fiap.cineFiap.enums.CategoriaFilmeEnum;
import br.com.fiap.cineFiap.enums.ClassificacaoIndicativaEnum;
import br.com.fiap.cineFiap.enums.SimNaoEnum;
import br.com.fiap.cineFiap.models.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    private Connection conexao;

    public void cadastrar(Filme filme) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "INSERT INTO tbl_filmes (ID_FILME, TX_NOME, NR_DURACAO, TP_CATEGORIA, TP_CLASSIFICACAO, " +
                    "NR_ANO, TX_CAPA, TX_DIRETOR, TX_ELENCO, TX_DESCRICAO, NR_AVALIACAO, CHK_EM_CARTAZ) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, filme.getId());
            comandoSQL.setString(2, filme.getNome());
            comandoSQL.setInt(3, filme.getDuracao());
            comandoSQL.setString(4, String.valueOf(filme.getCategoria()));
            comandoSQL.setString(5, String.valueOf(filme.getClassificacao()));
            comandoSQL.setInt(6, filme.getAno());
            comandoSQL.setString(7, filme.getCapa());
            comandoSQL.setString(8, filme.getDiretor());
            comandoSQL.setString(9, filme.getElenco());
            comandoSQL.setString(10, filme.getDescricao());
            comandoSQL.setDouble(11, filme.getAvaliacao());
            comandoSQL.setString(12, String.valueOf(filme.getEmCartaz()));

            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Filme> buscarPorCategoria(CategoriaFilmeEnum categoria) {
        List<Filme> listaFilmes = new ArrayList<>();
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_filmes WHERE TP_CATEGORIA = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, String.valueOf(categoria));

            rs = comandoSQL.executeQuery();

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("ID_FILME"));
                filme.setNome(rs.getString("TX_NOME"));
                filme.setDuracao(rs.getInt("NR_DURACAO"));
                filme.setAno(rs.getInt("NR_ANO"));
                filme.setCapa(rs.getString("TX_CAPA"));
                filme.setDiretor(rs.getString("TX_DIRETOR"));
                filme.setElenco(rs.getString("TX_ELENCO"));
                filme.setDescricao(rs.getString("TX_DESCRICAO"));
                filme.setAvaliacao(rs.getDouble("NR_AVALIACAO"));

                if (rs.getString("TP_CATEGORIA") != null) {
                    filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString("TP_CATEGORIA")));
                }
                if (rs.getString("TP_CLASSIFICACAO") != null) {
                    filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString("TP_CLASSIFICACAO")));
                }
                if (rs.getString("CHK_EM_CARTAZ") != null) {
                    filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString("CHK_EM_CARTAZ")));
                }

                listaFilmes.add(filme);
            }

            rs.close();
            comandoSQL.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaFilmes;
    }

    public Filme buscarPorId(int id) {
        Filme filme = null;
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_filmes WHERE ID_FILME = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, id);

            rs = comandoSQL.executeQuery();

            if (rs.next()) {
                filme = new Filme();
                filme.setId(rs.getInt("ID_FILME"));
                filme.setNome(rs.getString("TX_NOME"));
                filme.setDuracao(rs.getInt("NR_DURACAO"));
                filme.setAno(rs.getInt("NR_ANO"));
                filme.setCapa(rs.getString("TX_CAPA"));
                filme.setDiretor(rs.getString("TX_DIRETOR"));
                filme.setElenco(rs.getString("TX_ELENCO"));
                filme.setDescricao(rs.getString("TX_DESCRICAO"));
                filme.setAvaliacao(rs.getDouble("NR_AVALIACAO"));

                if (rs.getString("TP_CATEGORIA") != null) {
                    filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString("TP_CATEGORIA")));
                }
                if (rs.getString("TP_CLASSIFICACAO") != null) {
                    filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString("TP_CLASSIFICACAO")));
                }
                if (rs.getString("CHK_EM_CARTAZ") != null) {
                    filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString("CHK_EM_CARTAZ")));
                }
            }

            rs.close();
            comandoSQL.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filme;
    }

    public List<Filme> listar() {
        List<Filme> listaFilmes = new ArrayList<>();
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM tbl_filmes";
            comandoSQL = conexao.prepareStatement(sql);
            rs = comandoSQL.executeQuery();

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("ID_FILME"));
                filme.setNome(rs.getString("TX_NOME"));
                filme.setDuracao(rs.getInt("NR_DURACAO"));
                filme.setAno(rs.getInt("NR_ANO"));
                filme.setCapa(rs.getString("TX_CAPA"));
                filme.setDiretor(rs.getString("TX_DIRETOR"));
                filme.setElenco(rs.getString("TX_ELENCO"));
                filme.setDescricao(rs.getString("TX_DESCRICAO"));
                filme.setAvaliacao(rs.getDouble("NR_AVALIACAO"));

                if (rs.getString("TP_CATEGORIA") != null) {
                    filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString("TP_CATEGORIA")));
                }
                if (rs.getString("TP_CLASSIFICACAO") != null) {
                    filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString("TP_CLASSIFICACAO")));
                }
                if (rs.getString("CHK_EM_CARTAZ") != null) {
                    filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString("CHK_EM_CARTAZ")));
                }

                listaFilmes.add(filme);
            }

            rs.close();
            comandoSQL.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaFilmes;
    }

    public void atualizar(Filme filme) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;

        try {
            String sql = "UPDATE tbl_filmes SET TX_NOME = ?, NR_DURACAO = ?, TP_CATEGORIA = ?, " +
                    "TP_CLASSIFICACAO = ?, NR_ANO = ?, TX_CAPA = ?, TX_DIRETOR = ?, TX_ELENCO = ?, " +
                    "TX_DESCRICAO = ?, NR_AVALIACAO = ?, CHK_EM_CARTAZ = ? WHERE ID_FILME = ?";

            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, filme.getNome());
            comandoSQL.setInt(2, filme.getDuracao());
            comandoSQL.setString(3, String.valueOf(filme.getCategoria()));
            comandoSQL.setString(4, String.valueOf(filme.getClassificacao()));
            comandoSQL.setInt(5, filme.getAno());
            comandoSQL.setString(6, filme.getCapa());
            comandoSQL.setString(7, filme.getDiretor());
            comandoSQL.setString(8, filme.getElenco());
            comandoSQL.setString(9, filme.getDescricao());
            comandoSQL.setDouble(10, filme.getAvaliacao());
            comandoSQL.setString(11, String.valueOf(filme.getEmCartaz()));
            comandoSQL.setLong(12, filme.getId());

            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        conexao = ConnectionFactory.obterconexao();
        PreparedStatement comandoSQL = null;

        try {
            String sql = "DELETE FROM tbl_filmes WHERE ID_FILME = ?";

            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setLong(1, id);

            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
