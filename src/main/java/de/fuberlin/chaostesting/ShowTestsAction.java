package de.fuberlin.chaostesting;

import java.util.List;

import de.fuberlin.chaostesting.hibernate.Test;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/showTests.action")
public class ShowTestsAction extends GenericActionBean {

	List<Test> tests;
	
	public List<Test> getTests() {
		return tests;
	}
	
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	@DefaultHandler
	public Resolution showTests() {
		tests = Test.list();
		
		return new ForwardResolution("showTests.jsp");
	}
}
