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
 * VDSFelder enthalten die Positions-Angaben zu vom Dritten auszuf�llenden Feldern im VDS-String.
 * Der Name enth�lt die Feldbezeichnung laut der aktuellen Dokumentation der F�llregeln. Daran k�nnen die zun f�llenden Felder unterschieden werden.
 * �ber pos und len wird die genaue Position und die L�nge des angegebenen Feldes im VDS angegeben. Format gibt an, wie die Information zu formatieren ist.
 * 
 * <p>Java-Klasse f�r VDSFelder complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="VDSFelder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pos" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="len" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VDSFelder", propOrder = {

})
public class VDSFelder {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "pos", required = true)
    protected int pos;
    @XmlAttribute(name = "len", required = true)
    protected int len;
    @XmlAttribute(name = "format", required = true)
    protected String format;

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
     * Ruft den Wert der pos-Eigenschaft ab.
     * 
     */
    public int getPos() {
        return pos;
    }

    /**
     * Legt den Wert der pos-Eigenschaft fest.
     * 
     */
    public void setPos(int value) {
        this.pos = value;
    }

    /**
     * Ruft den Wert der len-Eigenschaft ab.
     * 
     */
    public int getLen() {
        return len;
    }

    /**
     * Legt den Wert der len-Eigenschaft fest.
     * 
     */
    public void setLen(int value) {
        this.len = value;
    }

    /**
     * Ruft den Wert der format-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Legt den Wert der format-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

}
