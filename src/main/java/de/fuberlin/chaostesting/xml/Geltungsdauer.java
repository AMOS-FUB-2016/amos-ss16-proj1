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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Gibt die Geltungsdauer des Angebotes f�r die jeweilige Fahrtrichtung an.
 * 
 * <p>Java-Klasse f�r Geltungsdauer complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Geltungsdauer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="gueltigAb" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="gueltigBis" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Geltungsdauer", propOrder = {

})
public class Geltungsdauer {

    @XmlAttribute(name = "gueltigAb", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar gueltigAb;
    @XmlAttribute(name = "gueltigBis", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar gueltigBis;

    /**
     * Ruft den Wert der gueltigAb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGueltigAb() {
        return gueltigAb;
    }

    /**
     * Legt den Wert der gueltigAb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGueltigAb(XMLGregorianCalendar value) {
        this.gueltigAb = value;
    }

    /**
     * Ruft den Wert der gueltigBis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGueltigBis() {
        return gueltigBis;
    }

    /**
     * Legt den Wert der gueltigBis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGueltigBis(XMLGregorianCalendar value) {
        this.gueltigBis = value;
    }

}
