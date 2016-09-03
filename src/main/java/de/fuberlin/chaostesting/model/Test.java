package de.fuberlin.chaostesting.model;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
	class AngebotsAnfrageHelp{
		
		private List<ReisenderHelp> reisender;
		private List<VerbindungsParameterHelp> verbindungsParameter;
		private AllgemeineAngabenHelp allgemeineAngaben;
		private String msgVersion = "1.0";

		public AngebotsAnfrageHelp(){
	    	reisender = new ArrayList<ReisenderHelp>();
	    	verbindungsParameter = new ArrayList<VerbindungsParameterHelp>();
	    	allgemeineAngaben = new AllgemeineAngabenHelp();
	    }
		
		public List<ReisenderHelp> getReisender() {
			return reisender;
		}

	    public List<VerbindungsParameterHelp> getVerbindungsParameter() {
			return verbindungsParameter;
		}

	    public AllgemeineAngabenHelp getAllgemeineAngaben() {
			return allgemeineAngaben;
		}

		public void setAllgemeineAngaben(AllgemeineAngabenHelp allgemeineAngaben) {
			this.allgemeineAngaben = allgemeineAngaben;
		}
	    
	    public String getMsgVersion() {
			return msgVersion;
		}

		public void setMsgVersion(String msgVersion) {
			this.msgVersion = msgVersion;
		}
	    
	    public AngebotsAnfrage toAngebotsAnfrage(){
	    	AngebotsAnfrage angebot = new AngebotsAnfrage();
	    	angebot.getReisender().addAll(toReisende());
	    	angebot.getVerbindungsParameter().addAll(toVerbindungsParameter());
	    	angebot.setAllgemeineAngaben(allgemeineAngaben.toAllgemeineAngaben());
	    	angebot.setMsgVersion(msgVersion);
	    	return angebot;
	    }
	    
		private Collection<? extends VerbindungsParameter> toVerbindungsParameter() {
			List<VerbindungsParameter> paras = new ArrayList<VerbindungsParameter>();
			for(VerbindungsParameterHelp p:verbindungsParameter){
				paras.add(p.toVerbindungsParameter());
			}
			return paras;
		}

		private Collection<? extends Reisender> toReisende() {
			List<Reisender> reisende = new ArrayList<Reisender>();
			for (ReisenderHelp r:reisender){
				reisende.add(r.toReisender());
			}
			return reisende;
		}
	}
	
	class ReisenderHelp{

		private int alter = 0;
		private int anzahl = 0;
		private String ermaessigung = null;
		private String typ = null;
		
		public int getAlter() {
			return alter;
		}

		public void setAlter(int alter) {
			this.alter = alter;
		}

		public int getAnzahl() {
			return anzahl;
		}

		public void setAnzahl(int anzahl) {
			this.anzahl = anzahl;
		}

		public String getErmaessigung() {
			return ermaessigung;
		}

		public void setErmaessigung(String ermaessigung) {
			this.ermaessigung = ermaessigung;
		}

		public String getTyp() {
			return typ;
		}

		public void setTyp(String typ) {
			this.typ = typ;
		}

		
		public Reisender toReisender() {
			Reisender r = new Reisender();
			if (alter > 0){
				r.setAlter(alter);
			}
			if(anzahl > 0){
				r.setAnzahl(anzahl);
			}
			if(ermaessigung != null){				
				r.setErmaessigung(Ermaessigung.fromValue(ermaessigung));					
			}
			r.setTypE(ReisendenTyp.fromValue(typ));
			return r;
		}		
	}
	
	class VerbindungsParameterHelp{
		private List<String> halt;
		private List<String> ausschlussProduktKlassenCodes;
	    private Boolean ankunft;
	    private Integer anzahlFahrraeder;
	    private Integer minUmstiegsZeit;
	    private Integer umstiegsFaktor;
	    private Integer umstiegsZuschlag;
	    private Boolean direktVerbindung;
	    private Date zeitpunkt;
	    
	    public Boolean getAnkunft() {
			return ankunft;
		}

		public void setAnkunft(Boolean ankunft) {
			this.ankunft = ankunft;
		}

		public Integer getAnzahlFahrraeder() {
			return anzahlFahrraeder;
		}

		public void setAnzahlFahrraeder(Integer anzahlFahrraeder) {
			this.anzahlFahrraeder = anzahlFahrraeder;
		}

		public Integer getMinUmstiegsZeit() {
			return minUmstiegsZeit;
		}

		public void setMinUmstiegsZeit(Integer minUmstiegsZeit) {
			this.minUmstiegsZeit = minUmstiegsZeit;
		}

		public Integer getUmstiegsFaktor() {
			return umstiegsFaktor;
		}

		public void setUmstiegsFaktor(Integer umstiegsFaktor) {
			this.umstiegsFaktor = umstiegsFaktor;
		}

		public Integer getUmstiegsZuschlag() {
			return umstiegsZuschlag;
		}

		public void setUmstiegsZuschlag(Integer umstiegsZuschlag) {
			this.umstiegsZuschlag = umstiegsZuschlag;
		}

		public Boolean getDirektVerbindung() {
			return direktVerbindung;
		}

		public void setDirektVerbindung(Boolean direktVerbindung) {
			this.direktVerbindung = direktVerbindung;
		}

		public Date getZeitpunkt() {
			return zeitpunkt;
		}

		public void setZeitpunkt(Date zeitpunkt) {
			this.zeitpunkt = zeitpunkt;
		}

		public List<String> getHalt() {
			return halt;
		}

		public List<String> getAusschlussProduktKlassenCodes() {
			return ausschlussProduktKlassenCodes;
		}
	    
	    VerbindungsParameter toVerbindungsParameter(){
	    	VerbindungsParameter vp = new VerbindungsParameter();
	    	vp.getHalt().addAll(toHalte());
	    	vp.getAusschlussProduktKlassen().addAll(toAusschlussProduktKlassen());
	    	vp.setAnkunft(ankunft);
	    	vp.setAnzahlFahrraeder(anzahlFahrraeder);
	    	vp.setMinUmstiegsZeit(minUmstiegsZeit);
	    	vp.setUmstiegsFaktor(umstiegsFaktor);
	    	vp.setUmstiegsZuschlag(umstiegsZuschlag);
	    	vp.setDirektVerbindung(direktVerbindung);
	    	DatatypeFactory factory;
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(zeitpunkt);
			try {
				factory = DatatypeFactory.newInstance();
				XMLGregorianCalendar calendar = factory.newXMLGregorianCalendar(gc);
				vp.setZeitpunkt(calendar);
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    	
	    	return vp;
	    }

		private Collection<? extends ProduktKlassen> toAusschlussProduktKlassen() {
			List<ProduktKlassen> pks = new ArrayList<ProduktKlassen>();
			for(String s:ausschlussProduktKlassenCodes){
				ProduktKlassen pk = new ProduktKlassen();
				pk.setCode(ProduktKlasse.fromValue(s));
				pks.add(pk);				
			}
			return pks;
		}

		private Collection<? extends AnfrageZughalt> toHalte() {
			List<AnfrageZughalt> halte = new ArrayList<AnfrageZughalt>();
			for(String s:halt){
				AnfrageZughalt az = new AnfrageZughalt();
				az.setBahnhof(s);
				halte.add(az);
			}
			return halte;
		}		
	}
	class AllgemeineAngabenHelp{
		String wagenKlasse;

		public String getWagenKlasse() {
			return wagenKlasse;
		}

		public void setWagenKlasse(String wagenKlasse) {
			this.wagenKlasse = wagenKlasse;
		}
		
		public AllgemeineAngaben toAllgemeineAngaben(){
			AllgemeineAngaben angaben = new AllgemeineAngaben();
			angaben.setWagenKlasseE(WagenKlasse.fromValue(wagenKlasse));
			return angaben;
		}
	}
}
