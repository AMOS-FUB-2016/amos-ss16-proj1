package de.fuberlin.chaostesting.ioc;

import java.io.IOException;
import java.lang.reflect.Constructor;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.google.inject.Inject;

import de.fuberlin.chaostesting.model.DataAccessException;

public class TransactionManagementFilter implements Filter {
	
	public static final String INJECTION_PROVIDER_CLASSNAME_KEY = "InjectionProvider";

	@Inject
	TransactionManager transactionManager;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String className = filterConfig.getInitParameter(INJECTION_PROVIDER_CLASSNAME_KEY);
		if(className == null || className.isEmpty()) {
			throw new IllegalArgumentException("No class name for injection provider given.");
		}
		
		try {
			Class<?> clazz = Class.forName(className);
			if(InjectionProvider.class.isAssignableFrom(clazz)) {
				Constructor<?> ctor = clazz.getConstructor();
				InjectionProvider provider = (InjectionProvider) ctor.newInstance();
				provider.provideInjector().injectMembers(this);
			} else {
				throw new IllegalArgumentException("Provider does not conform to " + InjectionProvider.class.getName());
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to instantiate injection provider.", e);
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// don't initialize jpa transaction for static resources
		if(request instanceof HttpServletRequest){
			String path = ((HttpServletRequest) request).getRequestURI();
			if (path.startsWith("/res/")) {
			    chain.doFilter(request, response);
			    return;
			}
		}
		
		try {
			try {
				transactionManager.beginTransaction();
			} catch(RuntimeException e) {
				if(transactionManager.getEntityManagerFactory() == null || ExceptionUtils.indexOfThrowable(e, DataAccessException.class) != -1) {
					e.printStackTrace();
					request.getRequestDispatcher("WEB-INF/dbFailure.jsp").forward(request, response);
					return;
				}
			}
			
			chain.doFilter(request, response);
			transactionManager.commit();
		} catch (RuntimeException | ServletException e) {	
			if (transactionManager.getEntityManager() != null && transactionManager.getEntityManager().isOpen())  {
				transactionManager.rollback();
			}
			
			throw e;
		} finally {
			transactionManager.closeEntityManager();
		}
	}

	@Override
	public void destroy() {
		transactionManager.closeEntityManagerFactory();
		transactionManager = null;
	}

}
