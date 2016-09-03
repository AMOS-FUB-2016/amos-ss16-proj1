package de.fuberlin.chaostesting.model;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private AngebotsAnfrageHelp anfrage;
	
	@ManyToOne(targetEntity = AngebotsAnfrageHelp.class, cascade = {
		CascadeType.ALL
	})
	@JoinColumn(name = "TEST_ANFRAGE")
	public AngebotsAnfrageHelp getAnfrage() {
		return anfrage;
	}

	public void setAnfrage(AngebotsAnfrageHelp anfrage) {
		this.anfrage = anfrage;
	}

	public Test() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toXML(){
		String s = null;
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			JAXB.marshal(anfrage.toAngebotsAnfrage(), stream);
			s = stream.toString(java.nio.charset.StandardCharsets.UTF_8.name());			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}	
	
	@Entity(name = "AngebotsAnfrageHelp")
	@Table(name = "ANGEBOTS_ANFRAGE_HELP")
	@Inheritance(strategy = InheritanceType.JOINED)
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
		
		@OneToMany(targetEntity = ReisenderHelp.class, cascade = {
	        CascadeType.ALL
	    })
	    @JoinColumn(name = "ANFRAGE_REISENDER")
		public List<ReisenderHelp> getReisender() {
			return reisender;
		}

		@OneToMany(targetEntity = VerbindungsParameterHelp.class, cascade = {
	        CascadeType.ALL
	    })
	    @JoinColumn(name = "ANFRAGE_PARAMETER")
	    public List<VerbindungsParameterHelp> getVerbindungsParameter() {
			return verbindungsParameter;
		}

	    @ManyToOne(targetEntity = AllgemeineAngabenHelp.class, cascade = {
            CascadeType.ALL
        })
        @JoinColumn(name = "ANFRAGE_ANGABEN")
	    public AllgemeineAngabenHelp getAllgemeineAngaben() {
			return allgemeineAngaben;
		}

		public void setAllgemeineAngaben(AllgemeineAngabenHelp allgemeineAngaben) {
			this.allgemeineAngaben = allgemeineAngaben;
		}
	    
		@Basic
	    @Column(name = "ANFRAGE_MSG_VERSION", length = 255)
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
	
	@Entity(name = "ReisenderHelp")
	@Table(name = "REISENDER_HELP")
	@Inheritance(strategy = InheritanceType.JOINED)
	class ReisenderHelp{

		private int alter = 0;
		private int anzahl = 0;
		private String ermaessigung = null;
		private String typ = null;
		
		@Basic
	    @Column(name = "REISENDER_ALTER", precision = 10, scale = 0)
		public int getAlter() {
			return alter;
		}

		public void setAlter(int alter) {
			this.alter = alter;
		}

	    @Basic
	    @Column(name = "REISENDER_ANZAHL", precision = 10, scale = 0)
		public int getAnzahl() {
			return anzahl;
		}

		public void setAnzahl(int anzahl) {
			this.anzahl = anzahl;
		}

	    @Basic
	    @Column(name = "REISENDER_ERMAESSIGUNG", length = 255)
		public String getErmaessigung() {
			return ermaessigung;
		}

		public void setErmaessigung(String ermaessigung) {
			this.ermaessigung = ermaessigung;
		}

	    @Basic
	    @Column(name = "REISENDER_TYP", length = 255)
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
				r.setErmaessigungE(Ermaessigung.fromValue(ermaessigung));					
			}
			r.setTypE(ReisendenTyp.fromValue(typ));
			return r;
		}		
	}
 
	@Entity(name = "VerbindungsParameterHelp")
	@Table(name = "VERBINDUNGS_PARAMETER_HELP")
	@Inheritance(strategy = InheritanceType.JOINED)
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
	    

	    @Basic
	    @Column(name = "PARAMETER_ANKUNFT")
	    public Boolean getAnkunft() {
			return ankunft;
		}

		public void setAnkunft(Boolean ankunft) {
			this.ankunft = ankunft;
		}

		@Basic
	    @Column(name = "PARAMETER_ANZAHL_FAHRRAEDER", precision = 10, scale = 0)
		public Integer getAnzahlFahrraeder() {
			return anzahlFahrraeder;
		}

		public void setAnzahlFahrraeder(Integer anzahlFahrraeder) {
			this.anzahlFahrraeder = anzahlFahrraeder;
		}

	    @Basic
	    @Column(name = "PARAMETER_MIN_UMSTIEGS_ZEIT", precision = 10, scale = 0)
		public Integer getMinUmstiegsZeit() {
			return minUmstiegsZeit;
		}

		public void setMinUmstiegsZeit(Integer minUmstiegsZeit) {
			this.minUmstiegsZeit = minUmstiegsZeit;
		}

	    @Basic
	    @Column(name = "PARAMETER_UMSTIEGS_FAKTOR", precision = 10, scale = 0)
		public Integer getUmstiegsFaktor() {
			return umstiegsFaktor;
		}

		public void setUmstiegsFaktor(Integer umstiegsFaktor) {
			this.umstiegsFaktor = umstiegsFaktor;
		}

	    @Basic
	    @Column(name = "PARAMETER_UMSTIEGS_ZUSCHLAG", precision = 10, scale = 0)
		public Integer getUmstiegsZuschlag() {
			return umstiegsZuschlag;
		}

		public void setUmstiegsZuschlag(Integer umstiegsZuschlag) {
			this.umstiegsZuschlag = umstiegsZuschlag;
		}

	    @Basic
	    @Column(name = "PARAMETER_DIREKT_VERBINDUNG")
		public Boolean getDirektVerbindung() {
			return direktVerbindung;
		}

		public void setDirektVerbindung(Boolean direktVerbindung) {
			this.direktVerbindung = direktVerbindung;
		}

		@Column(name="PARAMETER_ZEITPUNKT")
		public Date getZeitpunkt() {
			return zeitpunkt;
		}

		public void setZeitpunkt(Date zeitpunkt) {
			this.zeitpunkt = zeitpunkt;
		}

		@OneToMany
		@JoinColumn(name = "PARAMETER_HALT")
		public List<String> getHalt() {
			return halt;
		}

		@OneToMany
		@JoinColumn(name = "PARAMETER_CODES")
		public List<String> getAusschlussProduktKlassenCodes() {
			return ausschlussProduktKlassenCodes;
		}
	    
	    VerbindungsParameter toVerbindungsParameter(){
	    	VerbindungsParameter vp = new VerbindungsParameter();
	    	vp.getHalt().addAll(toHalte());
	    	vp.getAusschlussProduktKlasse().addAll(toAusschlussProduktKlassen());
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
				pk.setCodeE(ProduktKlasse.fromValue(s));
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
	
	@Entity(name = "AllgemeineAngabenHelp")
	@Table(name = "ALLGEMEINE_ANGABEN_HELP")
	@Inheritance(strategy = InheritanceType.JOINED)
	class AllgemeineAngabenHelp{
		String wagenKlasse;

		@Basic
	    @Column(name = "ALLGEMEINE_ANGABEN_WAGEN_KLASSE", length = 255)
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
