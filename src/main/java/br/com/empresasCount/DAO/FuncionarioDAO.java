package br.com.empresasCount.DAO;

import java.util.List;

import br.com.empresasCount.model.Funcionario;

public class FuncionarioDAO extends DAOConfig {

	private FuncionarioDAO() {
		super();
	}

	public Funcionario getById(final String CPF) {
		return entityManager.find(Funcionario.class, CPF);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> findAll() {
		return entityManager.createQuery("FROM" + Funcionario.class.getName()).getResultList();
	}

	public void persist(Funcionario funcionario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(funcionario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Funcionario funcionario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(funcionario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Funcionario funcionario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(getById(funcionario.getCPF()));
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final String CPF) {
		try {
			Funcionario funcionario = getById(CPF);
			remove(funcionario);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}