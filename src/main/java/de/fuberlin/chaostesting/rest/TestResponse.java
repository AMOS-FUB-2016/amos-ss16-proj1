package de.fuberlin.chaostesting.rest;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import de.fuberlin.chaostesting.model.Test;

@XmlRootElement
class TestResponse  {

	public TestResponse() {}
	
	private String error;
	
	private int id;
	private Integer von;
	private Integer nach;
	private Date zeitpunkt;
	private String klasse;
	private Integer erwachsene;
	
	public void configureWithTest(Test test) {
		this.id = test.getId();
		this.von = test.getVon();
		this.nach = test.getNach();
		this.zeitpunkt = test.getZeitpunkt();
		this.erwachsene = test.getErwachsene();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getVon() {
		return von;
	}

	public void setVon(Integer von) {
		this.von = von;
	}

	public Integer getNach() {
		return nach;
	}

	public void setNach(Integer nach) {
		this.nach = nach;
	}

	public Date getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(Date zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public Integer getErwachsene() {
		return erwachsene;
	}

	public void setErwachsene(Integer erwachsene) {
		this.erwachsene = erwachsene;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}	
}
