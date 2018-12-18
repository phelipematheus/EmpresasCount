package br.com.empresasCount.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "FUNCIONARIO")
public class Funcionario {

	@Column()
	String CPF;
	@Column()
	String nome;
	@Column()
	String eMail;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

}
