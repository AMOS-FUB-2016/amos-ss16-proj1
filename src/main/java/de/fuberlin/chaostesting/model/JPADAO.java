package de.fuberlin.chaostesting.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

class JPADAO<T> extends DAO<T> {

	EntityManager entityManager;
	Class<T> type;
	
	public JPADAO(Class<T> type, EntityManager entityManager) {
		this.type = type;
		this.entityManager = entityManager;
	}
	
	@Override
	public Object create(T entity) {
		entityManager.persist(entity);

		return PersistenceUtils.getEntityPrimaryKey(entity);		
	}

	@Override
	public void createOrUpdate(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public List<T> findAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(type);
        Root<T> rootEntry = cq.from(type);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

	@Override
	public T findById(Object id) {
		return entityManager.find(type, id);
	}

}
