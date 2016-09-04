package de.fuberlin.chaostesting.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Response;
import de.fuberlin.chaostesting.model.Test;
import de.fuberlin.chaostesting.osst.OSSTClient;
import de.fuberlin.chaostesting.osst.OSSTService;

@Path("/")
public class TestExecutionService {
	
	DAO<Test> testDao = DAO.createInstance(Test.class);
	DAO<Response> responseDao = DAO.createInstance(Response.class);
	
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
	public TestResultResponse executeTest(
				@PathParam("testId") Integer testId, 
				@DefaultValue("http://localhost:8082/osst") @QueryParam("osstUrl") String osstUrl,
				@DefaultValue("false") @QueryParam("extended") String extended
			) 
	{
		TestResultResponse response = new TestResultResponse();
		

		if(testId == null) {
			response.setError("no test id given");
		} else {
			Test test = testDao.findById(testId);
			if(test == null) {
				response.setError("no test found for id " + testId);
			} else {
				OSSTClient osstClient = new OSSTClient();
				Response osstResponse = null;
				
				responseDao.create(osstResponse);
				
				try {
					osstResponse = osstClient.executeTest(test, osstUrl);
					response.configureWithResult(osstResponse, "true".equals(extended) ? true : false);
				} catch (IOException e) {
					response.setError("error connecting to osst service");
				}
			}
		}
		
		return response;
	}

	@POST
	@Path("test/executeAll")
	@Produces(MediaType.APPLICATION_JSON)
	public TestResultListResponse executeAllTests (
				@PathParam("testId") Integer testId,
				@DefaultValue("http://localhost:8082/osst") @QueryParam("osstUrl") String osstUrl,
				@DefaultValue("false") @QueryParam("extended") String extended
			)
	{
		TestResultListResponse response = new TestResultListResponse();
		
		List<Test> tests = testDao.findAll();
		
		OSSTService osstService = new OSSTService(tests, osstUrl);
		List<Response> results = osstService.call();
		
		results.forEach(osstResponse -> {
			responseDao.create(osstResponse);
			
			TestResultResponse testResult = new TestResultResponse();
			testResult.configureWithResult(osstResponse, "true".equals(extended) ? true : false);
			response.getResults().add(testResult);
		});
		
		return response;
	}
	
	
}
