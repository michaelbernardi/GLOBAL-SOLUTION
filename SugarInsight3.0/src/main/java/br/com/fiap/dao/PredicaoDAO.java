package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.beans.Predicao;
import br.com.fiap.conections.ConexaoFactory;

public class PredicaoDAO {

    private Connection minhaConexao;

    public PredicaoDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // INSERT
    public void inserir(Predicao predicao) throws SQLException {
        try (PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_SI_PREDICAO (ds_sexo, nr_idade, ds_hipertensao, ds_fumante, ds_imc, ds_atividadeFisica) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, predicao.getSexo());
            stmt.setInt(2, predicao.getIdade());
            stmt.setString(3, predicao.getHipertensao());
            stmt.setString(4, predicao.getFumante());
            stmt.setString(5, predicao.getImc());
            stmt.setString(6, predicao.getAtividadeFisica());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao inserir a predição no banco de dados", e);
        }
    }
}
