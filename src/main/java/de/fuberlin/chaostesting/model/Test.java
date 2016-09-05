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
import javax.persistence.GenerationType;
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
	
	//
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
	@ManyToOne(targetEntity = AngebotsAnfrage.class, cascade = {
			CascadeType.ALL
		})
		@JoinColumn(name = "TEST_ANFRAGE")
	private AngebotsAnfrageHelp anfrage;	
	
	public String getMsgVersion() {
		return msgVersion;
	}

	public void setMsgVersion(String msgVersion) {
		this.msgVersion = msgVersion;
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

	public Date getZeitpunkt() {
		// TODO Auto-generated method stub
		return zeitpunkt;
	}
	
	public void setZeitpunkt(Date zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
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
			//JAXB.marshal(anfrage.toAngebotsAnfrage(), stream);
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
	public class AngebotsAnfrageHelp{
		
		private List<ReisenderHelp> reisender;
		private List<VerbindungsParameterHelp> verbindungsParameter;
		private AllgemeineAngabenHelp allgemeineAngaben;
		private String msgVersion = "1.0";
		private int id;

		public AngebotsAnfrageHelp(){
	    	reisender = new ArrayList<ReisenderHelp>();
	    	verbindungsParameter = new ArrayList<VerbindungsParameterHelp>();
	    	allgemeineAngaben = new AllgemeineAngabenHelp();
	    }

	    @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.AUTO)
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@OneToMany(targetEntity = ReisenderHelp.class, cascade = {
	        CascadeType.ALL
	    })
	    @JoinColumn(name = "ANFRAGE_REISENDER")
		public List<ReisenderHelp> getReisender() {
			if(reisender == null){
				reisender = new ArrayList<ReisenderHelp>();
			}
			return reisender;
		}		
	    public void setReisender(List<ReisenderHelp> reisender) {
	        this.reisender = reisender;
	    }

		@OneToMany(targetEntity = VerbindungsParameterHelp.class, cascade = {
	        CascadeType.ALL
	    })
	    @JoinColumn(name = "ANFRAGE_PARAMETER")
	    public List<VerbindungsParameterHelp> getVerbindungsParameter() {
			if(verbindungsParameter == null){
				verbindungsParameter = new ArrayList<VerbindungsParameterHelp>();
			}
			return verbindungsParameter;
		}
	    public void setVerbindungsParameter(List<VerbindungsParameterHelp> verbindungsParameter) {
	        this.verbindungsParameter = verbindungsParameter;
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
	
	//
	@Entity(name = "ReisenderHelp")
	@Table(name = "REISENDER_HELP")
	@Inheritance(strategy = InheritanceType.JOINED)
	public class ReisenderHelp{

		private int alter = 0;
		private int anzahl = 0;
		private String ermaessigung = null;
		private String typ = null;
		private int id;

	    @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.AUTO)
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

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
 
	//
	@Entity(name = "VerbindungsParameterHelp")
	@Table(name = "VERBINDUNGS_PARAMETER_HELP")
	@Inheritance(strategy = InheritanceType.JOINED)
	public class VerbindungsParameterHelp{
		private List<AnfrageZughaltHelp> halt;
		private List<ProduktKlassenHelp> produktKlassen;
	    private Boolean ankunft;
	    private Integer anzahlFahrraeder;
	    private Integer minUmstiegsZeit;
	    private Integer umstiegsFaktor;
	    private Integer umstiegsZuschlag;
	    private Boolean direktVerbindung;
	    private Date zeitpunkt;
	    private int id;
	    
	    @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

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
		public List<AnfrageZughaltHelp> getHalt() {
			if(halt == null){
				halt = new ArrayList<AnfrageZughaltHelp>();
			}
			return halt;
		}
	    public void setHalt(List<AnfrageZughaltHelp> halt) {
	        this.halt = halt;
	    }

		@OneToMany
		@JoinColumn(name = "PARAMETER_CODES")
		public List<ProduktKlassenHelp> getProduktKlassen() {
			if(produktKlassen == null){
				produktKlassen = new ArrayList<ProduktKlassenHelp>();
			}
			return produktKlassen;
		}
	    public void setProduktKlassen(List<ProduktKlassenHelp> ausschlussProduktKlasse) {
	        this.produktKlassen = ausschlussProduktKlasse;
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
			for(ProduktKlassenHelp p:produktKlassen){
				ProduktKlassen pk = new ProduktKlassen();
				pk.setCodeE(ProduktKlasse.fromValue(p.getCodeE()));
				pks.add(pk);				
			}
			return pks;
		}

		private Collection<? extends AnfrageZughalt> toHalte() {
			List<AnfrageZughalt> halte = new ArrayList<AnfrageZughalt>();
			for(AnfrageZughaltHelp h:halt){
				AnfrageZughalt az = new AnfrageZughalt();
				az.setBahnhof(h.getBahnhof());
				halte.add(az);
			}
			return halte;
		}		
	}
	
	//
	@Entity(name = "AllgemeineAngabenHelp")
	@Table(name = "ALLGEMEINE_ANGABEN_HELP")
	@Inheritance(strategy = InheritanceType.JOINED)
	public class AllgemeineAngabenHelp{
		private String wagenKlasse;
		private int id;

	    @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.AUTO)
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

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
	
	@Entity(name = "AnfrageZughaltHelp")
	@Table(name = "ANFRAGE_ZUGHALT_HELP")
	public class AnfrageZughaltHelp {
		private String bahnhof;
	    private Long id;
	    
	    @Basic
	    @Column(name = "BAHNHOF", length = 255)
	    public String getBahnhof() {
	        return bahnhof;
	    }

	    public void setBahnhof(String value) {
	        this.bahnhof = value;
	    }

	    @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public Long getHjid() {
	        return id;
	    }
	    
	    public void setHjid(Long value) {
	        this.id = value;
	    }
	}
	
	@Entity(name = "ProduktKlassenHelp")
	@Table(name = "PRODUKT_KLASSEN_HELP")
	@Inheritance(strategy = InheritanceType.JOINED)
	public class ProduktKlassenHelp {

	    protected String codeE;
	    protected Long id;

	    @Basic
	    @Column(name = "CODE_E", length = 255)
	    public String getCodeE() {
	        return codeE;
	    }

	    public void setCodeE(String value) {
	        this.codeE = value;
	    }

	    @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public Long getHjid() {
	        return id;
	    }


	    public void setHjid(Long value) {
	        this.id = value;
	    }

	}
}
