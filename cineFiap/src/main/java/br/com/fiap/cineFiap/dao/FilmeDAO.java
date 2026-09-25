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

    public void cadastrar(Filme filme){

        if (filme.getDuracao() <= 0){
            System.out.println("ERRO: A duração deve ser maior que zero.");
            return;
        }
        if (filme.getClassificacao() == null ) {
            System.out.println("ERRO: A classificação indicativa é obrigatória");
            return;
        }
        if (filme.getCategoria() == null ) {
            System.out.println("ERRO: A categoria é obrigatória");
            return;
        }

        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        try{
            String sql = "insert into tbl_filme (ID_FILME, TX_NOME, NR_DURACAO," +
                    "TP_CATEGORIA, TP_CLASSIFICACAO," +
                    "NR_ANO, TX_CAPA, TX_DIRETOR," +
                    "TX_ELENCO, TX_DESCRICAO, NR_AVALIACAO, CHK_EM_CARTAZ)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?)";

            comandoSql = conexao.prepareStatement(sql);

            comandoSql.setInt(1, filme.getId());
            comandoSql.setString(2, filme.getNome());
            comandoSql.setInt(3, filme.getDuracao());
            comandoSql.setString(4, filme.getCategoria().toString());
            comandoSql.setString(5, filme.getClassificacao().toString());
            comandoSql.setInt(6, filme.getAno());
            comandoSql.setString(7, filme.getCapa());
            comandoSql.setString(8, filme.getDiretor());
            comandoSql.setString(9, filme.getElenco());
            comandoSql.setString(10, filme.getDescricao());
            comandoSql.setDouble(11, filme.getAvaliacao());
            comandoSql.setString(12, filme.getEmCartaz().toString());

            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Filme> buscarPorCategoria(String categoria) {
        conexao = ConnectionFactory.obterConexao();;
        PreparedStatement ps = null;
        List<Filme> filmes = new ArrayList<>();

        try{
            ps = conexao.prepareStatement("select * from TBL_FILME where TP_CATEGORIA = ?");
            ps.setString(1, categoria);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Filme filme = new Filme();

                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));

                filmes.add(filme);

            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }


    public List<Filme> buscarEmCartaz(){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        List<Filme> filmes = new ArrayList<>();

        try {
            ps = conexao.prepareStatement("select * from TBL_FILME where CHK_EM_CARTAZ = ?");
            ps.setString(1, "SIM");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Filme filme = new Filme();

                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));

                filmes.add(filme);
            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }

    public List<Filme> buscarPorNome(String nome) {

        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        List<Filme> filmes = new ArrayList<>();

        try{
            ps = conexao.prepareStatement("select * from TBL_FILME where TX_NOME = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Filme filme = new Filme();

                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));

                filmes.add(filme);
            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }


    public List<Filme> buscarPorAno(int ano) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;
        List<Filme> filmes = new ArrayList<>();

        try{
            ps = conexao.prepareStatement("select * from TBL_FILME where NR_ANO = ?");
            ps.setInt(1, ano);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Filme filme = new Filme();

                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));

                filmes.add(filme);
            }

            ps.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }

    public Filme buscarPorId(int id) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement ps = null;

        Filme filme = new Filme();
        try {
            String sql = "SELECT * FROM tbl_filme WHERE ID_FILME = ?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                filme.setId(rs.getInt(1));
                filme.setNome(rs.getString(2));
                filme.setDuracao(rs.getInt(3));
                filme.setCategoria(CategoriaFilmeEnum.valueOf(rs.getString(4)));
                filme.setClassificacao(ClassificacaoIndicativaEnum.valueOf(rs.getString(5)));
                filme.setAno(rs.getInt(6));
                filme.setCapa(rs.getString(7));
                filme.setDiretor(rs.getString(8));
                filme.setElenco(rs.getString(9));
                filme.setDescricao(rs.getString(10));
                filme.setAvaliacao(rs.getDouble(11));
                filme.setEmCartaz(SimNaoEnum.valueOf(rs.getString(12)));
            }
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filme;
    }

    public void alterar(Filme filme)  {
        conexao = ConnectionFactory.obterConexao(); PreparedStatement comandoSql = null; try { String sql = "UPDATE tbl_filme SET TX_NOME = ?, NR_DURACAO = ?, TP_CATEGORIA = ?, " +
                "TX_DIRETOR = ?, TX_DESCRICAO = ?, NR_AVALIACAO = ?, CHK_EM_CARTAZ = ? WHERE ID_FILME = ?";

            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, filme.getNome());
            comandoSql.setInt(2, filme.getDuracao());
            comandoSql.setString(3, filme.getCategoria().toString());
            comandoSql.setString(4, filme.getDiretor());
            comandoSql.setString(5, filme.getDescricao());
            comandoSql.setDouble(6, filme.getAvaliacao());
            comandoSql.setString(7, filme.getEmCartaz().toString());
            comandoSql.setInt(8, filme.getId());
            comandoSql.executeUpdate(); comandoSql.close();
            conexao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Integer id) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try {
            String sql = "DELETE FROM tbl_filme WHERE ID_FILME = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, id);
            comandoSql.executeUpdate();
            comandoSql.close(); conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
