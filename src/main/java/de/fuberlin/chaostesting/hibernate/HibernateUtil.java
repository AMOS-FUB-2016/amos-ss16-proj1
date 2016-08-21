package de.fuberlin.chaostesting.hibernate;
 
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository  
@Transactional*/ 
public class HibernateUtil<Object> {
	//@Autowired
    public static SessionFactory sessionFactory;
    
	
	/*public <T> void save (T dataTableObject) {
		Session currentSession = sessionFactory.getCurrentSession();  
		currentSession.saveOrUpdate(dataTableObject);
	}*/
	
	public static <T> void create (T dataTableObject) {
		insert(dataTableObject);
	}
    
	public static <T> void insert (T dataTableObject) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();	
		session.save(dataTableObject);
		session.getTransaction().commit();
	}
    
    
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
        	Configuration configuration = new Configuration().configure();
    		String url = configuration.getProperty("hibernate.connection.url");
    		String hostname = System.getProperty("HIBERNATE_DB_HOST");    		
    		if(hostname != null && url != null) {
    			url = url.replaceFirst("localhost", hostname);
    			configuration.setProperty("hibernate.connection.url", url);
    		}
            sessionFactory = configuration.buildSessionFactory();
        }   
        return sessionFactory;
    }
    
    public Session startSession(){
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
    }

	public static int delete (String table, int id)  
	{  
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "DELETE FROM " + table + " WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		int res = query.executeUpdate();
		session.getTransaction().commit();
		return res;
	} 
	
	public List<Object> listDAO (String table) {		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Object> tests = (List<Object>)session.createQuery("FROM " + table).getResultList();
		
		session.getTransaction().commit();
		return tests;
	}
    
}
