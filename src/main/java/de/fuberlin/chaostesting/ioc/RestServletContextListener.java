package de.fuberlin.chaostesting.ioc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.inject.servlet.ServletModule;
import com.squarespace.jersey2.guice.JerseyGuiceModule;
import com.squarespace.jersey2.guice.JerseyGuiceUtils;


/**
 * Performs dependency injection for REST services defined with Jersey.
 */
public class RestServletContextListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		JerseyGuiceUtils.install(IOC.getMainInjectorInstance().createChildInjector(
				new JerseyGuiceModule("__HK2_Generated_0"), new ServletModule()));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {		
	}
}
