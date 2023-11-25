package br.com.fiap.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.conections.ConexaoFactory;

public class TesteConexao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection c = new ConexaoFactory().conexao();
		
		System.out.println("--CONEXAO REALIZADA COM SUCESSO--");
		
		c.close();
	}

}
