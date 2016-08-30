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
import javax.xml.bind.annotation.XmlType;


/**
 * Druck-Richtungsdaten) enthalten richtungsabh�ngige Druckdaten.
 * 
 * <p>Java-Klasse f�r DruckRichtungsdaten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DruckRichtungsdaten">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="bezAbgang" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bezAbgangAlt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bezAnbBhfAb" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bezZiel" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bezZielAlt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bezAnbBhfAn" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DruckRichtungsdaten", propOrder = {

})
public class DruckRichtungsdaten {

    @XmlAttribute(name = "bezAbgang", required = true)
    protected String bezAbgang;
    @XmlAttribute(name = "bezAbgangAlt", required = true)
    protected String bezAbgangAlt;
    @XmlAttribute(name = "bezAnbBhfAb", required = true)
    protected String bezAnbBhfAb;
    @XmlAttribute(name = "bezZiel", required = true)
    protected String bezZiel;
    @XmlAttribute(name = "bezZielAlt", required = true)
    protected String bezZielAlt;
    @XmlAttribute(name = "bezAnbBhfAn", required = true)
    protected String bezAnbBhfAn;

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
     * Ruft den Wert der bezAbgangAlt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBezAbgangAlt() {
        return bezAbgangAlt;
    }

    /**
     * Legt den Wert der bezAbgangAlt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBezAbgangAlt(String value) {
        this.bezAbgangAlt = value;
    }

    /**
     * Ruft den Wert der bezAnbBhfAb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBezAnbBhfAb() {
        return bezAnbBhfAb;
    }

    /**
     * Legt den Wert der bezAnbBhfAb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBezAnbBhfAb(String value) {
        this.bezAnbBhfAb = value;
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

    /**
     * Ruft den Wert der bezZielAlt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBezZielAlt() {
        return bezZielAlt;
    }

    /**
     * Legt den Wert der bezZielAlt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBezZielAlt(String value) {
        this.bezZielAlt = value;
    }

    /**
     * Ruft den Wert der bezAnbBhfAn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBezAnbBhfAn() {
        return bezAnbBhfAn;
    }

    /**
     * Legt den Wert der bezAnbBhfAn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBezAnbBhfAn(String value) {
        this.bezAnbBhfAn = value;
    }

}
