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
 * Fehlerinformationen signalisieren, dass das gew�nschte Ergebnis nicht erbracht werden konnte.
 * Sie stehen dann alternativ zum erwarteten Ergebnis.
 * 
 * <p>Java-Klasse f�r FehlerInfo complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FehlerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="fehlerId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fehlerNr" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="fehlerText" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FehlerInfo", propOrder = {

})
public class FehlerInfo {

    @XmlAttribute(name = "fehlerId", required = true)
    protected String fehlerId;
    @XmlAttribute(name = "fehlerNr", required = true)
    protected int fehlerNr;
    @XmlAttribute(name = "fehlerText")
    protected String fehlerText;

    /**
     * Ruft den Wert der fehlerId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFehlerId() {
        return fehlerId;
    }

    /**
     * Legt den Wert der fehlerId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFehlerId(String value) {
        this.fehlerId = value;
    }

    /**
     * Ruft den Wert der fehlerNr-Eigenschaft ab.
     * 
     */
    public int getFehlerNr() {
        return fehlerNr;
    }

    /**
     * Legt den Wert der fehlerNr-Eigenschaft fest.
     * 
     */
    public void setFehlerNr(int value) {
        this.fehlerNr = value;
    }

    /**
     * Ruft den Wert der fehlerText-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFehlerText() {
        return fehlerText;
    }

    /**
     * Legt den Wert der fehlerText-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFehlerText(String value) {
        this.fehlerText = value;
    }

}
