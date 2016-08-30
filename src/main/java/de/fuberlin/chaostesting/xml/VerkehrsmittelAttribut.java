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
 * Verkehrsmittel-Attribute beschreiben weitere Eigenschaften des Verkehrsmittels.
 * 
 * <p>Java-Klasse f�r VerkehrsmittelAttribut complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="VerkehrsmittelAttribut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="flag" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="prio" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="subprio" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerkehrsmittelAttribut", propOrder = {

})
public class VerkehrsmittelAttribut {

    @XmlAttribute(name = "code", required = true)
    protected String code;
    @XmlAttribute(name = "flag", required = true)
    protected String flag;
    @XmlAttribute(name = "prio", required = true)
    protected int prio;
    @XmlAttribute(name = "subprio", required = true)
    protected int subprio;
    @XmlAttribute(name = "text", required = true)
    protected String text;

    /**
     * Ruft den Wert der code-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Legt den Wert der code-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Ruft den Wert der flag-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Legt den Wert der flag-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag(String value) {
        this.flag = value;
    }

    /**
     * Ruft den Wert der prio-Eigenschaft ab.
     * 
     */
    public int getPrio() {
        return prio;
    }

    /**
     * Legt den Wert der prio-Eigenschaft fest.
     * 
     */
    public void setPrio(int value) {
        this.prio = value;
    }

    /**
     * Ruft den Wert der subprio-Eigenschaft ab.
     * 
     */
    public int getSubprio() {
        return subprio;
    }

    /**
     * Legt den Wert der subprio-Eigenschaft fest.
     * 
     */
    public void setSubprio(int value) {
        this.subprio = value;
    }

    /**
     * Ruft den Wert der text-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Legt den Wert der text-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

}
