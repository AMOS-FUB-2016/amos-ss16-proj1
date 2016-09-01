package de.fuberlin.chaostesting.model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PersistenceStateHelper implements Filter, ServletContextListener {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			PersistenceUtils.beginTransaction();
			chain.doFilter(request, response);
			PersistenceUtils.commit();
		} catch (RuntimeException e) {
			if (PersistenceUtils.getEntityManager() != null && PersistenceUtils.getEntityManager().isOpen())  {
				PersistenceUtils.rollback();
			}
			throw e;
		} finally {
			PersistenceUtils.closeEntityManager();
		}
	}

	@Override
	public void destroy() {	}

	@Override
	public void contextInitialized(ServletContextEvent sce) { }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		PersistenceUtils.closeEntityManagerFactory();
	}
}
