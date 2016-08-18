package de.fuberlin.chaostesting;

import java.util.Date;

import de.fuberlin.chaostesting.hibernate.Test;
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
public class TestAction implements ActionBean {

	ActionBeanContext context;
	
	String result;
	Test test;
	
	@Override
	public void setContext(ActionBeanContext context) {
		this.context = context;
	}

	@Override
	public ActionBeanContext getContext() {
		return context;
	}
	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@DefaultHandler
	public Resolution createTest() {
		test.register();
		setResult("Test-Definition erfolgreich");
		return new ForwardResolution("/testDefinition.jsp");
	}
}
