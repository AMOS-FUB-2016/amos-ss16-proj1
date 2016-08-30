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
 * AnfrageZughalte beschreiben die Eckpunkte der gew�nschten Verbindung. Sie werden in der angegebenen Reihenfolge durchfahren. Der erste Halt kennzeichnet den Abfahrtsbahnhof und der letzte Halt den Zielbahnhof.
 * Dazwischen k�nnen bis zu zwei Bahnh�fe angegeben werden, �ber die die Verbindung gef�hrt werden soll.
 * Es ist zu beachten, dass Stichstrecken und Rundfahrten unzul�ssig sind und daf�r keine Angebote erstellt werden.
 * 
 * <p>Java-Klasse f�r AnfrageZughalt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AnfrageZughalt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="bahnhof" use="required" type="{}EbhfNr" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnfrageZughalt", propOrder = {

})
public class AnfrageZughalt {

    @XmlAttribute(name = "bahnhof", required = true)
    protected String bahnhof;

    /**
     * Ruft den Wert der bahnhof-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBahnhof() {
        return bahnhof;
    }

    /**
     * Legt den Wert der bahnhof-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBahnhof(String value) {
        this.bahnhof = value;
    }

}
