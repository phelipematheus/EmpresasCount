package br.com.empresasCount.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "EMPRESA")
public class Empresa {

	@Column()
	String CNPJ;
	@Column()
	String nome;
	@Column()
	Funcionario filiado;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getFiliado() {
		return filiado;
	}

	public void setFiliado(Funcionario filiado) {
		this.filiado = filiado;
	}

}
