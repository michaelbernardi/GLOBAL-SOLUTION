package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Predicao;
import br.com.fiap.dao.PredicaoDAO;

public class InsertPredicao {

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

        Predicao variaveis = new Predicao();
        PredicaoDAO dao = new PredicaoDAO();

        variaveis.setSexo(texto("SEXO: "));
        variaveis.setIdade(inteiro("IDADE: "));
        variaveis.setHipertensao(texto("HIPERTENSÃO: "));
        variaveis.setFumante(texto("FUMANTE: "));
        variaveis.setImc(texto("IMC: "));
        variaveis.setAtividadeFisica(texto("ATIVIDADE FISICA: "));

        // Inserindo a predição no banco de dados
        dao.inserir(variaveis);

        // Imprimindo uma mensagem após a inserção
        System.out.println("Predição inserida no banco de dados.");
    }
}

