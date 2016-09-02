package de.fuberlin.chaostesting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TEST_RESPONSE")
public class Response {
	
	@Id	@GeneratedValue
	@Column(name="response_id")
	private int id;
	
	@Column(name="response_xml", length=65535)
	@org.hibernate.annotations.Type(type="de.fuberlin.chaostesting.model.usertype.XMLType")
	private String xml;
	
	@Column(name="response_timestamp")
	private Date timestamp;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="test_id")
	private Test test;
	
	@Column(name="valid")
	private boolean valid;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
