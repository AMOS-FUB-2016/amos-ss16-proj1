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
 * Zu jeder Verbindung k�nnen spezielle Verkehrsmittel von der Suche ausgenommen werden.  Sie werden in Produktklassen zusammengefasst.
 * Optional. Default ist die Suche ohne Einschr�nkungen.
 * Die Liste der ausschlie�baren ProduktKlassen ist bei den Enumerationen aufgef�hrt.
 * 
 * <p>Java-Klasse f�r ProduktKlassen complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ProduktKlassen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="code" use="required" type="{}ProduktKlasse" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProduktKlassen", propOrder = {

})
public class ProduktKlassen {

    @XmlAttribute(name = "code", required = true)
    protected ProduktKlasse code;

    /**
     * Ruft den Wert der code-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProduktKlasse }
     *     
     */
    public ProduktKlasse getCode() {
        return code;
    }

    /**
     * Legt den Wert der code-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProduktKlasse }
     *     
     */
    public void setCode(ProduktKlasse value) {
        this.code = value;
    }

}
