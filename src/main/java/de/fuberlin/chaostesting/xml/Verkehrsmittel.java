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
 * Ein Verkehrsmittel transportiert den Reisenden zwischen zwei Umstiegen.
 * 
 * <p>Java-Klasse f�r Verkehrsmittel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Verkehrsmittel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="halt" type="{}Halt" maxOccurs="unbounded"/>
 *         &lt;element name="attribute" type="{}VerkehrsmittelAttribut" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="zugGattung" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="zugNummer" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ankunftKeinUmstieg" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Verkehrsmittel", propOrder = {
    "halt",
    "attribute"
})
public class Verkehrsmittel {

    @XmlElement(required = true)
    protected List<Halt> halt;
    protected List<VerkehrsmittelAttribut> attribute;
    @XmlAttribute(name = "zugGattung", required = true)
    protected String zugGattung;
    @XmlAttribute(name = "zugNummer", required = true)
    protected String zugNummer;
    @XmlAttribute(name = "ankunftKeinUmstieg")
    protected Boolean ankunftKeinUmstieg;

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
     * {@link Halt }
     * 
     * 
     */
    public List<Halt> getHalt() {
        if (halt == null) {
            halt = new ArrayList<Halt>();
        }
        return this.halt;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VerkehrsmittelAttribut }
     * 
     * 
     */
    public List<VerkehrsmittelAttribut> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<VerkehrsmittelAttribut>();
        }
        return this.attribute;
    }

    /**
     * Ruft den Wert der zugGattung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZugGattung() {
        return zugGattung;
    }

    /**
     * Legt den Wert der zugGattung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZugGattung(String value) {
        this.zugGattung = value;
    }

    /**
     * Ruft den Wert der zugNummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZugNummer() {
        return zugNummer;
    }

    /**
     * Legt den Wert der zugNummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZugNummer(String value) {
        this.zugNummer = value;
    }

    /**
     * Ruft den Wert der ankunftKeinUmstieg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnkunftKeinUmstieg() {
        return ankunftKeinUmstieg;
    }

    /**
     * Legt den Wert der ankunftKeinUmstieg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnkunftKeinUmstieg(Boolean value) {
        this.ankunftKeinUmstieg = value;
    }

}
