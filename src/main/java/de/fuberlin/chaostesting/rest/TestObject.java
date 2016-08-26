package de.fuberlin.chaostesting.rest;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="test")
//@XmlAccessorType(XmlAccessType.FIELD)
public class TestObject {

	@XmlElement(name="id")    
	private String testId;

	public TestObject(String testId) {
		this.testId = testId;
	}
}
