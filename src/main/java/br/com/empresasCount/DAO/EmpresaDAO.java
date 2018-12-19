package br.com.empresasCount.DAO;

import java.util.List;

import br.com.empresasCount.model.Empresa;

public class EmpresaDAO extends DAOConfig {

	private EmpresaDAO() {
		super();
	}

	public Empresa getById(final String CNPJ) {
		return entityManager.find(Empresa.class, CNPJ);
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> findAll() {
		return entityManager.createQuery("FROM" + Empresa.class.getName()).getResultList();
	}

	public void persist(Empresa empresa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(empresa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Empresa empresa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(empresa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Empresa empresa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(getById(empresa.getCNPJ()));
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final String CNPJ) {
		try {
			Empresa empresa = getById(CNPJ);
			remove(empresa);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}