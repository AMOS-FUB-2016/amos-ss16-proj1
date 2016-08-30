package de.fuberlin.chaostesting.model;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersistenceUtils {

	private final static EntityManagerFactory entityManagerFactory;
	private final static ThreadLocal<EntityManager> threadLocalEntityManager = new ThreadLocal<>();
	
	static {
		Collection<Pair<String, String>> overridables =
				Arrays.asList(
					Pair.of("JPA_DB_URL", "javax.persistence.jdbc.url"),
					Pair.of("JPA_DB_USER", "javax.persistence.jdbc.user"),
					Pair.of("JPA_DB_PASSWORD", "javax.persistence.jdbc.password")
				);

		Map<String, String> overrides = new HashMap<>();
		overridables.forEach(pair -> {
			String envVal = System.getProperty(pair.getLeft());
			if(envVal != null) {
				overrides.put(pair.getRight(), envVal);
			}
		});
		
		entityManagerFactory = Persistence.createEntityManagerFactory("de.fuberlin.chaostesting", overrides);
	}

	public static EntityManager getEntityManager() {

		EntityManager entityManager = threadLocalEntityManager.get();

		if(entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
			threadLocalEntityManager.set(entityManager);
		}

		return entityManager;
	}

	public static void closeEntityManager() {
		EntityManager entityManager = threadLocalEntityManager.get();
		if(entityManager != null) {
			entityManager.close();
			threadLocalEntityManager.set(null);
		}
	}

	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public static void rollback() {
		getEntityManager().getTransaction().rollback();
	}

	public static void commit() {
		getEntityManager().getTransaction().commit();
	}

	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
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