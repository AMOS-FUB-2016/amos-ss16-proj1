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
 * Hier�ber k�nnen verschiedene Text f�r verschiedene Zwecke (typ) �bertragen werden.
 * 
 * <p>Java-Klasse f�r FahrscheinTexte complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FahrscheinTexte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="typ" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="textId" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FahrscheinTexte", propOrder = {

})
public class FahrscheinTexte {

    @XmlAttribute(name = "typ", required = true)
    protected int typ;
    @XmlAttribute(name = "text", required = true)
    protected String text;
    @XmlAttribute(name = "textId", required = true)
    protected int textId;

    /**
     * Ruft den Wert der typ-Eigenschaft ab.
     * 
     */
    public int getTyp() {
        return typ;
    }

    /**
     * Legt den Wert der typ-Eigenschaft fest.
     * 
     */
    public void setTyp(int value) {
        this.typ = value;
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

    /**
     * Ruft den Wert der textId-Eigenschaft ab.
     * 
     */
    public int getTextId() {
        return textId;
    }

    /**
     * Legt den Wert der textId-Eigenschaft fest.
     * 
     */
    public void setTextId(int value) {
        this.textId = value;
    }

}
