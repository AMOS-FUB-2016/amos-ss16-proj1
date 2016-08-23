package de.fuberlin.chaostesting.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Simple DAO mechanism for easy access and abstraction from database semantics.
 * 
 * @author danni
 *
 * @param <T> The entity type to be managed by a DAO
 */
public class DAO<T> {
	
	private Class<T> type;
	private Session currentSession;

	public DAO(Class<T> type) { 
		this.type = type; 
	}
	
	/**
	 * Creates a new entity
	 * @param entity the entity with state to be saved
	 * @return false if creation was unsuccessful, true else
	 */
	public boolean create(T entity) {
		begin();
		Object o = currentSession.save(entity);
		end();
		
		return o != null;
	}
	
	/**
	 * Updates an entity or creates it if necessary.
	 * @param entity the entity with state to be saved
	 */
	public void createOrUpdate(T entity) {
		begin();
		currentSession.saveOrUpdate(entity);
		end();
	}
	
	
	/**
	 * Finds all entities managed by this DAO.
	 * @return A list of all found results.
	 */
	public List<T> findAll() {
		begin();
		List<T> ts = currentSession.createQuery("FROM " + type.getSimpleName(), type).getResultList();
		end();
		
		return ts;
	}
	
	/**
	 * Finds an entity matching the given primary key.
	 * @param id The primary key to be matched.
	 * @return An entity instance or null.
	 */
	public T findById(Serializable id) {
		begin();
		T t = currentSession.get(type, id);
		end();
		
		return t;
	}
	
	void begin() {
		if(currentSession == null) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			currentSession = sessionFactory.openSession();
		}
		currentSession.beginTransaction();
	}
	
	void end() {
		currentSession.getTransaction().commit();
		currentSession.close();
		currentSession = null;
	}
	
	String findEntityTableName() {
		Table tableAnnot = type.getAnnotation(Table.class);
		if(tableAnnot != null) {
			return tableAnnot.name();
		}
		
		return type.getName();
	}	
	
	String findEntityPrimaryKeyFieldName() {
		// TODO: is it also possible to annotate getters as id?
		for(Field field : type.getDeclaredFields()) {
			Id idAnnot = field.getAnnotation(Id.class);
			if(idAnnot != null) {
				return field.getName();
			}
		}
		
		return null;
	}
}
