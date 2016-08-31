package de.fuberlin.chaostesting.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

class HibernateDAO<T> extends DAO<T> {

	private Class<T> type;
	
	private Session session;
	
	public HibernateDAO(Class<T> type, Session session) {
		this.type = type;
		this.session = session;
	}

	@Override
	public Object create(T entity) {
		return session.save(entity);
	}
	
	@Override
	public void createOrUpdate(T entity) {
		session.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		session.delete(entity);
	}

	@Override
	public List<T> findAll() {
		return session.createQuery("FROM " + type.getSimpleName(), type).getResultList();
	}

	@Override
	public T findById(Object id) {
		if(!(id instanceof Serializable)) {
			throw new RuntimeException("id in hibernate must be of type " + Serializable.class.getName());
		}
		return session.get(type, (Serializable)id);
	}

}
