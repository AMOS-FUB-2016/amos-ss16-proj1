package de.fuberlin.chaostesting.rest;

import javax.xml.bind.annotation.XmlRootElement;

import de.fuberlin.chaostesting.Marshalling;
import de.fuberlin.chaostesting.model.Response;

@XmlRootElement
public class TestResultResponse {
	
	String error;
	Integer testId;
	boolean valid_01;
	boolean valid_02;
	boolean valid_02a;
	String responseXML;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public boolean isValid_01() {
		return valid_01;
	}

	public void setValid_01(boolean valid_01) {
		this.valid_01 = valid_01;
	}

	public boolean isValid_02() {
		return valid_02;
	}

	public void setValid_02(boolean valid_02) {
		this.valid_02 = valid_02;
	}

	public boolean isValid_02a() {
		return valid_02a;
	}

	public void setValid_02a(boolean valid_02a) {
		this.valid_02a = valid_02a;
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
		this.valid_01 = response.isValid_01();
		this.valid_02 = response.isValid_02();
		this.valid_02a = response.isValid_02a();
		this.testId = response.getTest().getId();
		
		if(extended) {
			responseXML = Marshalling.marshal(response.getAntwort());
		}
	}
}
