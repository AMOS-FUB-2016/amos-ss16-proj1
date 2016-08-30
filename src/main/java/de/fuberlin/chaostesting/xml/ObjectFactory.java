//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.30 um 04:11:47 PM CEST 
//


package de.fuberlin.chaostesting.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.fuberlin.chaostesting.xml4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AngebotsAnfrage_QNAME = new QName("", "AngebotsAnfrage");
    private final static QName _AngebotsAntwort_QNAME = new QName("", "AngebotsAntwort");
    private final static QName _FehlerInfo_QNAME = new QName("", "FehlerInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.fuberlin.chaostesting.xml4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AngebotsAnfrage }
     * 
     */
    public AngebotsAnfrage createAngebotsAnfrage() {
        return new AngebotsAnfrage();
    }

    /**
     * Create an instance of {@link AngebotsAntwort }
     * 
     */
    public AngebotsAntwort createAngebotsAntwort() {
        return new AngebotsAntwort();
    }

    /**
     * Create an instance of {@link FehlerInfo }
     * 
     */
    public FehlerInfo createFehlerInfo() {
        return new FehlerInfo();
    }

    /**
     * Create an instance of {@link HinRueckKombi }
     * 
     */
    public HinRueckKombi createHinRueckKombi() {
        return new HinRueckKombi();
    }

    /**
     * Create an instance of {@link Druckdaten }
     * 
     */
    public Druckdaten createDruckdaten() {
        return new Druckdaten();
    }

    /**
     * Create an instance of {@link Halt }
     * 
     */
    public Halt createHalt() {
        return new Halt();
    }

    /**
     * Create an instance of {@link AnfrageZughalt }
     * 
     */
    public AnfrageZughalt createAnfrageZughalt() {
        return new AnfrageZughalt();
    }

    /**
     * Create an instance of {@link VerkehrsmittelAttribut }
     * 
     */
    public VerkehrsmittelAttribut createVerkehrsmittelAttribut() {
        return new VerkehrsmittelAttribut();
    }

    /**
     * Create an instance of {@link OnlineInterface }
     * 
     */
    public OnlineInterface createOnlineInterface() {
        return new OnlineInterface();
    }

    /**
     * Create an instance of {@link VDSFelder }
     * 
     */
    public VDSFelder createVDSFelder() {
        return new VDSFelder();
    }

    /**
     * Create an instance of {@link Verbindung }
     * 
     */
    public Verbindung createVerbindung() {
        return new Verbindung();
    }

    /**
     * Create an instance of {@link VerbindungsParameter }
     * 
     */
    public VerbindungsParameter createVerbindungsParameter() {
        return new VerbindungsParameter();
    }

    /**
     * Create an instance of {@link FahrscheinTexte }
     * 
     */
    public FahrscheinTexte createFahrscheinTexte() {
        return new FahrscheinTexte();
    }

    /**
     * Create an instance of {@link Reisender }
     * 
     */
    public Reisender createReisender() {
        return new Reisender();
    }

    /**
     * Create an instance of {@link Geltungsdauer }
     * 
     */
    public Geltungsdauer createGeltungsdauer() {
        return new Geltungsdauer();
    }

    /**
     * Create an instance of {@link FahrscheinRichtungsdaten }
     * 
     */
    public FahrscheinRichtungsdaten createFahrscheinRichtungsdaten() {
        return new FahrscheinRichtungsdaten();
    }

    /**
     * Create an instance of {@link ProduktKlassen }
     * 
     */
    public ProduktKlassen createProduktKlassen() {
        return new ProduktKlassen();
    }

    /**
     * Create an instance of {@link DruckRichtungsdaten }
     * 
     */
    public DruckRichtungsdaten createDruckRichtungsdaten() {
        return new DruckRichtungsdaten();
    }

    /**
     * Create an instance of {@link MwStDaten }
     * 
     */
    public MwStDaten createMwStDaten() {
        return new MwStDaten();
    }

    /**
     * Create an instance of {@link Verkehrsmittel }
     * 
     */
    public Verkehrsmittel createVerkehrsmittel() {
        return new Verkehrsmittel();
    }

    /**
     * Create an instance of {@link AllgemeineAngaben }
     * 
     */
    public AllgemeineAngaben createAllgemeineAngaben() {
        return new AllgemeineAngaben();
    }

    /**
     * Create an instance of {@link Fahrschein }
     * 
     */
    public Fahrschein createFahrschein() {
        return new Fahrschein();
    }

    /**
     * Create an instance of {@link Ausfertigungsdaten }
     * 
     */
    public Ausfertigungsdaten createAusfertigungsdaten() {
        return new Ausfertigungsdaten();
    }

    /**
     * Create an instance of {@link Angebot }
     * 
     */
    public Angebot createAngebot() {
        return new Angebot();
    }

    /**
     * Create an instance of {@link EARootClass }
     * 
     */
    public EARootClass createEARootClass() {
        return new EARootClass();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AngebotsAnfrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AngebotsAnfrage")
    public JAXBElement<AngebotsAnfrage> createAngebotsAnfrage(AngebotsAnfrage value) {
        return new JAXBElement<AngebotsAnfrage>(_AngebotsAnfrage_QNAME, AngebotsAnfrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AngebotsAntwort }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AngebotsAntwort")
    public JAXBElement<AngebotsAntwort> createAngebotsAntwort(AngebotsAntwort value) {
        return new JAXBElement<AngebotsAntwort>(_AngebotsAntwort_QNAME, AngebotsAntwort.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FehlerInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FehlerInfo")
    public JAXBElement<FehlerInfo> createFehlerInfo(FehlerInfo value) {
        return new JAXBElement<FehlerInfo>(_FehlerInfo_QNAME, FehlerInfo.class, null, value);
    }

}
