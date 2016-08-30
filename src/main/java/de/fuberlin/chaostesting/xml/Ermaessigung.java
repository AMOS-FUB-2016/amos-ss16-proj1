//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.30 um 04:11:47 PM CEST 
//


package de.fuberlin.chaostesting.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r Ermaessigung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="Ermaessigung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BC25"/>
 *     &lt;enumeration value="BC50"/>
 *     &lt;enumeration value="BCB25"/>
 *     &lt;enumeration value="BCB50"/>
 *     &lt;enumeration value="BC25FIRST"/>
 *     &lt;enumeration value="BC50FIRST"/>
 *     &lt;enumeration value="BCB25FIRST"/>
 *     &lt;enumeration value="BCB50FIRST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Ermaessigung")
@XmlEnum
public enum Ermaessigung {

    @XmlEnumValue("BC25")
    BC_25("BC25"),
    @XmlEnumValue("BC50")
    BC_50("BC50"),
    @XmlEnumValue("BCB25")
    BCB_25("BCB25"),
    @XmlEnumValue("BCB50")
    BCB_50("BCB50"),
    @XmlEnumValue("BC25FIRST")
    BC_25_FIRST("BC25FIRST"),
    @XmlEnumValue("BC50FIRST")
    BC_50_FIRST("BC50FIRST"),
    @XmlEnumValue("BCB25FIRST")
    BCB_25_FIRST("BCB25FIRST"),
    @XmlEnumValue("BCB50FIRST")
    BCB_50_FIRST("BCB50FIRST");
    private final String value;

    Ermaessigung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Ermaessigung fromValue(String v) {
        for (Ermaessigung c: Ermaessigung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
