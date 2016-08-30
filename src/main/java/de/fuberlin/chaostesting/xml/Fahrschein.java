//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.30 um 04:11:47 PM CEST 
//


package de.fuberlin.chaostesting.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Das Element Fahrschein enth�lt alle Informationen, die zum Ausstellen eines Fahrscheins (Fahrtberechtigungs-Nachweises) an den Kunden ben�tigt werden.
 * Ein Angebot kann aus mehreren Fahrscheinen bestehen.
 * Jeder Fahrschein ist separat zu verkaufen und zu buchen. Auch wenn die Fahrscheine als Teile eines Angebots erstellt werden, sind sie doch voneinander unabh�ngig.
 * 
 * <p>Java-Klasse f�r Fahrschein complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Fahrschein">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reisender" type="{}Reisender" maxOccurs="unbounded"/>
 *         &lt;element name="ausfertigungsDaten" type="{}Ausfertigungsdaten" minOccurs="0"/>
 *         &lt;element name="richtungsDaten" type="{}FahrscheinRichtungsdaten" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="status" use="required" type="{}AngebotsStatus" />
 *       &lt;attribute name="angebotsKlasse" use="required" type="{}WagenKlasse" />
 *       &lt;attribute name="preis" use="required" type="{}Preis" />
 *       &lt;attribute name="bezAngebot" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fahrscheinTyp" use="required" type="{}FahrscheinTyp" />
 *       &lt;attribute name="reservierungspflichtig" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fahrschein", propOrder = {
    "reisender",
    "ausfertigungsDaten",
    "richtungsDaten"
})
public class Fahrschein {

    @XmlElement(required = true)
    protected List<Reisender> reisender;
    protected Ausfertigungsdaten ausfertigungsDaten;
    @XmlElement(required = true)
    protected List<FahrscheinRichtungsdaten> richtungsDaten;
    @XmlAttribute(name = "status", required = true)
    protected AngebotsStatus status;
    @XmlAttribute(name = "angebotsKlasse", required = true)
    protected WagenKlasse angebotsKlasse;
    @XmlAttribute(name = "preis", required = true)
    protected int preis;
    @XmlAttribute(name = "bezAngebot", required = true)
    protected String bezAngebot;
    @XmlAttribute(name = "fahrscheinTyp", required = true)
    protected FahrscheinTyp fahrscheinTyp;
    @XmlAttribute(name = "reservierungspflichtig")
    protected Boolean reservierungspflichtig;

    /**
     * Gets the value of the reisender property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reisender property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReisender().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reisender }
     * 
     * 
     */
    public List<Reisender> getReisender() {
        if (reisender == null) {
            reisender = new ArrayList<Reisender>();
        }
        return this.reisender;
    }

    /**
     * Ruft den Wert der ausfertigungsDaten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Ausfertigungsdaten }
     *     
     */
    public Ausfertigungsdaten getAusfertigungsDaten() {
        return ausfertigungsDaten;
    }

    /**
     * Legt den Wert der ausfertigungsDaten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Ausfertigungsdaten }
     *     
     */
    public void setAusfertigungsDaten(Ausfertigungsdaten value) {
        this.ausfertigungsDaten = value;
    }

    /**
     * Gets the value of the richtungsDaten property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the richtungsDaten property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRichtungsDaten().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FahrscheinRichtungsdaten }
     * 
     * 
     */
    public List<FahrscheinRichtungsdaten> getRichtungsDaten() {
        if (richtungsDaten == null) {
            richtungsDaten = new ArrayList<FahrscheinRichtungsdaten>();
        }
        return this.richtungsDaten;
    }

    /**
     * Ruft den Wert der status-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AngebotsStatus }
     *     
     */
    public AngebotsStatus getStatus() {
        return status;
    }

    /**
     * Legt den Wert der status-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AngebotsStatus }
     *     
     */
    public void setStatus(AngebotsStatus value) {
        this.status = value;
    }

    /**
     * Ruft den Wert der angebotsKlasse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WagenKlasse }
     *     
     */
    public WagenKlasse getAngebotsKlasse() {
        return angebotsKlasse;
    }

    /**
     * Legt den Wert der angebotsKlasse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WagenKlasse }
     *     
     */
    public void setAngebotsKlasse(WagenKlasse value) {
        this.angebotsKlasse = value;
    }

    /**
     * Ruft den Wert der preis-Eigenschaft ab.
     * 
     */
    public int getPreis() {
        return preis;
    }

    /**
     * Legt den Wert der preis-Eigenschaft fest.
     * 
     */
    public void setPreis(int value) {
        this.preis = value;
    }

    /**
     * Ruft den Wert der bezAngebot-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBezAngebot() {
        return bezAngebot;
    }

    /**
     * Legt den Wert der bezAngebot-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBezAngebot(String value) {
        this.bezAngebot = value;
    }

    /**
     * Ruft den Wert der fahrscheinTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FahrscheinTyp }
     *     
     */
    public FahrscheinTyp getFahrscheinTyp() {
        return fahrscheinTyp;
    }

    /**
     * Legt den Wert der fahrscheinTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FahrscheinTyp }
     *     
     */
    public void setFahrscheinTyp(FahrscheinTyp value) {
        this.fahrscheinTyp = value;
    }

    /**
     * Ruft den Wert der reservierungspflichtig-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReservierungspflichtig() {
        return reservierungspflichtig;
    }

    /**
     * Legt den Wert der reservierungspflichtig-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReservierungspflichtig(Boolean value) {
        this.reservierungspflichtig = value;
    }

}
