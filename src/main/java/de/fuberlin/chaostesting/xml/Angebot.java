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
import javax.xml.bind.annotation.XmlType;


/**
 * Das Angebot ist die Kopfstruktur f�r die detaillierte Beschreibung des Angebotes.
 * Ist ein Angebot nicht verkaufbar, so enth�lt es statt der Fahrscheine eine Fehler-Information.
 * Ein Angebot kann aus mehreren Fahrscheinen bestehen. 
 * In diesem Fall ist m�ssen alle Fahrscheine auch verkauft werden, um den Kundenwunsch zu erf�llen.
 * 
 * <p>Java-Klasse f�r Angebot complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Angebot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fehlerInfo" type="{}FehlerInfo" minOccurs="0"/>
 *         &lt;element name="fahrscheine" type="{}Fahrschein" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="typ" use="required" type="{}AngebotsTyp" />
 *       &lt;attribute name="status" use="required" type="{}AngebotsStatus" />
 *       &lt;attribute name="angebotsKlasse" use="required" type="{}WagenKlasse" />
 *       &lt;attribute name="preis" use="required" type="{}Preis" />
 *       &lt;attribute name="bezAngebot" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fahrscheinTyp" use="required" type="{}FahrscheinTyp" />
 *       &lt;attribute name="richtungsInfo" type="{}RichtungsInfo" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Angebot", propOrder = {
    "fehlerInfo",
    "fahrscheine"
})
public class Angebot {

    protected FehlerInfo fehlerInfo;
    protected List<Fahrschein> fahrscheine;
    @XmlAttribute(name = "typ", required = true)
    protected AngebotsTyp typ;
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
    @XmlAttribute(name = "richtungsInfo")
    protected RichtungsInfo richtungsInfo;

    /**
     * Ruft den Wert der fehlerInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FehlerInfo }
     *     
     */
    public FehlerInfo getFehlerInfo() {
        return fehlerInfo;
    }

    /**
     * Legt den Wert der fehlerInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FehlerInfo }
     *     
     */
    public void setFehlerInfo(FehlerInfo value) {
        this.fehlerInfo = value;
    }

    /**
     * Gets the value of the fahrscheine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fahrscheine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFahrscheine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fahrschein }
     * 
     * 
     */
    public List<Fahrschein> getFahrscheine() {
        if (fahrscheine == null) {
            fahrscheine = new ArrayList<Fahrschein>();
        }
        return this.fahrscheine;
    }

    /**
     * Ruft den Wert der typ-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AngebotsTyp }
     *     
     */
    public AngebotsTyp getTyp() {
        return typ;
    }

    /**
     * Legt den Wert der typ-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AngebotsTyp }
     *     
     */
    public void setTyp(AngebotsTyp value) {
        this.typ = value;
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
     * Ruft den Wert der richtungsInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RichtungsInfo }
     *     
     */
    public RichtungsInfo getRichtungsInfo() {
        return richtungsInfo;
    }

    /**
     * Legt den Wert der richtungsInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RichtungsInfo }
     *     
     */
    public void setRichtungsInfo(RichtungsInfo value) {
        this.richtungsInfo = value;
    }

}
