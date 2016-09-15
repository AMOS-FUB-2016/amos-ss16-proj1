package de.fuberlin.chaostesting.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class IOC implements InjectionProvider {
	
	private static class InjectorHolder {
		private static final Injector mainInjector = Guice.createInjector(new MainInjectionModule());
	}
	
	public static Injector getMainInjectorInstance() {
		return InjectorHolder.mainInjector;
	}

	@Override
	public Injector provideInjector() {
		return getMainInjectorInstance();
	}
}
