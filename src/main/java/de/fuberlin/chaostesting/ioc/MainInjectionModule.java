package de.fuberlin.chaostesting.ioc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;

import org.apache.commons.lang3.tuple.Pair;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;

import de.fuberlin.chaostesting.model.DAO;

public class MainInjectionModule extends AbstractModule {
	
	EntityManagerFactory emf;
	TransactionManager transactionManager;
	
	@Override
	protected void configure() {
		
		emf = createEntityManagerFactory();
		transactionManager = createTransactionManager(emf);
		
		bind(EntityManagerFactory.class).toInstance(emf);
		bind(TransactionManager.class).toInstance(transactionManager);
		
		// bind all entity types to concrete dao implementations
		for(EntityType<?> entityType : emf.getMetamodel().getEntities()) {
			Class<?> entityClass = entityType.getBindableJavaType();
			
			bind(TypeLiteral.get(new ParameterizedType() {
				
				@Override
				public Type getRawType() {
					return DAO.class;
				}
				
				@Override
				public Type getOwnerType() {
					return null;
				}
				
				@Override
				public Type[] getActualTypeArguments() {
					return new Type[] {entityClass};
				}
			}));
			
		}
	}
	
	
	@Provides
	private EntityManager provideEntityManager() {
		return getEntityManager();
	}
	
	protected EntityManagerFactory createEntityManagerFactory() {
		Collection<Pair<String, String>> overridables =
				Arrays.asList(
					Pair.of("JPA_DB_URL", "javax.persistence.jdbc.url"),
					Pair.of("JPA_DB_USER", "javax.persistence.jdbc.user"),
					Pair.of("JPA_DB_PASSWORD", "javax.persistence.jdbc.password")
				);

		Map<String, String> overrides = new HashMap<>();
		overridables.forEach(pair -> {
			String envKey = pair.getLeft();
			String jpaKey = pair.getRight();
			
			String envVal = System.getProperty(envKey);
			if(envVal == null) {
				envVal = System.getenv(envKey);
			}
			
			if(envVal != null) {
				overrides.put(jpaKey, envVal);
			}
		});
		
		return Persistence.createEntityManagerFactory("de.fuberlin.chaostesting", overrides);
	}
	
	protected TransactionManager createTransactionManager(EntityManagerFactory emf) {
		return new TransactionManager(emf);
	}

	protected EntityManager getEntityManager() {
		return transactionManager.getEntityManager();
	}
	
}