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
 * Das Element AllgemeineAngaben enth�lt zentrale Parameter, die die Angebotserstellung steuern.
 * Auch wenn alle optionalen Anteile fehlen, muss dieses Element angegeben werden.
 * 
 * <p>Java-Klasse f�r AllgemeineAngaben complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AllgemeineAngaben">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="wagenKlasse_e" type="{}WagenKlasse" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllgemeineAngaben", propOrder = {

})
public class AllgemeineAngaben {

    @XmlAttribute(name = "wagenKlasse_e")
    protected WagenKlasse wagenKlasseE;

    /**
     * Ruft den Wert der wagenKlasseE-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WagenKlasse }
     *     
     */
    public WagenKlasse getWagenKlasseE() {
        return wagenKlasseE;
    }

    /**
     * Legt den Wert der wagenKlasseE-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WagenKlasse }
     *     
     */
    public void setWagenKlasseE(WagenKlasse value) {
        this.wagenKlasseE = value;
    }

}
