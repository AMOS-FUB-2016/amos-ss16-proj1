package de.fuberlin.chaostesting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@Column(name="test_id")
	private int test_id;
	@Column(name="valid")
	private String valid;
	
	public Response() {
	}
	
	public Response(String xml, int test_id, String valid) {
		this.xml = xml;
		this.timestamp = new Date();
		this.test_id = test_id;
		this.valid = valid;
	}

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

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	
	public String getValid() {
		return valid;
	}
	
	public void setValid(String valid) {
		this.valid = valid;
	}
}
