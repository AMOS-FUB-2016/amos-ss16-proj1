package de.fuberlin.chaostesting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEST_INFORMATION")
public class Test {
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="test_id")
	private int id;
	
	@Column(name="test_von")
	private Integer von;
	
	@Column(name="test_nach")
	private Integer nach;
	
	@Column(name="test_zeitpunkt")
	private Date zeitpunkt;
	
	@Column(name="test_klasse")
	private String klasse;
	
	@Column(name="test_erwachsene")
	private Integer erwachsene = 0;
	
	@Column(name="test_msgVersion")
	private String msgVersion = "1.0";
	

	public Test() {
	}
	
	public String getMsgVersion() {
		return msgVersion;
	}

	public void setMsgVersion(String msgVersion) {
		this.msgVersion = msgVersion;
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

}
