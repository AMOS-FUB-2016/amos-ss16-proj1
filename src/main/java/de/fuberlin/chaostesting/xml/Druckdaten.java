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
 * Druckdaten enthalten Angaben, die nur zum "Druck" des Fahrscheins dienen. Damit ist jedoch nicht nur der physische Druck gemeint, sondern auch alle Arten des papierlosen Fulfillments, z.B. Handy-Tickets etc.
 * Sie werden nur �bertragen, wenn das Ticket auch verkauft werden darf.
 * 
 * <p>Java-Klasse f�r Druckdaten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Druckdaten">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="texte" type="{}FahrscheinTexte" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mwStDaten" type="{}MwStDaten" maxOccurs="unbounded"/>
 *         &lt;element name="druckRichtungsDaten" type="{}DruckRichtungsdaten" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="wegetext" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="musterNr" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="gattungsBez" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fahrscheinTyp" use="required" type="{}FahrscheinTyp" />
 *       &lt;attribute name="altersbereichKinder" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Druckdaten", propOrder = {
    "texte",
    "mwStDaten",
    "druckRichtungsDaten"
})
public class Druckdaten {

    protected List<FahrscheinTexte> texte;
    @XmlElement(required = true)
    protected List<MwStDaten> mwStDaten;
    @XmlElement(required = true)
    protected List<DruckRichtungsdaten> druckRichtungsDaten;
    @XmlAttribute(name = "wegetext", required = true)
    protected String wegetext;
    @XmlAttribute(name = "musterNr", required = true)
    protected int musterNr;
    @XmlAttribute(name = "gattungsBez", required = true)
    protected String gattungsBez;
    @XmlAttribute(name = "fahrscheinTyp", required = true)
    protected FahrscheinTyp fahrscheinTyp;
    @XmlAttribute(name = "altersbereichKinder", required = true)
    protected String altersbereichKinder;

    /**
     * Gets the value of the texte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the texte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTexte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FahrscheinTexte }
     * 
     * 
     */
    public List<FahrscheinTexte> getTexte() {
        if (texte == null) {
            texte = new ArrayList<FahrscheinTexte>();
        }
        return this.texte;
    }

    /**
     * Gets the value of the mwStDaten property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mwStDaten property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMwStDaten().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MwStDaten }
     * 
     * 
     */
    public List<MwStDaten> getMwStDaten() {
        if (mwStDaten == null) {
            mwStDaten = new ArrayList<MwStDaten>();
        }
        return this.mwStDaten;
    }

    /**
     * Gets the value of the druckRichtungsDaten property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the druckRichtungsDaten property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDruckRichtungsDaten().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DruckRichtungsdaten }
     * 
     * 
     */
    public List<DruckRichtungsdaten> getDruckRichtungsDaten() {
        if (druckRichtungsDaten == null) {
            druckRichtungsDaten = new ArrayList<DruckRichtungsdaten>();
        }
        return this.druckRichtungsDaten;
    }

    /**
     * Ruft den Wert der wegetext-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWegetext() {
        return wegetext;
    }

    /**
     * Legt den Wert der wegetext-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWegetext(String value) {
        this.wegetext = value;
    }

    /**
     * Ruft den Wert der musterNr-Eigenschaft ab.
     * 
     */
    public int getMusterNr() {
        return musterNr;
    }

    /**
     * Legt den Wert der musterNr-Eigenschaft fest.
     * 
     */
    public void setMusterNr(int value) {
        this.musterNr = value;
    }

    /**
     * Ruft den Wert der gattungsBez-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGattungsBez() {
        return gattungsBez;
    }

    /**
     * Legt den Wert der gattungsBez-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGattungsBez(String value) {
        this.gattungsBez = value;
    }

    /**
     * Ruft den Wert der fahrscheinTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FahrscheinTyp }
     *     
     */
    public FahrscheinTyp getFahrscheinTyp() {
        return fahrscheinTyp;
    }

    /**
     * Legt den Wert der fahrscheinTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FahrscheinTyp }
     *     
     */
    public void setFahrscheinTyp(FahrscheinTyp value) {
        this.fahrscheinTyp = value;
    }

    /**
     * Ruft den Wert der altersbereichKinder-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAltersbereichKinder() {
        return altersbereichKinder;
    }

    /**
     * Legt den Wert der altersbereichKinder-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAltersbereichKinder(String value) {
        this.altersbereichKinder = value;
    }

}
