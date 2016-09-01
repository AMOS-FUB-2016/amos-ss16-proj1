package de.fuberlin.chaostesting.model;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.JAXB;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.deutschebahn.osst.v1_0.*;

@Entity
@Table(name="TEST_INFORMATION")
public class Test {
	
	@Id	@GeneratedValue
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

	public String toXML(){
		String s = null;
		try {
			AngebotsAnfrage anfrage = new AngebotsAnfrage();
			anfrage.setMsgVersion(msgVersion);
			AllgemeineAngaben allgemeineAngaben = new AllgemeineAngaben();
			allgemeineAngaben.setWagenKlasseE(WagenKlasse.valueOf(klasse));
			anfrage.setAllgemeineAngaben(allgemeineAngaben);
			
			VerbindungsParameter parameter = new VerbindungsParameter();
			AnfrageZughalt halt1 = new AnfrageZughalt();
			halt1.setBahnhof(von.toString());
			AnfrageZughalt halt2 = new AnfrageZughalt();
			halt2.setBahnhof(nach.toString());
			parameter.getHalt().add(halt1);
			parameter.getHalt().add(halt2);
			
			DatatypeFactory factory;
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(zeitpunkt);
			factory = DatatypeFactory.newInstance();
			XMLGregorianCalendar calendar = factory.newXMLGregorianCalendar(gc);
			parameter.setZeitpunkt(calendar);
			
			anfrage.getVerbindungsParameter().add(parameter);
			Reisender reisender = new Reisender();
			reisender.setAnzahl(erwachsene);
			reisender.setTypE(ReisendenTyp.ERWACHSENER);
			anfrage.getReisender().add(reisender);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			JAXB.marshal(anfrage, stream);
			s = stream.toString(java.nio.charset.StandardCharsets.UTF_8.name());
			
		} catch (DatatypeConfigurationException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}		
}
