//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.30 um 04:11:47 PM CEST 
//


package de.fuberlin.chaostesting.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r RichtungsInfo.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="RichtungsInfo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KUNDENWUNSCH"/>
 *     &lt;enumeration value="NUR_HINFAHRT"/>
 *     &lt;enumeration value="NUR_RUECKFAHRT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RichtungsInfo")
@XmlEnum
public enum RichtungsInfo {

    KUNDENWUNSCH,
    NUR_HINFAHRT,
    NUR_RUECKFAHRT;

    public String value() {
        return name();
    }

    public static RichtungsInfo fromValue(String v) {
        return valueOf(v);
    }

}
