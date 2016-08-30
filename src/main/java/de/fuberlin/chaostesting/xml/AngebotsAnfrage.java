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
 * Dieses Element enth�lt alle Angaben zu einer Angebots-Anfrage.
 * 
 * <p>Java-Klasse f�r AngebotsAnfrage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AngebotsAnfrage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reisender" type="{}Reisender" maxOccurs="unbounded"/>
 *         &lt;element name="verbindungsParameter" type="{}VerbindungsParameter" maxOccurs="unbounded"/>
 *         &lt;element name="allgemeineAngaben" type="{}AllgemeineAngaben"/>
 *       &lt;/sequence>
 *       &lt;attribute name="msgVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AngebotsAnfrage", propOrder = {
    "reisender",
    "verbindungsParameter",
    "allgemeineAngaben"
})
public class AngebotsAnfrage {

    @XmlElement(required = true)
    protected List<Reisender> reisender;
    @XmlElement(required = true)
    protected List<VerbindungsParameter> verbindungsParameter;
    @XmlElement(required = true)
    protected AllgemeineAngaben allgemeineAngaben;
    @XmlAttribute(name = "msgVersion", required = true)
    protected String msgVersion;

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
     * Gets the value of the verbindungsParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verbindungsParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerbindungsParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VerbindungsParameter }
     * 
     * 
     */
    public List<VerbindungsParameter> getVerbindungsParameter() {
        if (verbindungsParameter == null) {
            verbindungsParameter = new ArrayList<VerbindungsParameter>();
        }
        return this.verbindungsParameter;
    }

    /**
     * Ruft den Wert der allgemeineAngaben-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AllgemeineAngaben }
     *     
     */
    public AllgemeineAngaben getAllgemeineAngaben() {
        return allgemeineAngaben;
    }

    /**
     * Legt den Wert der allgemeineAngaben-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AllgemeineAngaben }
     *     
     */
    public void setAllgemeineAngaben(AllgemeineAngaben value) {
        this.allgemeineAngaben = value;
    }

    /**
     * Ruft den Wert der msgVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgVersion() {
        return msgVersion;
    }

    /**
     * Legt den Wert der msgVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgVersion(String value) {
        this.msgVersion = value;
    }

}
