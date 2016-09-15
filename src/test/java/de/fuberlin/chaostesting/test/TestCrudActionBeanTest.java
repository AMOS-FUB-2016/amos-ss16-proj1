package de.fuberlin.chaostesting.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Inject;

import de.fuberlin.chaostesting.TestCrudAction;
import de.fuberlin.chaostesting.ioc.TransactionManagementFilter;
import de.fuberlin.chaostesting.model.DAO;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;


public class TestCrudActionBeanTest {
	
	private static MockServletContext context;
	
	@Inject
	DAO<de.fuberlin.chaostesting.model.Test> testDao;
	
	@BeforeClass
	public static void init() {
		context = new MockServletContext("test");
		
		Map<String,String> filterParams = new HashMap<>();
		filterParams.put("ActionResolver.Packages", "de.fuberlin.chaostesting");
		filterParams.put("Interceptor.Classes", TestInterceptor.class.getName());
		context.addFilter(StripesFilter.class, "StripesFilter", filterParams);
		
		filterParams = new HashMap<>();
		filterParams.put(TransactionManagementFilter.INJECTION_PROVIDER_CLASSNAME_KEY, TestInterceptor.class.getName());
		context.addFilter(TransactionManagementFilter.class, "Transaction Manager", filterParams);
		 
		// Add the Stripes Dispatcher
		context.setServlet(DispatcherServlet.class, "StripesDispatcher", null);
	}
	
	public static MockServletContext getServletContext() {
		return context;
	}
	
	@Test
	public void testTestDefinitionCreation() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		trip.setParameter("test.von", "8000012");
		trip.execute("create");
//		trip.execute();
		TestCrudAction action = trip.getActionBean(TestCrudAction.class);
		
		TestInterceptor.getInjector().injectMembers(this);
		System.out.println(testDao);
		List<de.fuberlin.chaostesting.model.Test> tests = testDao.findAll();
		System.out.println(tests);
	}
}