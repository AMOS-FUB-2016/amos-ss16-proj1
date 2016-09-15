package de.fuberlin.chaostesting.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.metamodel.EntityType;

import org.apache.commons.lang3.tuple.Pair;

public class PersistenceUtils {

	public static Set<EntityType<?>> getManagedTypes(EntityManagerFactory emf) {
		return emf.getMetamodel().getEntities();
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
					return getBeanProperty(entity, field.getName());
				}  
			}

			for(Method method : type.getDeclaredMethods()) {
				Id idAnnot = method.getAnnotation(Id.class);
				if(idAnnot != null) {
					return method.invoke(entity);
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
			throw new RuntimeException("could not set bean property \"" + propertyName + "\" on bean of type " + bean.getClass().getName(), e);
		}
	}

	public static Object getBeanProperty(Object bean, String propertyName) {
		try {
			PropertyDescriptor propDesc = propDescByName(bean.getClass(), propertyName);
			return propDesc.getReadMethod().invoke(bean);
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// programmer's error
			throw new RuntimeException("could not fetch bean property \"" + propertyName + "\" on bean of type " + bean.getClass().getName(), e);
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
