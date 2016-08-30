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
 * Eine Verbindung beschreibt den vollst�ndigen Weg vom Abgang bis zum Ziel mit allen Verkehrsmitteln, Halten und Gleisangaben.
 * Ob es sich um eine Hin- oder R�ckfahrt handelt, wird �ber die Hin-R�ck-Kombination vermittelt.
 * 
 * <p>Java-Klasse f�r Verbindung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Verbindung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="verkehrsmittel" type="{}Verkehrsmittel" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dauer" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="verkehrsTage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Verbindung", propOrder = {
    "verkehrsmittel"
})
public class Verbindung {

    @XmlElement(required = true)
    protected List<Verkehrsmittel> verkehrsmittel;
    @XmlAttribute(name = "dauer", required = true)
    protected int dauer;
    @XmlAttribute(name = "verkehrsTage")
    protected String verkehrsTage;

    /**
     * Gets the value of the verkehrsmittel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verkehrsmittel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerkehrsmittel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Verkehrsmittel }
     * 
     * 
     */
    public List<Verkehrsmittel> getVerkehrsmittel() {
        if (verkehrsmittel == null) {
            verkehrsmittel = new ArrayList<Verkehrsmittel>();
        }
        return this.verkehrsmittel;
    }

    /**
     * Ruft den Wert der dauer-Eigenschaft ab.
     * 
     */
    public int getDauer() {
        return dauer;
    }

    /**
     * Legt den Wert der dauer-Eigenschaft fest.
     * 
     */
    public void setDauer(int value) {
        this.dauer = value;
    }

    /**
     * Ruft den Wert der verkehrsTage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerkehrsTage() {
        return verkehrsTage;
    }

    /**
     * Legt den Wert der verkehrsTage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerkehrsTage(String value) {
        this.verkehrsTage = value;
    }

}
