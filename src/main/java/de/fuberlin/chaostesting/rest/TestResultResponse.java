package de.fuberlin.chaostesting.rest;

import javax.xml.bind.annotation.XmlRootElement;

import de.fuberlin.chaostesting.Marshalling;
import de.fuberlin.chaostesting.model.Response;

@XmlRootElement
public class TestResultResponse {
	
	String error;
	Integer testId;
	boolean valid;
	String responseXML;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getResponseXML() {
		return responseXML;
	}

	public void setResponseXML(String responseXML) {
		this.responseXML = responseXML;
	}
	
	public void configureWithResult(Response response) {
		configureWithResult(response, false);
	}
	
	public void configureWithResult(Response response, boolean extended) {
		this.valid = response.isValid_01();
		this.testId = response.getTest().getId();
		
		if(extended) {
			responseXML = Marshalling.marshal(response);
		}
	}
}
