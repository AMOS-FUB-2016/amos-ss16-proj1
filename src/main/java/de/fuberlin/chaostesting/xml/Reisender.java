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
 * Anzahl und Eigenschaften der Reisenden.
 * In der Anfrage muss mindestens ein Reisender angegeben werden.
 * Mehrere Reisende mit denselben Parametern k�nnen in einem Element �bertragen werden.
 * In der Antwort werden hier die f�r das Angebot verwendeten Reisenden �bertragen. W�hrend der Angebotserstellung kann es zu �nderungen kommen, weil z.B. ein Kind f�r einen Tarifgeber schon als Erwachsener z�hlt. Auch die Erm��igungen k�nnen ge�ndert worden sein. Nur die angewandten Erm��igungen werden hier zur�ckgegeben.
 * 
 * <p>Java-Klasse f�r Reisender complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Reisender">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="alter" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="anzahl" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ermaessigung" type="{}Ermaessigung" />
 *       &lt;attribute name="typ_e" use="required" type="{}ReisendenTyp" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reisender", propOrder = {

})
public class Reisender {

    @XmlAttribute(name = "alter")
    protected Integer alter;
    @XmlAttribute(name = "anzahl")
    protected Integer anzahl;
    @XmlAttribute(name = "ermaessigung")
    protected Ermaessigung ermaessigung;
    @XmlAttribute(name = "typ_e", required = true)
    protected ReisendenTyp typE;

    /**
     * Ruft den Wert der alter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAlter() {
        return alter;
    }

    /**
     * Legt den Wert der alter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAlter(Integer value) {
        this.alter = value;
    }

    /**
     * Ruft den Wert der anzahl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAnzahl() {
        return anzahl;
    }

    /**
     * Legt den Wert der anzahl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAnzahl(Integer value) {
        this.anzahl = value;
    }

    /**
     * Ruft den Wert der ermaessigung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Ermaessigung }
     *     
     */
    public Ermaessigung getErmaessigung() {
        return ermaessigung;
    }

    /**
     * Legt den Wert der ermaessigung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Ermaessigung }
     *     
     */
    public void setErmaessigung(Ermaessigung value) {
        this.ermaessigung = value;
    }

    /**
     * Ruft den Wert der typE-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReisendenTyp }
     *     
     */
    public ReisendenTyp getTypE() {
        return typE;
    }

    /**
     * Legt den Wert der typE-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReisendenTyp }
     *     
     */
    public void setTypE(ReisendenTyp value) {
        this.typE = value;
    }

}
