package br.com.empresasCount.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOConfig {

	final String url = "jdbc:mysql://127.0.0.1/contador";
	final String user = "root";
	final String passw = "root";
	
	private static DAOConfig instance;
	protected EntityManager entityManager;
	
	protected DAOConfig() {
		entityManager = getEntityManager() ;
	}
	
	public static DAOConfig getInstance() {
		if(instance == null) {
			instance = new DAOConfig();
		}
		return instance;
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("empresasCount.model");
		if (entityManager == null) {
				entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
}
