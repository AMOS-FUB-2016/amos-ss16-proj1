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
 * <p>Java-Klasse f�r ProduktKlasse.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ProduktKlasse">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HGV"/>
 *     &lt;enumeration value="IC_EC"/>
 *     &lt;enumeration value="IR_D"/>
 *     &lt;enumeration value="NV"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="BUS"/>
 *     &lt;enumeration value="SCHIFF"/>
 *     &lt;enumeration value="U"/>
 *     &lt;enumeration value="STRAB"/>
 *     &lt;enumeration value="TAXI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProduktKlasse")
@XmlEnum
public enum ProduktKlasse {

    HGV,
    IC_EC,
    IR_D,
    NV,
    S,
    BUS,
    SCHIFF,
    U,
    STRAB,
    TAXI;

    public String value() {
        return name();
    }

    public static ProduktKlasse fromValue(String v) {
        return valueOf(v);
    }

}
