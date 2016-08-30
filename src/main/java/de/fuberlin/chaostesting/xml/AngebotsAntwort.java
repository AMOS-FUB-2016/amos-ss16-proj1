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
import javax.xml.bind.annotation.XmlType;


/**
 * Dieses Element enth�lt alle Angaben zu einer Angebots-Antwort.
 * Dazu geh�ren die gefundenen Verbindungen sowie die daraus gebildeten Hin-R�ck-Kombinationen, denen wiederum die Angebote zugeordnet sind.
 * 
 * <p>Java-Klasse f�r AngebotsAntwort complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AngebotsAntwort">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fehlerInfo" type="{}FehlerInfo" minOccurs="0"/>
 *         &lt;element name="verbindungen" type="{}Verbindung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hrKombis" type="{}HinRueckKombi" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="msgVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="serverVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AngebotsAntwort", propOrder = {
    "fehlerInfo",
    "verbindungen",
    "hrKombis"
})
public class AngebotsAntwort {

    protected FehlerInfo fehlerInfo;
    protected List<Verbindung> verbindungen;
    protected List<HinRueckKombi> hrKombis;
    @XmlAttribute(name = "msgVersion", required = true)
    protected String msgVersion;
    @XmlAttribute(name = "serverVersion", required = true)
    protected String serverVersion;

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
     * Gets the value of the hrKombis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hrKombis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHrKombis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HinRueckKombi }
     * 
     * 
     */
    public List<HinRueckKombi> getHrKombis() {
        if (hrKombis == null) {
            hrKombis = new ArrayList<HinRueckKombi>();
        }
        return this.hrKombis;
    }

    /**
     * Ruft den Wert der msgVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgVersion() {
        return msgVersion;
    }

    /**
     * Legt den Wert der msgVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgVersion(String value) {
        this.msgVersion = value;
    }

    /**
     * Ruft den Wert der serverVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerVersion() {
        return serverVersion;
    }

    /**
     * Legt den Wert der serverVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerVersion(String value) {
        this.serverVersion = value;
    }

}
