package de.fuberlin.chaostesting.model;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Simple DAO mechanism for easy access and abstraction from database semantics.
 * 
 * @author danni
 *
 * @param <T> The entity type to be managed by a DAO
 */
public class DAO<T> {
	
	private DAODelegate<T> delegate;

	public DAO(Class<T> type) { 
		delegate = new JPADAODelegate<>(type);
	}
	
	/**
	 * Creates a new entity
	 * @param entity the entity with state to be saved
	 * @return false if creation was unsuccessful, true else
	 */
	public Object create(T entity) {
		delegate.beginTransactional();
		Object o = delegate.create(entity);
		delegate.endTransactional();
		
		return o;
	}
	
	/**
	 * Updates an entity or creates it if necessary.
	 * @param entity the entity with state to be saved
	 */
	public void createOrUpdate(T entity) {
		delegate.beginTransactional();
		delegate.createOrUpdate(entity);
		delegate.endTransactional();
	}
	
	/**
	 * Deletes an existing entity
	 * @param entity the entity with state to be deleted
	 */
	public void delete(T entity) {
		delegate.beginTransactional();
		delegate.delete(entity);
		delegate.endTransactional();
	}
	
	/**
	 * Finds all entities managed by this DAO.
	 * @return A list of all found results.
	 */
	public List<T> findAll() {
		delegate.beginTransactional();
		List<T> ts = delegate.findAll();
		delegate.endTransactional();
		
		return ts;
	}
	
	/**
	 * Finds an entity matching the given primary key.
	 * @param id The primary key to be matched.
	 * @return An entity instance or null.
	 */
	public T findById(Object id) {
		delegate.beginTransactional();
		T t = delegate.findById(id);
		delegate.endTransactional();
		
		return t;
	}
}
