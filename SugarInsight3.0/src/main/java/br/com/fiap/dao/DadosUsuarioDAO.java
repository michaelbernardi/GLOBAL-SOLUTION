package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.DadosUsuario;
import br.com.fiap.conections.ConexaoFactory;

public class DadosUsuarioDAO {

    public Connection minhaConexao;

    public DadosUsuarioDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public void cadastrarDadosUsuario(DadosUsuario dadosUsuario) throws SQLException {
        String query = "INSERT INTO T_SI_DADOS_USUARIO (id_usuario, id_cpf, ds_sexo, nr_peso, nr_altura, nr_idade, ds_resultado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = minhaConexao.prepareStatement(query)) {
            stmt.setInt(1, dadosUsuario.getId_usuario());
            stmt.setString(2, dadosUsuario.getCpf());
            stmt.setString(3, dadosUsuario.getSexo());
            stmt.setDouble(4, dadosUsuario.getPeso());
            stmt.setDouble(5, dadosUsuario.getAltura());
            stmt.setInt(6, dadosUsuario.getIdade());
            stmt.setString(7, dadosUsuario.getResultadoPredicao());

            stmt.executeUpdate();
            stmt.close();
        }
    }
    
    
 // Select 
    public List<DadosUsuario> selecionar(int id_usuario) throws SQLException {
        List<DadosUsuario> listaDadosUsuario = new ArrayList<>();

        try (PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_SI_DADOS_USUARIO WHERE ID_USUARIO = ?")) {
            stmt.setInt(1, id_usuario);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    DadosUsuario dados = new DadosUsuario();
                    dados.setId_usuario(rs.getInt(1));
                    dados.setCpf(rs.getString(2));
                    dados.setSexo(rs.getString(3));
                    dados.setPeso(rs.getDouble(4));
                    dados.setAltura(rs.getDouble(5));
                    dados.setIdade(rs.getInt(6));
                    dados.setResultadoPredicao(rs.getString(7));
                    listaDadosUsuario.add(dados);
                }
            }
        }

        return listaDadosUsuario;
    }
    
    public DadosUsuario obterDadosUsuario(String cpf) throws SQLException {
        String query = "SELECT * FROM T_SI_DADOS_USUARIO WHERE cpf = ?";
        try (PreparedStatement stmt = minhaConexao.prepareStatement(query)) {
            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    DadosUsuario dados = new DadosUsuario();
                    dados.setId_usuario(rs.getInt(1));
                    dados.setCpf(rs.getString(2));
                    dados.setSexo(rs.getString(3));
                    dados.setPeso(rs.getDouble(4));
                    dados.setAltura(rs.getDouble(5));
                    dados.setIdade(rs.getInt(6));
                    dados.setResultadoPredicao(rs.getString(7));
                    return dados;
                } else {
                    return null; // Usuário não encontrado
                }
            }
        }
    }
}
