package de.fuberlin.chaostesting;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateUtils;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Test;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.FlashScope;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

@UrlBinding("/modifyTest.action")
public class TestCrudAction extends GenericActionBean {
	String result;

	DAO<Test> testDao = DAO.createInstance(Test.class);
	
	@ValidateNestedProperties({
		@Validate(field="von", required=true, minvalue=8000001, maxvalue=8099999),
		@Validate(field="nach", required=true, minvalue=8000001, maxvalue=8099999),
		@Validate(field="zeitpunkt", required=true),
		@Validate(field="erwachsene", required=true, minvalue=1, maxvalue=5),
		@Validate(field="klasse", required=true)
	})
	Test test; // TODO: create validator for test class
	Date uhrzeit;
	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Date getUhrzeit() {
		if(uhrzeit == null && test != null && test.getZeitpunkt() != null) {
			return test.getZeitpunkt();
		}
		return uhrzeit;
	}

	@Validate(converter=TimeConverter.class, required=true, on={"update", "create"})
	public void setUhrzeit(Date uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Before(stages = LifecycleStage.BindingAndValidation, on={"show", "delete"})
	public void rehydrate() {
		testDao = DAO.createInstance(Test.class);
		
		int id = -1;
		try {
			id = Integer.parseInt(context.getRequest().getParameter("id"));
		} catch(NumberFormatException e) {
			context.getValidationErrors().add("illegalParameter", new SimpleError("Illegaler Request-Parameter", (Object)null));
			return;
		}
		
		test = testDao.findById(id);
	    
	    if(test == null) {
	    	context.getValidationErrors().add("noTestFound", new SimpleError("Kein Test gefunden für " + id, (Object)null));
	    }
	}
	
	void handleTimeOfDayInput(Date timeOfDay, Test test) {
		Date zeitpunkt = test.getZeitpunkt();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(timeOfDay);
		zeitpunkt = DateUtils.addHours(zeitpunkt, calendar.get(Calendar.HOUR_OF_DAY));
		zeitpunkt = DateUtils.addMinutes(zeitpunkt, calendar.get(Calendar.MINUTE));
		test.setZeitpunkt(zeitpunkt);
	}

	@DefaultHandler
	public Resolution handleDefault() {
		// assume user wants to create a test
		return new RedirectResolution("defineTest.jsp");
	}
	
	@HandlesEvent("create")
	public Resolution createTest() {
		handleTimeOfDayInput(uhrzeit, test);
		
		testDao.createOrUpdate(test);
		
		FlashScope scope = FlashScope.getCurrent(context.getRequest(), true);
		scope.put("test", test);
		scope.put("result", "Test-Definition erfolgreich");
		
		return new RedirectResolution("/defineTest.jsp");
	}
	
	@DontValidate
	@HandlesEvent("show")
	public Resolution showTest() {
		return new ForwardResolution("/updateTest.jsp");
	}
	
	@HandlesEvent("update")
	public Resolution updateTest() {
		handleTimeOfDayInput(uhrzeit, test);
		
		testDao.createOrUpdate(test);
		setResult("Test-Update erfolgreich");
		return new RedirectResolution(TestCrudAction.class, "show").addParameter("id", test.getId()).flash(this);
	}
	
	@DontValidate
	@HandlesEvent("delete")
	public Resolution deleteTest() {		
		testDao.delete(test);
		
		setResult("Test gelöscht");
		return new ForwardResolution("/deleteTest.jsp");
	}
	
	@DontValidate
	@HandlesEvent("deleteUpdate")
	public Resolution deleteUpdateTest() {
		// reload test to get a attached instance
		test = testDao.findById(test.getId());
		return deleteTest();
	}
	
	@ValidationMethod
	public void validateVonNach(ValidationErrors errors) {
		if (test.getVon().equals(test.getNach())) {
			errors.add("VonEqualsNachError", new SimpleError("Von und Nach sind gleich."));
		}
	}
	    
}
