package de.fuberlin.chaostesting;

import java.util.List;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Response;
import de.fuberlin.chaostesting.model.Test;
import de.fuberlin.chaostesting.osst.OSSTService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/executeAllTests.action")
public class ExecuteAllTestsAction extends GenericActionBean {
	
	DAO<Test> testDao = DAO.createInstance(Test.class);
	
	String url;
	String responseMessage;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@DefaultHandler
	public Resolution executeAllTests() {
		List<Test> allTests = testDao.findAll();
		
		setUrl("http://localhost:8082/osst");
		
		List<Response> responses = new OSSTService(allTests, getUrl()).call();
		
		int valid = 0;
		int all = responses.size();
		for (Response response : responses) {
			if (response.isValid()) {
				valid++;
			}
		}		
		setResponseMessage(valid + " aus " + all + " Tests valide");
		// TODO: persist test results
		
		return new ForwardResolution("/executeTest.jsp");
	}	
}
