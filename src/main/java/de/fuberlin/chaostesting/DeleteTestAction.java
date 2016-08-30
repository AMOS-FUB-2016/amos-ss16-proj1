package de.fuberlin.chaostesting;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Test;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.SimpleError;

@UrlBinding("/deleteTest.action")
public class DeleteTestAction extends GenericActionBean {
	
	Test test;
	String result;
	
	DAO<Test> testDao = DAO.createInstance(Test.class);
	
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
	public Resolution deleteTest() {		
		testDao.delete(test);
		
		setResult("Test gelöscht");
		return new ForwardResolution("/deleteTest.jsp");
	}
}
