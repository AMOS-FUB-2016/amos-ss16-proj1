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
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;

@UrlBinding("/updateTest.action")
public class UpdateTestAction extends GenericActionBean {
	
	Test test;
	String result;
	
	DAO<Test> testDao = DAO.createInstance(Test.class);
	
	Date uhrzeit;
	int id = -1;
	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
	public Date getUhrzeit() {
		return uhrzeit;
	}

	@Validate(converter=TimeConverter.class)
	public void setUhrzeit(Date uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Before(stages = LifecycleStage.BindingAndValidation)
	public void rehydrate() {
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
	
	@DefaultHandler
	public Resolution showTest() {
	    return new RedirectResolution("/updateTest.jsp").addParameter("id", getId()).flash(this);
	}
	
	@HandlesEvent("update")
	public Resolution updateTest() {
		// add time to the test date	    
		Date zeitpunkt = test.getZeitpunkt();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(uhrzeit);
		zeitpunkt = DateUtils.addHours(zeitpunkt, calendar.get(Calendar.HOUR_OF_DAY));
		zeitpunkt = DateUtils.addMinutes(zeitpunkt, calendar.get(Calendar.MINUTE));
		test.setZeitpunkt(zeitpunkt);
		
		testDao.createOrUpdate(test);
		setResult("Test-Update erfolgreich");
		return new RedirectResolution("/updateTest.jsp").addParameter("id", getId()).flash(this);
	}
	
	@HandlesEvent("delete")
	public Resolution deleteTest() {		
		testDao.delete(test);
		
		setResult("Test gelöscht");
		return new ForwardResolution("/deleteTest.jsp");
	}
}
