package de.fuberlin.chaostesting;

import java.io.IOException;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Response;
import de.fuberlin.chaostesting.model.Test;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.SimpleError;

@UrlBinding("/executeTest.action")
public class ExecuteTestAction extends GenericActionBean {
	
	Test test;
	String responseMessage;
	int id = -1;
	
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

	public void setResponseMessage(String response) {
		this.responseMessage = response;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Before(stages = LifecycleStage.BindingAndValidation)
	public void rehydrate() {
		try {
			setId(Integer.parseInt(context.getRequest().getParameter("id")));
		} catch(NumberFormatException e) {
			context.getValidationErrors().add("illegalParameter", new SimpleError("Illegaler Request-Parameter", (Object)null));
			return;
		}
		
		test = testDao.findById(getId());
	    
	    if(test == null) {
	    	context.getValidationErrors().add("noTestFound", new SimpleError("Kein Test gefunden für " + getId(), (Object)null));
	    }
	}
	
	@DefaultHandler
	public Resolution executeTest() {
		responseMessage = "Keine Antwort erhalten.";
		
		try {
			Response response = osstClient.executeTest(test);
			response.setTest_id(id);
			response.setValid(validate(response));
			
			responseMessage = response.getXml();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ForwardResolution("/executeTest.jsp");
	}
	
	private boolean validate(Response response){
		return response.getXml().contains("<angebote typ_e=\"VERBINDUNGSANGEBOT\" status_e=\"ANGEBOT_GUELTIG\" bezAngebot=\"Flexpreis\" fahrscheinTyp_e=\"NORMALFAHRSCHEIN\">");
	}
}
