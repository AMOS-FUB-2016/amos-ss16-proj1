package de.fuberlin.chaostesting.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestResultListResponse {
	
	List<TestResultResponse> results;

	public List<TestResultResponse> getResults() {
		if(results == null) {
			results = new ArrayList<>();
		}
		
		return results;
	}

	public void setResults(List<TestResultResponse> results) {
		this.results = results;
	}	
	
}
