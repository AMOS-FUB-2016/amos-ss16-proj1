package de.fuberlin.chaostesting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEST_INFORMATION")
public class Test {
	
	@Id	@GeneratedValue
	@Column(name="test_id")
	private int id;
	@Column(name="test_von")
	private String von;
	@Column(name="test_nach")
	private String nach;
	@Column(name="test_zeitpunkt")
	private Date zeitpunkt;
	@Column(name="test_reisende")
	private String reisende;
	@Column(name="test_klasse")
	private String klasse;
	@Column(name="test_Angebot")
	private boolean angebot = false;
	@Column(name="test_sparpreis")
	private boolean sparpreis = false;
	@Column(name="test_flexpreis")
	private boolean flexpreis = false;
	
	public Test() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVon() {
		return von;
	}

	public void setVon(String von) {
		this.von = von;
	}

	public String getNach() {
		return nach;
	}

	public void setNach(String nach) {
		this.nach = nach;
	}

	public Date getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(Date zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public String getReisende() {
		return reisende;
	}

	public void setReisende(String reisende) {
		this.reisende = reisende;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public boolean isAngebot() {
		return angebot;
	}

	public void setAngebot(boolean angebot) {
		this.angebot = angebot;
	}

	public boolean isSparpreis() {
		return sparpreis;
	}

	public void setSparpreis(boolean sparpreis) {
		this.sparpreis = sparpreis;
	}

	public boolean isFlexpreis() {
		return flexpreis;
	}

	public void setFlexpreis(boolean flexpreis) {
		this.flexpreis = flexpreis;
	}
	
	@SuppressWarnings("deprecation")
	public String toXML(){
		String y = "" + (zeitpunkt.getYear() + 1900);
		String m = String.format("%02d", zeitpunkt.getMonth()+1);
		String d = String.format("%02d", zeitpunkt.getDate());
		String h = String.format("%02d", zeitpunkt.getHours());
		String min = String.format("%02d", zeitpunkt.getMinutes());
		String zeitpunktXML = y + "-" + m + "-" + d + "T" + h + ":" + min + ":00+01:00";
		
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+"<angebotsAnfrage msgVersion=\"1.0\">"
				+"<allgemeineAngaben wagenKlasse_e=\"KLASSE_"+klasse+"\"/>"
				+"<reisender typ_e=\"ERWACHSENER\" anzahl=\""+reisende+"\"/>"
				+"<verbindungsParameter zeitpunkt=\""+zeitpunktXML+"\" >"
				+"<halt bahnhof=\""+von+"\"/>"
				+"<halt bahnhof=\""+nach+"\"/>"
				+"</verbindungsParameter>"
				+"</angebotsAnfrage>";		
		return xml;
	}
}
