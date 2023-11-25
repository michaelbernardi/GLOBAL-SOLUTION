package br.com.fiap.bo;

import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.fiap.beans.DadosUsuario;
import br.com.fiap.beans.Login;
import br.com.fiap.dao.DadosUsuarioDAO;
import br.com.fiap.dao.LoginDAO;

@XmlRootElement
public class LoginBo {

    private LoginDAO loginDAO;
    private DadosUsuarioDAO dadosUsuarioDAO;

    public LoginBo() {
        try {
            this.loginDAO = new LoginDAO();
            this.dadosUsuarioDAO = new DadosUsuarioDAO();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public DadosUsuario realizarLoginComInformacoes(Login login) {
        try {
            if (loginDAO.validarLogin(login)) {
                // Se o login for bem-sucedido, obtenha as informações do usuário
                return dadosUsuarioDAO.obterDadosUsuario(login.getCpf());
            } else {
                return null; // Login inválido, usuário não encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}