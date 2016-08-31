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
		entityManager.persist(entity);

		return PersistenceUtils.getEntityPrimaryKey(entity);		
	}

	/**
	 * Updates an entity or creates it if necessary.
	 * @param entity the entity with state to be saved
	 */
	public void createOrUpdate(T entity) {
		entityManager.merge(entity);
	}

	/**
	 * Deletes an existing entity
	 * @param entity the entity with state to be deleted
	 */
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	/**
	 * Finds all entities managed by this DAO.
	 * @return A list of all found results.
	 */
	public List<T> findAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(type);
        Root<T> rootEntry = cq.from(type);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

	/**
	 * Finds an entity matching the given primary key.
	 * @param id The primary key to be matched.
	 * @return An entity instance or null.
	 */
	public T findById(Object id) {
		return entityManager.find(type, id);
	}
	
}
