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
 * Die Ausfertigungsdaten enthalten alle Informationen, die ausschlie�lich zum Verkaufen des Angebotes ben�tigt werden.
 * Sie werden nur �bertragen, wenn das Ticket auch verkauft werden darf.
 * 
 * <p>Java-Klasse f�r Ausfertigungsdaten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Ausfertigungsdaten">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vdsDaten" type="{}VDSFelder" maxOccurs="unbounded"/>
 *         &lt;element name="druckDaten" type="{}Druckdaten"/>
 *       &lt;/sequence>
 *       &lt;attribute name="vds" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ausfertigungsdaten", propOrder = {
    "vdsDaten",
    "druckDaten"
})
public class Ausfertigungsdaten {

    @XmlElement(required = true)
    protected List<VDSFelder> vdsDaten;
    @XmlElement(required = true)
    protected Druckdaten druckDaten;
    @XmlAttribute(name = "vds", required = true)
    protected String vds;

    /**
     * Gets the value of the vdsDaten property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vdsDaten property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVdsDaten().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VDSFelder }
     * 
     * 
     */
    public List<VDSFelder> getVdsDaten() {
        if (vdsDaten == null) {
            vdsDaten = new ArrayList<VDSFelder>();
        }
        return this.vdsDaten;
    }

    /**
     * Ruft den Wert der druckDaten-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Druckdaten }
     *     
     */
    public Druckdaten getDruckDaten() {
        return druckDaten;
    }

    /**
     * Legt den Wert der druckDaten-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Druckdaten }
     *     
     */
    public void setDruckDaten(Druckdaten value) {
        this.druckDaten = value;
    }

    /**
     * Ruft den Wert der vds-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVds() {
        return vds;
    }

    /**
     * Legt den Wert der vds-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVds(String value) {
        this.vds = value;
    }

}
