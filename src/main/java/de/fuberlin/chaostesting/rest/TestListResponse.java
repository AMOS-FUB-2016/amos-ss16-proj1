package de.fuberlin.chaostesting.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class TestListResponse {
	List<TestResponse> tests;

	public List<TestResponse> getTests() {
		if(tests == null) {
			tests = new ArrayList<>();
		}
		
		return tests;
	}

	public void setTests(List<TestResponse> tests) {
		this.tests = tests;
	}	
}
