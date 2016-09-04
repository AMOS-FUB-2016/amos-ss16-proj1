package de.fuberlin.chaostesting.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Test;

@Path("/")
public class TestExecutionService {
	
	DAO<Test> testDao = DAO.createInstance(Test.class);
	
	@GET
	@Path("test/list")
	@Produces(MediaType.APPLICATION_JSON)
	public TestListResponse executeTest() {
		TestListResponse response = new TestListResponse();
		
		List<Test> tests = testDao.findAll();
		
		TestResponse testResult;
		for(Test test : tests) {
			testResult = new TestResponse();
			testResult.configureWithTest(test);
			response.getTests().add(testResult);
		}
		
		return response;
	}
	
	@GET
	@Path("test/{testId}")
	@Produces(MediaType.APPLICATION_JSON)
	public TestResponse testById(@PathParam("testId") Integer testId) {
		TestResponse response = new TestResponse();
		
		if(testId == null) {
			response.setError("no test id given");
		} else {
			Test test = testDao.findById(testId);
			if(test == null) {
				response.setError("no test found for id " + testId);
			} else {
				response.configureWithTest(test);
			}
		}
		
		return response;
	}
	
	@POST
	@Path("test/{testId}/execute")
	@Produces(MediaType.APPLICATION_JSON)
	public TestResultResponse executeTest(@PathParam("testId") Integer testId) {
		TestResultResponse response = new TestResultResponse();
		
		return response;
	}
	
	@POST
	@Path("test/executeAll")
	@Produces(MediaType.APPLICATION_JSON)
	public TestResultResponse executeAllTests(@PathParam("testId") Integer testId) {
		TestResultResponse response = new TestResultResponse();
		
		return response;
	}
	
	
	
}
