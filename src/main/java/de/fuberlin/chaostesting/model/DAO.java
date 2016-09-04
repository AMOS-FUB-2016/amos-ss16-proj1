package de.fuberlin.chaostesting.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Simple DAO mechanism for easy access and abstraction from database semantics.
 * 
 * @author danni
 *
 * @param <T> The entity type to be managed by a DAO
 */
public class DAO<T> {
	
	EntityManager entityManager;
	Class<T> type;
	
	
	private DAO(Class<T> type, EntityManager entityManager) {
		this.type = type;
		this.entityManager = entityManager;
	}
	
	public static <T> DAO<T> createInstance(Class<T> type) {
		return new DAO<>(type, PersistenceUtils.getEntityManager());
	}
	
	/**
	 * for subclassing
	 * @return the entity manager configured for this dao
	 */
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	/**
	 * Creates a new entity
	 * @param entity the entity with state to be saved
	 * @return false if creation was unsuccessful, true else
	 */
	public Object create(T entity) {
		try {
			entityManager.persist(entity);
	
			return PersistenceUtils.getEntityPrimaryKey(entity);
		} catch (Exception e) {
			throw new DataAccessException("error creating entity", e);
		}
	}

	/**
	 * Updates an entity or creates it if necessary.
	 * @param entity the entity with state to be saved
	 */
	public void createOrUpdate(T entity) {
		try {
			entityManager.merge(entity);
		} catch(Exception e) {
			throw new DataAccessException("error merging entity", e);
		}
	}

	/**
	 * Deletes an existing entity
	 * @param entity the entity with state to be deleted
	 */
	public void delete(T entity) {
		try {
			entityManager.remove(entity);
		} catch(Exception e) {
			throw new DataAccessException("error deleting entity", e);
		}
	}

	/**
	 * Finds all entities managed by this DAO.
	 * @return A list of all found results.
	 */
	public List<T> findAll() {
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<T> cq = cb.createQuery(type);
	        Root<T> rootEntry = cq.from(type);
	        CriteriaQuery<T> all = cq.select(rootEntry);
	        TypedQuery<T> allQuery = entityManager.createQuery(all);
	        return allQuery.getResultList();
		} catch(Exception e) {
			throw new DataAccessException("error finding all entities", e);
		}
	}

	/**
	 * Finds an entity matching the given primary key.
	 * @param id The primary key to be matched.
	 * @return An entity instance or null.
	 */
	public T findById(Object id) {
		try {
			return entityManager.find(type, id);
		} catch(Exception e) {
			throw new DataAccessException("error finding entity given by id", e);
		}
	}	
}
