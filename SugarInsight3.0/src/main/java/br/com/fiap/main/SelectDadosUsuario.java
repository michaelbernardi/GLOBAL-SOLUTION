package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.DadosUsuario;
import br.com.fiap.dao.DadosUsuarioDAO;

public class SelectDadosUsuario {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		//Instanciar objetos 
		DadosUsuarioDAO dao = new DadosUsuarioDAO();
		
		List<DadosUsuario> listaDadosUsuario = (ArrayList<DadosUsuario>) dao.selecionar(2);
		
		if(listaDadosUsuario != null) {
			// foreach 
			for( DadosUsuario dados : listaDadosUsuario) {
				System.out.println(dados.getId_usuario() + " " +
									dados.getCpf() + " " +  
						        	dados.getSexo() + " " + 
									dados.getPeso() + " " +
									dados.getAltura() + " "+
									dados.getIdade() + " " +
									dados.getResultadoPredicao() + " ");
			}
		}
		
	}

}
