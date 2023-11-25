package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DadosUsuario {
	
	private int id_usuario;
	private String cpf;
	private String sexo;
	private double peso;
	private double altura;
	private int idade;
	private String resultadoPredicao;
	
	public DadosUsuario() {
		super();
	}

	public DadosUsuario(int id_usuario, String cpf, String sexo, double peso, double altura, int idade,
			String resultadoPredicao) {
		super();
		this.id_usuario = id_usuario;
		this.cpf = cpf;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
		this.resultadoPredicao = resultadoPredicao;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getResultadoPredicao() {
		return resultadoPredicao;
	}

	public void setResultadoPredicao(String resultadoPredicao) {
		this.resultadoPredicao = resultadoPredicao;
	}

	
	
}