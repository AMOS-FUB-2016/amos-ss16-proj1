package de.fuberlin.chaostesting.ioc;

import com.google.inject.Injector;

public interface InjectionProvider {
	
	public Injector provideInjector();
	
}
