package de.fuberlin.chaostesting.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.google.inject.Guice;

import de.fuberlin.chaostesting.TestCrudAction;
import de.fuberlin.chaostesting.ioc.MainInjectionModule;
import de.fuberlin.chaostesting.ioc.TransactionManagementFilter;
import de.fuberlin.chaostesting.ioc.TransactionManager;
import de.fuberlin.chaostesting.model.DAO;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;
import net.sourceforge.stripes.validation.ValidationErrors;


public class TestCrudActionBeanTest {
	
	boolean initialSetup = false;
	
	private static List<TestCrudActionBeanTest> runningInstances = new ArrayList<>();
	
	private static MockServletContext context;
	
	static EntityManagerFactory emf;
	DAO<de.fuberlin.chaostesting.model.Test> testDao;
	TransactionManager transactionManager;
	@Mock
	TransactionManager mockTransactionManager;
	
	EntityManager entityManager;
	
	
	@Before
	public void initTest() {
		if(!initialSetup) {
			runningInstances.add(this);
			
			MockitoAnnotations.initMocks(this);
			
			context = new MockServletContext("test");
			
			Map<String, String> overrides = new HashMap<>();
			overrides.put("javax.persistence.jdbc.url", "jdbc:h2:mem:");
			overrides.put("javax.persistence.jdbc.dialect", "org.hibernate.dialect.H2Dialect");
			overrides.put("javax.persistence.jdbc.driver", "org.h2.Driver");
			overrides.put("hibernate.hbm2ddl.auto", "create");
			emf = Persistence.createEntityManagerFactory("de.fuberlin.chaostesting", overrides);
			
			
			transactionManager = new TransactionManager(emf);
			entityManager = transactionManager.getEntityManager();
			testDao = new DAO<>(de.fuberlin.chaostesting.model.Test.class, entityManager);
			
			TestInterceptor.setInjector(Guice.createInjector(new MainInjectionModule() {
				@Override
				protected EntityManagerFactory createEntityManagerFactory() {
					return emf;
				}
	
				@Override
				protected TransactionManager createTransactionManager(EntityManagerFactory emf) {
					return mockTransactionManager;
				}
	
				@Override
				protected EntityManager getEntityManager() {
					return entityManager;
				}
			}));
			
			
			Map<String,String> filterParams = new HashMap<>();
			filterParams.put("ActionResolver.Packages", "de.fuberlin.chaostesting");
			filterParams.put("Interceptor.Classes", TestInterceptor.class.getName());
			context.addFilter(StripesFilter.class, "StripesFilter", filterParams);
			
			filterParams = new HashMap<>();
			filterParams.put(TransactionManagementFilter.INJECTION_PROVIDER_CLASSNAME_KEY, TestInterceptor.class.getName());
			context.addFilter(TransactionManagementFilter.class, "Transaction Manager", filterParams);

			// Add the Stripes Dispatcher
			context.setServlet(DispatcherServlet.class, "StripesDispatcher", null);
			
			initialSetup = true;
		}
		
		transactionManager.beginTransaction();
	}
	
	@After
	public void afterTest() {
		transactionManager.commit();
		transactionManager.closeEntityManager();
	}
	
	@AfterClass
	public static void tearDown() {
		emf.close();
		emf = null;
		
		for(TestCrudActionBeanTest instance : runningInstances) {
			instance.tearDownInstance();
		}
		
		runningInstances = null;
		context = null;
	}
	
	public void tearDownInstance() {
		entityManager = null;
		mockTransactionManager = null;
		testDao = null;
		initialSetup = false;
	}
	
	public static MockServletContext getServletContext() {
		return context;
	}
	
	private void verifyTransaction(TransactionManager transactionManager) {
		verify(transactionManager).beginTransaction();
		verify(transactionManager).commit();
		verify(transactionManager).closeEntityManager();
	}
	
	@Test
	public void testValidTestDefinition() throws Exception {
		List<de.fuberlin.chaostesting.model.Test> testsBefore = testDao.findAll();
		
		MockRoundtrip trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		trip.setParameter("test.von", "8000012");
		trip.setParameter("test.nach", "8000034");
		trip.setParameter("test.erwachsene", "3");
		trip.setParameter("test.zeitpunkt", "13.09.2016");
		trip.setParameter("uhrzeit", "13:00");
		trip.setParameter("test.klasse", "KLASSE_1");
		
		trip.execute("create");
		
		verifyTransaction(mockTransactionManager);
		
		TestCrudAction action = trip.getActionBean(TestCrudAction.class);
		
		ValidationErrors errors = action.getContext().getValidationErrors();
		
		assertTrue(errors.size() + " validation error(s) when submitting valid test case. " + errors.toString(), errors.size() == 0);
		
		List<de.fuberlin.chaostesting.model.Test> testsAfter = testDao.findAll();
		
		assertTrue("Expecting action bean to add new test case to database.", testsBefore.size() + 1 == testsAfter.size());
	}
	
	@Test
	public void testInvalidTestDefinition () throws Exception {
		
		MockRoundtrip trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		trip.setParameter("test.von", "abc");
		trip.setParameter("test.nach", "def");
		trip.setParameter("test.erwachsene", "ghi");
		trip.setParameter("test.zeitpunkt", "jkl");
		trip.setParameter("uhrzeit", "mno");
		trip.setParameter("test.klasse", "pqr");
		
		trip.execute("create");
		
		verifyTransaction(mockTransactionManager);
		
		TestCrudAction action = trip.getActionBean(TestCrudAction.class);
		
		assertEquals("Expecting 6 validation errors when submitting invalid test case", action.getContext().getValidationErrors().size(), 6);
		assertEquals(trip.getDestination(), MockRoundtrip.DEFAULT_SOURCE_PAGE); // TODO: is this correct?
	}
	
	@Test
	public void testRequiredFields () throws Exception {
		MockRoundtrip trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		
		trip.execute("create");
		
		verifyTransaction(mockTransactionManager);
		
		TestCrudAction action = trip.getActionBean(TestCrudAction.class);
	
		assertEquals("Expecting 6 validation errors when submitting request without fields", action.getContext().getValidationErrors().size(), 6);
		assertEquals(trip.getDestination(), MockRoundtrip.DEFAULT_SOURCE_PAGE); // TODO: is this correct?
	}
	
	@Test
	public void testInvalidVonNach () throws Exception {
		MockRoundtrip trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		trip.setParameter("test.von", "8000012");
		trip.setParameter("test.nach", "8000012");
		trip.setParameter("test.erwachsene", "3");
		trip.setParameter("test.zeitpunkt", "13.09.2016");
		trip.setParameter("uhrzeit", "13:00");
		trip.setParameter("test.klasse", "KLASSE_1");
		
		trip.execute("create");
		
		verifyTransaction(mockTransactionManager);
		
		TestCrudAction action = trip.getActionBean(TestCrudAction.class);
		
		assertTrue("Should not be able to add same von and nach.", action.getContext().getValidationErrors().containsKey("test.VonNach"));
		assertEquals(trip.getDestination(), MockRoundtrip.DEFAULT_SOURCE_PAGE); // TODO: is this correct?
	}
	
	@Test
	public void testUpdate() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		trip.setParameter("test.von", "8000012");
		trip.setParameter("test.nach", "8000034");
		trip.setParameter("test.erwachsene", "3");
		trip.setParameter("test.zeitpunkt", "13.09.2016");
		trip.setParameter("uhrzeit", "13:00");
		trip.setParameter("test.klasse", "KLASSE_1");
		
		trip.execute("create");
		
		entityManager.flush();
		int testId = trip.getActionBean(TestCrudAction.class).getTest().getId();
		
		trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		trip.setParameter("test.id", String.valueOf(testId));
		trip.setParameter("test.von", "8000013");
		trip.setParameter("test.nach", "8000035");
		trip.setParameter("test.erwachsene", "2");
		trip.setParameter("test.zeitpunkt", "14.09.2016");
		trip.setParameter("uhrzeit", "14:00");
		trip.setParameter("test.klasse", "KLASSE_2");
		
		trip.execute("update");
		
		entityManager.flush();
		
		de.fuberlin.chaostesting.model.Test test = testDao.findById(testId);
		assertTrue("Valid test update should not produce validation errors. " + trip.getValidationErrors(), 
				trip.getValidationErrors().size() == 0);
		
		assertEquals("8000013", test.getVon().toString());
		assertEquals("8000035", test.getNach().toString());
		assertEquals(new Integer(2), test.getErwachsene());
		assertEquals("KLASSE_2", test.getKlasse());
	}
	
	@Test
	public void testDeletion() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		trip.setParameter("test.von", "8000012");
		trip.setParameter("test.nach", "8000034");
		trip.setParameter("test.erwachsene", "3");
		trip.setParameter("test.zeitpunkt", "13.09.2016");
		trip.setParameter("uhrzeit", "13:00");
		trip.setParameter("test.klasse", "KLASSE_1");
		
		trip.execute("create");
		
		entityManager.flush();
		int testId = trip.getActionBean(TestCrudAction.class).getTest().getId();
		
		trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		trip.setParameter("id", String.valueOf(testId));
		
		trip.execute("delete");
		
		assertTrue("Valid test deletion should not produce validation errors. " + trip.getValidationErrors(), 
				trip.getValidationErrors().size() == 0);
		
		assertEquals("Should not be able to find deleted test in database.", null, testDao.findById(testId));
	}
	
	@Test
	public void testInvalidDeletion() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(getServletContext(), TestCrudAction.class);
		trip.execute("delete");
		assertTrue("Delete action should mark missing id as invalid." + trip.getValidationErrors(), 
				trip.getValidationErrors().get("illegalParameter") != null);
		
		trip.setParameter("id", "abcdef");
		trip.execute("delete");
		assertTrue("Delete action should validate numeral id." + trip.getValidationErrors(), 
				trip.getValidationErrors().get("illegalParameter") != null);
		
		trip.setParameter("id", "123456789");
		trip.execute("delete");
		assertTrue("Delete action should detect nonexisting test ids." + trip.getValidationErrors(), 
				trip.getValidationErrors().get("noTestFound") != null);
	}
	
}