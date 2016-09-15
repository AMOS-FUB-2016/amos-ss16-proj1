package de.fuberlin.chaostesting.ioc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.inject.Inject;

import de.fuberlin.chaostesting.model.DataAccessException;

public class TransactionManager {

	EntityManagerFactory entityManagerFactory;

	private final static ThreadLocal<EntityManager> threadLocalEntityManager = new ThreadLocal<>();
	
	@Inject
	public TransactionManager(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	public EntityManager getEntityManager() {
		EntityManager entityManager = threadLocalEntityManager.get();

		if(entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
			threadLocalEntityManager.set(entityManager);
		}

		return entityManager;
	}

	public void closeEntityManager() {
		EntityManager entityManager = threadLocalEntityManager.get();
		if(entityManager != null) {
			entityManager.close();
			threadLocalEntityManager.set(null);
		}
	}

	public void beginTransaction() {
		try {
			getEntityManager().getTransaction().begin();
		} catch(RuntimeException e) {
			throw new DataAccessException("error starting transaction", e);
		}
	}

	public void rollback() {
		try {
			getEntityManager().getTransaction().rollback();
		} catch(RuntimeException e) {
			throw new DataAccessException("error rolling back transaction", e);
		}
	}

	public void commit() {
		try {
			getEntityManager().getTransaction().commit();
		} catch(RuntimeException e) {
			throw new DataAccessException("error comitting transaction", e);
		}
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void closeEntityManagerFactory() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
			entityManagerFactory = null;
		}
	}
}
