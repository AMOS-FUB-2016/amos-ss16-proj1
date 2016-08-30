package de.fuberlin.chaostesting.model;
 
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static EntityManagerFactory entityManagerFactory;
    
    public static synchronized EntityManager createEntityManager() {
    	if(entityManagerFactory == null) {
    		entityManagerFactory = Persistence.createEntityManagerFactory("de.fuberlin.chaostesting");
    		assert entityManagerFactory != null;
    	}
    	
    	return entityManagerFactory.createEntityManager();
    }
    
    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
        	Configuration configuration = new Configuration().configure();
    		String url = configuration.getProperty("hibernate.connection.url");
    		String hostname = System.getProperty("HIBERNATE_DB_HOST");    		
    		if(hostname != null && url != null) {
    			url = url.replaceFirst("localhost", hostname);
    			configuration.setProperty("hibernate.connection.url", url);
    		}

            sessionFactory = configuration.buildSessionFactory();
            assert sessionFactory != null;
        }
         
        return sessionFactory;
    }
    
    public static <T> String findEntityTableName(Class<T> type) {
		Table tableAnnot = type.getAnnotation(Table.class);
		if(tableAnnot != null) {
			return tableAnnot.name();
		}
		
		return type.getName();
	}	
	
	public static Object getEntityPrimaryKey(Object entity) {
		Class<? extends Object> type = entity.getClass();
		
		try {
			for(Field field : type.getDeclaredFields()) {
				Id idAnnot = field.getAnnotation(Id.class);
				if(idAnnot != null) {
					return field.get(entity);
				}  
			}
				
			
			for(Method method : type.getDeclaredMethods()) {
				Id idAnnot = method.getAnnotation(Id.class);
				if(idAnnot != null) {
					return method.invoke(entity, (Object[])null);
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			// we treat this as a fatal programming error
			throw new RuntimeException(e);
		}
		
		return null;
	}
	
	public static void setBeanProperty(Object bean, String propertyName, Object value) {
		try {
			PropertyDescriptor propDesc = propDescByName(bean.getClass(), propertyName);
			propDesc.getWriteMethod().invoke(bean, value);
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// programmer's error
			throw new RuntimeException();
		}
	}
	
	public static Object getBeanProperty(Object bean, String propertyName) {
		try {
			PropertyDescriptor propDesc = propDescByName(bean.getClass(), propertyName);
			return propDesc.getReadMethod().invoke(bean, (Object)null);
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// programmer's error
			throw new RuntimeException();
		}
	}
	
	static PropertyDescriptor propDescByName(Class<? extends Object> beanType, String name) throws IntrospectionException {
		BeanInfo info = Introspector.getBeanInfo(beanType);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		
		for(PropertyDescriptor p : pds) {
			if(name.equals(p.getName())) {
				return p;
			} 
		}
			
		return null;
	}
	
	
}
