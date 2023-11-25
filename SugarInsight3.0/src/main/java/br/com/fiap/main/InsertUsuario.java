package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.DadosUsuario;
import br.com.fiap.dao.DadosUsuarioDAO;

public class InsertUsuario {

	static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DadosUsuario usuario = new DadosUsuario();
		DadosUsuarioDAO dao = new DadosUsuarioDAO();
		
		usuario.setId_usuario(inteiro("ID usuário: "));
		usuario.setCpf(texto("CPF: "));
		usuario.setSexo(texto("Sexo: "));
		usuario.setPeso(real("Peso: "));
		usuario.setAltura(real("Altura: "));
		usuario.setIdade(inteiro("Idade: "));
		usuario.setResultadoPredicao(texto("Resultado Teste RDM: "));
		
		dao.cadastrarDadosUsuario(usuario);
		
	}

}
