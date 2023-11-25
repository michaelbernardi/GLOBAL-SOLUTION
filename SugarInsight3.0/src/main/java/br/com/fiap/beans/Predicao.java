package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Predicao {

    private String sexo;
    private int idade;
    private String hipertensao;
    private String fumante; 
    private String atividadeFisica;
    private String imc; 
 
    
	public Predicao() {
		super();
	}

	public Predicao(String sexo, int idade, String hipertensao, String fumante, String atividadeFisica, String imc) {
		super();
		this.sexo = sexo;
		this.idade = idade;
		this.hipertensao = hipertensao;
		this.fumante = fumante;
		this.atividadeFisica = atividadeFisica;
		this.imc = imc;
		
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(String hipertensao) {
		this.hipertensao = hipertensao;
	}

	public String getFumante() {
		return fumante;
	}

	public void setFumante(String fumante) {
		this.fumante = fumante;
	}
	
	public String getAtividadeFisica() {
		return atividadeFisica;
	}

	public void setAtividadeFisica(String atividadeFisica) {
		this.atividadeFisica = atividadeFisica;
	}
	
	public String getImc() {
		return imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}



	


}
