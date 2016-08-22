package de.fuberlin.chaostesting;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateUtils;

import de.fuberlin.chaostesting.model.Test;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.After;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;

@UrlBinding("/newTest.action")
public class DefineTestAction extends GenericActionBean {

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
		return uhrzeit;
	}

	@Validate(converter=TimeConverter.class, required=true)
	public void setUhrzeit(Date uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@DefaultHandler
	public Resolution createTest() {
		// add time to the test date
		Date zeitpunkt = test.getZeitpunkt();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(uhrzeit);
		zeitpunkt = DateUtils.addHours(zeitpunkt, calendar.get(Calendar.HOUR_OF_DAY));
		zeitpunkt = DateUtils.addMinutes(zeitpunkt, calendar.get(Calendar.MINUTE));
		test.setZeitpunkt(zeitpunkt);
		
		test.register();
		setResult("Test-Definition erfolgreich");
		return new ForwardResolution("/testDefinition.jsp");
	}
}
