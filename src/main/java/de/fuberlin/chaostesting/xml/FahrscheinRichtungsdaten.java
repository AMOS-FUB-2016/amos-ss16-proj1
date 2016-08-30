//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.30 um 04:11:47 PM CEST 
//


package de.fuberlin.chaostesting.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Das Element FahrscheinRichtungsdaten enth�lt die richtungsabh�ngigen Informationen zum Fahrschein.
 * 
 * <p>Java-Klasse f�r FahrscheinRichtungsdaten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FahrscheinRichtungsdaten">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="geltungsdauer" type="{}Geltungsdauer"/>
 *       &lt;/all>
 *       &lt;attribute name="bezAbgang" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bezZiel" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FahrscheinRichtungsdaten", propOrder = {

})
public class FahrscheinRichtungsdaten {

    @XmlElement(required = true)
    protected Geltungsdauer geltungsdauer;
    @XmlAttribute(name = "bezAbgang", required = true)
    protected String bezAbgang;
    @XmlAttribute(name = "bezZiel", required = true)
    protected String bezZiel;

    /**
     * Ruft den Wert der geltungsdauer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Geltungsdauer }
     *     
     */
    public Geltungsdauer getGeltungsdauer() {
        return geltungsdauer;
    }

    /**
     * Legt den Wert der geltungsdauer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Geltungsdauer }
     *     
     */
    public void setGeltungsdauer(Geltungsdauer value) {
        this.geltungsdauer = value;
    }

    /**
     * Ruft den Wert der bezAbgang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBezAbgang() {
        return bezAbgang;
    }

    /**
     * Legt den Wert der bezAbgang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBezAbgang(String value) {
        this.bezAbgang = value;
    }

    /**
     * Ruft den Wert der bezZiel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBezZiel() {
        return bezZiel;
    }

    /**
     * Legt den Wert der bezZiel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBezZiel(String value) {
        this.bezZiel = value;
    }

}
