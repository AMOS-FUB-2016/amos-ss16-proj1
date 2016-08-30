//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.30 um 04:11:47 PM CEST 
//


package de.fuberlin.chaostesting.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Das ist die Basis der XML-Konvertierung. Es definiert die Namen aller m�glichen Nachrichten-Typen. Jedes hier referenzierte Element ist ein m�gliches Root-Element der XML-Nachricht.
 * 
 * <p>Java-Klasse f�r OnlineInterface complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OnlineInterface">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="angebotsAntwort" type="{}AngebotsAntwort" minOccurs="0"/>
 *         &lt;element name="fehlerInfo" type="{}FehlerInfo" minOccurs="0"/>
 *         &lt;element name="angebotsAnfrage" type="{}AngebotsAnfrage" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OnlineInterface", propOrder = {

})
public class OnlineInterface {

    protected AngebotsAntwort angebotsAntwort;
    protected FehlerInfo fehlerInfo;
    protected AngebotsAnfrage angebotsAnfrage;

    /**
     * Ruft den Wert der angebotsAntwort-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AngebotsAntwort }
     *     
     */
    public AngebotsAntwort getAngebotsAntwort() {
        return angebotsAntwort;
    }

    /**
     * Legt den Wert der angebotsAntwort-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AngebotsAntwort }
     *     
     */
    public void setAngebotsAntwort(AngebotsAntwort value) {
        this.angebotsAntwort = value;
    }

    /**
     * Ruft den Wert der fehlerInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FehlerInfo }
     *     
     */
    public FehlerInfo getFehlerInfo() {
        return fehlerInfo;
    }

    /**
     * Legt den Wert der fehlerInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FehlerInfo }
     *     
     */
    public void setFehlerInfo(FehlerInfo value) {
        this.fehlerInfo = value;
    }

    /**
     * Ruft den Wert der angebotsAnfrage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AngebotsAnfrage }
     *     
     */
    public AngebotsAnfrage getAngebotsAnfrage() {
        return angebotsAnfrage;
    }

    /**
     * Legt den Wert der angebotsAnfrage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AngebotsAnfrage }
     *     
     */
    public void setAngebotsAnfrage(AngebotsAnfrage value) {
        this.angebotsAnfrage = value;
    }

}
