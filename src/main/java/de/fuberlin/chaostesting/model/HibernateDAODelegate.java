package de.fuberlin.chaostesting.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

class HibernateDAODelegate<T> implements DAODelegate<T> {

	private Class<T> type;
	
	private Session currentSession;
	
	public HibernateDAODelegate(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public void beginTransactional() {
		if(currentSession == null) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			currentSession = sessionFactory.openSession();
		}
		currentSession.beginTransaction();
	}

	@Override
	public void endTransactional() {
		currentSession.getTransaction().commit();
		currentSession.close();
		currentSession = null;
	}

	@Override
	public Object create(T entity) {
		return currentSession.save(entity);
	}
	
	@Override
	public void createOrUpdate(T entity) {
		currentSession.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		currentSession.delete(entity);
	}

	@Override
	public List<T> findAll() {
		return currentSession.createQuery("FROM " + type.getSimpleName(), type).getResultList();
	}

	@Override
	public T findById(Object id) {
		if(!(id instanceof Serializable)) {
			throw new RuntimeException("id in hibernate must be of type " + Serializable.class.getName());
		}
		return currentSession.get(type, (Serializable)id);
	}

}
