package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.fiap.beans.DadosUsuario;
import br.com.fiap.dao.DadosUsuarioDAO;
@XmlRootElement
public class DadosUsuarioBo {

    private DadosUsuarioDAO dadosUsuarioDAO;

    public DadosUsuarioBo() {
        try {
            this.dadosUsuarioDAO = new DadosUsuarioDAO();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public DadosUsuario obterDadosUsuario(int idUsuario) {
        try {
            List<DadosUsuario> listaDadosUsuario = dadosUsuarioDAO.selecionar(idUsuario);
            if (listaDadosUsuario != null && !listaDadosUsuario.isEmpty()) {
                
                return listaDadosUsuario.get(0);
            } else {
                return null; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
