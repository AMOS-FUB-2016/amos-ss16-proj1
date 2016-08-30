package de.fuberlin.chaostesting.model;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.PersistenceUtil;
import javax.persistence.Table;


/**
 * Simple DAO mechanism for easy access and abstraction from database semantics.
 * 
 * @author danni
 *
 * @param <T> The entity type to be managed by a DAO
 */
public abstract class DAO<T> {
	
	public static <T> DAO<T> createInstance(Class<T> type) {
		return new JPADAO<>(type, PersistenceUtils.getEntityManager());
	}
	
	/**
	 * Creates a new entity
	 * @param entity the entity with state to be saved
	 * @return false if creation was unsuccessful, true else
	 */
	public abstract Object create(T entity);
	
	/**
	 * Updates an entity or creates it if necessary.
	 * @param entity the entity with state to be saved
	 */
	public abstract void createOrUpdate(T entity);
	
	/**
	 * Deletes an existing entity
	 * @param entity the entity with state to be deleted
	 */
	public abstract void delete(T entity);
	
	/**
	 * Finds all entities managed by this DAO.
	 * @return A list of all found results.
	 */
	public abstract List<T> findAll();
	
	/**
	 * Finds an entity matching the given primary key.
	 * @param id The primary key to be matched.
	 * @return An entity instance or null.
	 */
	public abstract T findById(Object id);
	
}
