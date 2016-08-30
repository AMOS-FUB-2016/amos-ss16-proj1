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
 * Ein Halt beschreibt einen Bahnhof, an dem das Verkehrsmittel h�lt.
 * 
 * <p>Java-Klasse f�r Halt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Halt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="ebhfNr" use="required" type="{}EbhfNr" />
 *       &lt;attribute name="flAbZeitGueltig" type="{}ZeitGueltigkeit" />
 *       &lt;attribute name="flAnZeitGueltig" type="{}ZeitGueltigkeit" />
 *       &lt;attribute name="flAusstiegGesperrt" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="flEinstiegGesperrt" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="flGrenzuebergang" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="flRichtungsangabe" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="gleisAbfahrt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="gleisAnkunft" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="zeitAbfahrt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="zeitAnkunft" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Halt", propOrder = {

})
public class Halt {

    @XmlAttribute(name = "ebhfNr", required = true)
    protected String ebhfNr;
    @XmlAttribute(name = "flAbZeitGueltig")
    protected ZeitGueltigkeit flAbZeitGueltig;
    @XmlAttribute(name = "flAnZeitGueltig")
    protected ZeitGueltigkeit flAnZeitGueltig;
    @XmlAttribute(name = "flAusstiegGesperrt")
    protected Boolean flAusstiegGesperrt;
    @XmlAttribute(name = "flEinstiegGesperrt")
    protected Boolean flEinstiegGesperrt;
    @XmlAttribute(name = "flGrenzuebergang")
    protected Boolean flGrenzuebergang;
    @XmlAttribute(name = "flRichtungsangabe")
    protected Boolean flRichtungsangabe;
    @XmlAttribute(name = "gleisAbfahrt")
    protected String gleisAbfahrt;
    @XmlAttribute(name = "gleisAnkunft")
    protected String gleisAnkunft;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "zeitAbfahrt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar zeitAbfahrt;
    @XmlAttribute(name = "zeitAnkunft")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar zeitAnkunft;

    /**
     * Ruft den Wert der ebhfNr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEbhfNr() {
        return ebhfNr;
    }

    /**
     * Legt den Wert der ebhfNr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEbhfNr(String value) {
        this.ebhfNr = value;
    }

    /**
     * Ruft den Wert der flAbZeitGueltig-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ZeitGueltigkeit }
     *     
     */
    public ZeitGueltigkeit getFlAbZeitGueltig() {
        return flAbZeitGueltig;
    }

    /**
     * Legt den Wert der flAbZeitGueltig-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ZeitGueltigkeit }
     *     
     */
    public void setFlAbZeitGueltig(ZeitGueltigkeit value) {
        this.flAbZeitGueltig = value;
    }

    /**
     * Ruft den Wert der flAnZeitGueltig-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ZeitGueltigkeit }
     *     
     */
    public ZeitGueltigkeit getFlAnZeitGueltig() {
        return flAnZeitGueltig;
    }

    /**
     * Legt den Wert der flAnZeitGueltig-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ZeitGueltigkeit }
     *     
     */
    public void setFlAnZeitGueltig(ZeitGueltigkeit value) {
        this.flAnZeitGueltig = value;
    }

    /**
     * Ruft den Wert der flAusstiegGesperrt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlAusstiegGesperrt() {
        return flAusstiegGesperrt;
    }

    /**
     * Legt den Wert der flAusstiegGesperrt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlAusstiegGesperrt(Boolean value) {
        this.flAusstiegGesperrt = value;
    }

    /**
     * Ruft den Wert der flEinstiegGesperrt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlEinstiegGesperrt() {
        return flEinstiegGesperrt;
    }

    /**
     * Legt den Wert der flEinstiegGesperrt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlEinstiegGesperrt(Boolean value) {
        this.flEinstiegGesperrt = value;
    }

    /**
     * Ruft den Wert der flGrenzuebergang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlGrenzuebergang() {
        return flGrenzuebergang;
    }

    /**
     * Legt den Wert der flGrenzuebergang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlGrenzuebergang(Boolean value) {
        this.flGrenzuebergang = value;
    }

    /**
     * Ruft den Wert der flRichtungsangabe-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlRichtungsangabe() {
        return flRichtungsangabe;
    }

    /**
     * Legt den Wert der flRichtungsangabe-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlRichtungsangabe(Boolean value) {
        this.flRichtungsangabe = value;
    }

    /**
     * Ruft den Wert der gleisAbfahrt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGleisAbfahrt() {
        return gleisAbfahrt;
    }

    /**
     * Legt den Wert der gleisAbfahrt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGleisAbfahrt(String value) {
        this.gleisAbfahrt = value;
    }

    /**
     * Ruft den Wert der gleisAnkunft-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGleisAnkunft() {
        return gleisAnkunft;
    }

    /**
     * Legt den Wert der gleisAnkunft-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGleisAnkunft(String value) {
        this.gleisAnkunft = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der zeitAbfahrt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZeitAbfahrt() {
        return zeitAbfahrt;
    }

    /**
     * Legt den Wert der zeitAbfahrt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZeitAbfahrt(XMLGregorianCalendar value) {
        this.zeitAbfahrt = value;
    }

    /**
     * Ruft den Wert der zeitAnkunft-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZeitAnkunft() {
        return zeitAnkunft;
    }

    /**
     * Legt den Wert der zeitAnkunft-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZeitAnkunft(XMLGregorianCalendar value) {
        this.zeitAnkunft = value;
    }

}
