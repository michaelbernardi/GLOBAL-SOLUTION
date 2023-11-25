package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Login;
import br.com.fiap.dao.LoginDAO;

public class InsertLogin {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Login login = new Login();
        LoginDAO dao = new LoginDAO();

        login.setCpf(texto("CPF: "));
        login.setSenha(texto("Senha: "));

        dao.cadastrarLogin(login);

    }
}