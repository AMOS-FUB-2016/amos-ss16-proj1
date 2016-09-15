package de.fuberlin.chaostesting.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.fuberlin.chaostesting.ioc.MainInjectionModule;

public class TestGuiceModule extends MainInjectionModule {
	
	@Override
	protected EntityManagerFactory createEntityManagerFactory() {
		Map<String, String> overrides = new HashMap<>();
		overrides.put("javax.persistence.jdbc.url", "jdbc:h2:mem:");
		overrides.put("javax.persistence.jdbc.dialect", "org.hibernate.dialect.H2Dialect");
		overrides.put("javax.persistence.jdbc.driver", "org.h2.Driver");
		return Persistence.createEntityManagerFactory("de.fuberlin.chaostesting", overrides);
	}
	
}
