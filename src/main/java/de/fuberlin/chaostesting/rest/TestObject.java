package de.fuberlin.chaostesting.rest;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="test")
public class TestObject {
	
	private String name;
	
	//@XmlElement(name="wert") 
	private String value;

	public TestObject() {
		this.name = "leer";
	}
	public TestObject(String testDescription) {
		this.name = testDescription;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}


} 