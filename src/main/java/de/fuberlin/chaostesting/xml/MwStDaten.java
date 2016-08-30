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
 * Hier�ber werden die Mehrwertsteuer-Informationen des Fahrscheins �bertragen. Pro MwSt-Satz wird ein Element �bertragen.
 * 
 * <p>Java-Klasse f�r MwStDaten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MwStDaten">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="mwStCode" use="required" type="{}KzMwSt" />
 *       &lt;attribute name="mwStSatz" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="preisBrutto" use="required" type="{}Preis" />
 *       &lt;attribute name="mwStBetrag" use="required" type="{}Preis" />
 *       &lt;attribute name="kzMwStDrucken" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="mwStLiteral" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MwStDaten", propOrder = {

})
public class MwStDaten {

    @XmlAttribute(name = "mwStCode", required = true)
    protected KzMwSt mwStCode;
    @XmlAttribute(name = "mwStSatz", required = true)
    protected int mwStSatz;
    @XmlAttribute(name = "preisBrutto", required = true)
    protected int preisBrutto;
    @XmlAttribute(name = "mwStBetrag", required = true)
    protected int mwStBetrag;
    @XmlAttribute(name = "kzMwStDrucken", required = true)
    protected boolean kzMwStDrucken;
    @XmlAttribute(name = "mwStLiteral", required = true)
    protected String mwStLiteral;

    /**
     * Ruft den Wert der mwStCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KzMwSt }
     *     
     */
    public KzMwSt getMwStCode() {
        return mwStCode;
    }

    /**
     * Legt den Wert der mwStCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KzMwSt }
     *     
     */
    public void setMwStCode(KzMwSt value) {
        this.mwStCode = value;
    }

    /**
     * Ruft den Wert der mwStSatz-Eigenschaft ab.
     * 
     */
    public int getMwStSatz() {
        return mwStSatz;
    }

    /**
     * Legt den Wert der mwStSatz-Eigenschaft fest.
     * 
     */
    public void setMwStSatz(int value) {
        this.mwStSatz = value;
    }

    /**
     * Ruft den Wert der preisBrutto-Eigenschaft ab.
     * 
     */
    public int getPreisBrutto() {
        return preisBrutto;
    }

    /**
     * Legt den Wert der preisBrutto-Eigenschaft fest.
     * 
     */
    public void setPreisBrutto(int value) {
        this.preisBrutto = value;
    }

    /**
     * Ruft den Wert der mwStBetrag-Eigenschaft ab.
     * 
     */
    public int getMwStBetrag() {
        return mwStBetrag;
    }

    /**
     * Legt den Wert der mwStBetrag-Eigenschaft fest.
     * 
     */
    public void setMwStBetrag(int value) {
        this.mwStBetrag = value;
    }

    /**
     * Ruft den Wert der kzMwStDrucken-Eigenschaft ab.
     * 
     */
    public boolean isKzMwStDrucken() {
        return kzMwStDrucken;
    }

    /**
     * Legt den Wert der kzMwStDrucken-Eigenschaft fest.
     * 
     */
    public void setKzMwStDrucken(boolean value) {
        this.kzMwStDrucken = value;
    }

    /**
     * Ruft den Wert der mwStLiteral-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMwStLiteral() {
        return mwStLiteral;
    }

    /**
     * Legt den Wert der mwStLiteral-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMwStLiteral(String value) {
        this.mwStLiteral = value;
    }

}
