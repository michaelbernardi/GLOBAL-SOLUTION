package br.com.fiap.bo;

import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.fiap.beans.Predicao;
import br.com.fiap.dao.PredicaoDAO;

@XmlRootElement
public class PredicaoBo {
    public void inserirBo(Predicao variaveis) throws ClassNotFoundException, SQLException {
        try {
            PredicaoDAO variaveisDAO = new PredicaoDAO();
            variaveisDAO.inserir(variaveis);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao inserir a predição.", e);
        }
    }
}