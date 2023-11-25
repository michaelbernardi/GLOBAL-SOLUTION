package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.beans.Login;
import br.com.fiap.conections.ConexaoFactory;

public class LoginDAO {

    public Connection minhaConexao;

    public LoginDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    //validar o login no banco de dados
    public boolean validarLogin(Login login) throws SQLException {
        String sql = "SELECT COUNT(*) FROM T_SI_LOGIN WHERE cpf = ? AND senha = ?";
        try (PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {
            stmt.setString(1, login.getCpf());
            stmt.setString(2, login.getSenha());

            ResultSet rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            return count > 0;

        }
    }
    
    public void cadastrarLogin(Login login) throws SQLException {
        String query = "INSERT INTO T_SI_LOGIN (cpf, senha) VALUES (?, ?)";
        try (PreparedStatement stmt = minhaConexao.prepareStatement(query)) {
            stmt.setString(1, login.getCpf());
            stmt.setString(2, login.getSenha());
            stmt.executeUpdate();
        }
    }
}
