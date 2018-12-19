package br.com.empresasCount.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Empresa {

	@Id
	@Column
	String CNPJ;
	@Column
	String nome;
	@Column
	@OneToMany
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
