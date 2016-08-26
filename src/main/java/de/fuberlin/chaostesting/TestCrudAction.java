package de.fuberlin.chaostesting;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateUtils;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Test;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.FlashScope;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;

@UrlBinding("/modifyTest.action")
public class TestCrudAction extends GenericActionBean {
	String result;
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
		int id = -1;
		try {
			id = Integer.parseInt(context.getRequest().getParameter("id"));
		} catch(NumberFormatException e) {
			context.getValidationErrors().add("illegalParameter", new SimpleError("Illegaler Request-Parameter", (Object)null));
			return;
		}
		
		test = new DAO<>(Test.class).findById(id);
	    
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
		
		new DAO<>(Test.class).createOrUpdate(test);
		
		FlashScope scope = FlashScope.getCurrent(context.getRequest(), true);
		scope.put("test", test);
		scope.put("result", "Test-Definition erfolgreich");
		
		return new RedirectResolution("/defineTest.jsp");
	}
	
	@HandlesEvent("show")
	public Resolution showTest() {
		return new ForwardResolution("/updateTest.jsp");
	}
	
	@HandlesEvent("update")
	public Resolution updateTest() {
		handleTimeOfDayInput(uhrzeit, test);
		
		new DAO<>(Test.class).createOrUpdate(test);
		setResult("Test-Update erfolgreich");
		return new RedirectResolution(TestCrudAction.class, "show").addParameter("id", test.getId()).flash(this);
	}
	
	@HandlesEvent("delete")
	public Resolution deleteTest() {		
		new DAO<>(Test.class).delete(test);
		
		setResult("Test gelöscht");
		return new ForwardResolution("/deleteTest.jsp");
	}
}
