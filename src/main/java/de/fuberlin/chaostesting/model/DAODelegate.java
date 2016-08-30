package de.fuberlin.chaostesting.model;

import java.util.List;

interface DAODelegate<T> {

	Object create(T entity);
	
	void createOrUpdate(T entity);
	
	void delete(T entity);
	
	public List<T> findAll();
	
	public T findById(Object id);

}
