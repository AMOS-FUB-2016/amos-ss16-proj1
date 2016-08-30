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
 * Da �ber diese Schnittstelle Angebote sowohl f�r einfache Fahrten als auch f�r Hin/R�ck-Fahrten erstellt werden k�nnen, erfolgt der Einstieg �ber Hin-R�ck-Kombinationen von Verbindungen. Dieses Element verbindet die Verbindungen mit den dazugeh�rigen Angeboten.
 * Wurde eine einfache Fahrt angefragt, wird nur die Verbindung der Hinfahrt referenziert.
 * Wurde eine Hin-R�ckfahrt angefragt, so verweist die Hin-R�ck-Kombination nacheinander auf eine Hin- und eine R�ckfahrt. Die Angebote enthalten R�ckfahrkarten.
 * Konnte zu einer Hin-R�ck-Kombination kein Angebot erstellt werden, so wird statt der Angebote eine Fehler-Information �bertragen.
 * Bei Hin-R�ck-Fahrten werden alle gefundenen Verbindungen der Hinfahrt mit allen gefundenen Verbindungen der R�ckfahrt kombiniert, es sein denn, die R�ckfahrt beginnt vor dem Ende der Hinfahrt.
 * Die �bertragenen Hin-R�ck-Kombinationen sind jeweils nach den Abfahrtszeiten sortiert. Damit folgen die Kombinationen zu einer Hinfahrt aufeinander.
 * 
 * <p>Java-Klasse f�r HinRueckKombi complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="HinRueckKombi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="angebote" type="{}Angebot" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="verbindungen" type="{}Verbindung" maxOccurs="unbounded"/>
 *         &lt;element name="fehlerInfo" type="{}FehlerInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="komfortSortierung" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="preisSortierung" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HinRueckKombi", propOrder = {
    "angebote",
    "verbindungen",
    "fehlerInfo"
})
public class HinRueckKombi {

    protected List<Angebot> angebote;
    @XmlElement(required = true)
    protected List<Verbindung> verbindungen;
    protected FehlerInfo fehlerInfo;
    @XmlAttribute(name = "komfortSortierung", required = true)
    protected int komfortSortierung;
    @XmlAttribute(name = "preisSortierung", required = true)
    protected int preisSortierung;

    /**
     * Gets the value of the angebote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the angebote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAngebote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Angebot }
     * 
     * 
     */
    public List<Angebot> getAngebote() {
        if (angebote == null) {
            angebote = new ArrayList<Angebot>();
        }
        return this.angebote;
    }

    /**
     * Gets the value of the verbindungen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verbindungen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerbindungen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Verbindung }
     * 
     * 
     */
    public List<Verbindung> getVerbindungen() {
        if (verbindungen == null) {
            verbindungen = new ArrayList<Verbindung>();
        }
        return this.verbindungen;
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
     * Ruft den Wert der komfortSortierung-Eigenschaft ab.
     * 
     */
    public int getKomfortSortierung() {
        return komfortSortierung;
    }

    /**
     * Legt den Wert der komfortSortierung-Eigenschaft fest.
     * 
     */
    public void setKomfortSortierung(int value) {
        this.komfortSortierung = value;
    }

    /**
     * Ruft den Wert der preisSortierung-Eigenschaft ab.
     * 
     */
    public int getPreisSortierung() {
        return preisSortierung;
    }

    /**
     * Legt den Wert der preisSortierung-Eigenschaft fest.
     * 
     */
    public void setPreisSortierung(int value) {
        this.preisSortierung = value;
    }

}
