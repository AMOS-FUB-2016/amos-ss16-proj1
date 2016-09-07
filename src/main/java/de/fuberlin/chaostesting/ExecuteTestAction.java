package de.fuberlin.chaostesting;

import java.io.IOException;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Response;
import de.fuberlin.chaostesting.model.Test;
import de.fuberlin.chaostesting.osst.OSSTClient;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.action.Wizard;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;

@Wizard(startEvents="prepareTestExecution")
@UrlBinding("/executeTest.action")
public class ExecuteTestAction extends GenericActionBean {
	
	Test test;
	String responseMessage;
	
	@Validate(required=true)
	String url;
	
	DAO<Test> testDao = DAO.createInstance(Test.class);
	DAO<Response> responseDao = DAO.createInstance(Response.class);
	OSSTClient osstClient = new OSSTClient();
	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	public Resolution prepareTestExecution() {
		setUrl("http://localhost:8082/osst");
		
		return new ForwardResolution("/WEB-INF/jsps/prepareTest.jsp");
	}
	
	public Resolution executeTest() {
		responseMessage = "Keine Antwort erhalten.";
		
		try {
			Response response = osstClient.executeTest(test, getUrl());
			
			responseMessage = Marshalling.marshal(response.getAntwort());
			
			responseDao.create(response);
		} catch (IOException e) {
			throw new RuntimeException("error creating or persisting response", e);
		}
		
		return new ForwardResolution("/executeTest.jsp");
	}
}
