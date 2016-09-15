package de.fuberlin.chaostesting;

import java.util.List;

import com.google.inject.Inject;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Test;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/showTests.action")
public class ShowTestsAction extends GenericActionBean {

	List<Test> tests;
	
	@Inject DAO<Test> testDao;
	
	public List<Test> getTests() {
		return tests;
	}
	
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	@DefaultHandler
	public Resolution showTests() {
		tests = testDao.findAll();
		
		return new ForwardResolution("showTests.jsp");
	}
}
