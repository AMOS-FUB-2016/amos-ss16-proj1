package de.fuberlin.chaostesting;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Response;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.SimpleError;

@UrlBinding("/showResponseXML.action")
public class ShowResponseXMLAction extends GenericActionBean {
	
	Response response;
	String result;
	int id = -1;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
		
		response = new DAO<>(Response.class).findById(getId());
	    
	    if(response == null) {
	    	context.getValidationErrors().add("noResponseFound", new SimpleError("Keine Antwort gefunden für " + getId(), (Object)null));
	    }
	}
	
	@DefaultHandler
	public Resolution executeTest() {
		setResult(response.getXml());
		
		return new ForwardResolution("/showResponseXML.jsp");
	}
}
