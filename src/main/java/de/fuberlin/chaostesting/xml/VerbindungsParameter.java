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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Das Element VerbindungsParameter enth�lt die Angaben, die f�r die Verbindungssuche ben�tigt werden.
 * Pro Fahrtrichtung wird ein Element erwartet. Das erste Element wird f�r die Hinfahrt verwendet und muss immer �bertragen werden.
 * Ist ein zweites Element vorhanden, so wird es f�r die R�ckfahrt verwendet. In diesem Fall wird ein Fahrschein f�r Hin- und R�ckfahrt erstellt.
 * F�r Umstiegszeiten sind mehrere Parameter vorhanden.
 * Die Umstiegszeit U bei einer konkreten Anfrage berechnet sich aus
 * U = max (Umstiegszeit, x*Umstiegs-Faktor/100 + Umstiegs-Aufschlag), 
 * wobei x ein im Fahrplan am Halt hinterlegter Wert ist.
 * 
 * <p>Java-Klasse f�r VerbindungsParameter complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="VerbindungsParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="halt" type="{}AnfrageZughalt" maxOccurs="unbounded"/>
 *         &lt;element name="ausschlussProduktKlassen" type="{}ProduktKlassen" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ankunft" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="anzahlFahrraeder" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="minUmstiegsZeit" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="umstiegsFaktor" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="umstiegsZuschlag" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="direktVerbindung" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="zeitpunkt" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerbindungsParameter", propOrder = {
    "halt",
    "ausschlussProduktKlassen"
})
public class VerbindungsParameter {

    @XmlElement(required = true)
    protected List<AnfrageZughalt> halt;
    protected List<ProduktKlassen> ausschlussProduktKlassen;
    @XmlAttribute(name = "ankunft")
    protected Boolean ankunft;
    @XmlAttribute(name = "anzahlFahrraeder")
    protected Integer anzahlFahrraeder;
    @XmlAttribute(name = "minUmstiegsZeit")
    protected Integer minUmstiegsZeit;
    @XmlAttribute(name = "umstiegsFaktor")
    protected Integer umstiegsFaktor;
    @XmlAttribute(name = "umstiegsZuschlag")
    protected Integer umstiegsZuschlag;
    @XmlAttribute(name = "direktVerbindung")
    protected Boolean direktVerbindung;
    @XmlAttribute(name = "zeitpunkt", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar zeitpunkt;

    /**
     * Gets the value of the halt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the halt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHalt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnfrageZughalt }
     * 
     * 
     */
    public List<AnfrageZughalt> getHalt() {
        if (halt == null) {
            halt = new ArrayList<AnfrageZughalt>();
        }
        return this.halt;
    }

    /**
     * Gets the value of the ausschlussProduktKlassen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ausschlussProduktKlassen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAusschlussProduktKlassen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProduktKlassen }
     * 
     * 
     */
    public List<ProduktKlassen> getAusschlussProduktKlassen() {
        if (ausschlussProduktKlassen == null) {
            ausschlussProduktKlassen = new ArrayList<ProduktKlassen>();
        }
        return this.ausschlussProduktKlassen;
    }

    /**
     * Ruft den Wert der ankunft-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnkunft() {
        return ankunft;
    }

    /**
     * Legt den Wert der ankunft-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnkunft(Boolean value) {
        this.ankunft = value;
    }

    /**
     * Ruft den Wert der anzahlFahrraeder-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAnzahlFahrraeder() {
        return anzahlFahrraeder;
    }

    /**
     * Legt den Wert der anzahlFahrraeder-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAnzahlFahrraeder(Integer value) {
        this.anzahlFahrraeder = value;
    }

    /**
     * Ruft den Wert der minUmstiegsZeit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinUmstiegsZeit() {
        return minUmstiegsZeit;
    }

    /**
     * Legt den Wert der minUmstiegsZeit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinUmstiegsZeit(Integer value) {
        this.minUmstiegsZeit = value;
    }

    /**
     * Ruft den Wert der umstiegsFaktor-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUmstiegsFaktor() {
        return umstiegsFaktor;
    }

    /**
     * Legt den Wert der umstiegsFaktor-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUmstiegsFaktor(Integer value) {
        this.umstiegsFaktor = value;
    }

    /**
     * Ruft den Wert der umstiegsZuschlag-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUmstiegsZuschlag() {
        return umstiegsZuschlag;
    }

    /**
     * Legt den Wert der umstiegsZuschlag-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUmstiegsZuschlag(Integer value) {
        this.umstiegsZuschlag = value;
    }

    /**
     * Ruft den Wert der direktVerbindung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDirektVerbindung() {
        return direktVerbindung;
    }

    /**
     * Legt den Wert der direktVerbindung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDirektVerbindung(Boolean value) {
        this.direktVerbindung = value;
    }

    /**
     * Ruft den Wert der zeitpunkt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZeitpunkt() {
        return zeitpunkt;
    }

    /**
     * Legt den Wert der zeitpunkt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZeitpunkt(XMLGregorianCalendar value) {
        this.zeitpunkt = value;
    }

}
