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
 * <p>Java-Klasse f�r AngebotsStatus.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="AngebotsStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ANGEBOT_GUELTIG"/>
 *     &lt;enumeration value="OEPNVFAHRAUSWEIS"/>
 *     &lt;enumeration value="VERBUNDFAHRAUSWEIS"/>
 *     &lt;enumeration value="TEILPREISANGEBOT"/>
 *     &lt;enumeration value="GLOBALPREIS"/>
 *     &lt;enumeration value="KEIN_ZUGBINDUNGSTEXT"/>
 *     &lt;enumeration value="NESEEANTEIL_UNBEPREISBAR"/>
 *     &lt;enumeration value="TARIFKOMBI_UNGUELTIG"/>
 *     &lt;enumeration value="VBVERGANGENHEIT"/>
 *     &lt;enumeration value="UNTERSCHIED_ABGANG_ZIEL"/>
 *     &lt;enumeration value="TICKET_TEILEN"/>
 *     &lt;enumeration value="FEHLER_AUS_FAHRPLANAUSKUNFT"/>
 *     &lt;enumeration value="FEHLER_AUS_PREISBERECHNUNG"/>
 *     &lt;enumeration value="ANGEBOT_UNBEPREISBAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AngebotsStatus")
@XmlEnum
public enum AngebotsStatus {

    ANGEBOT_GUELTIG,
    OEPNVFAHRAUSWEIS,
    VERBUNDFAHRAUSWEIS,
    TEILPREISANGEBOT,
    GLOBALPREIS,
    KEIN_ZUGBINDUNGSTEXT,
    NESEEANTEIL_UNBEPREISBAR,
    TARIFKOMBI_UNGUELTIG,
    VBVERGANGENHEIT,
    UNTERSCHIED_ABGANG_ZIEL,
    TICKET_TEILEN,
    FEHLER_AUS_FAHRPLANAUSKUNFT,
    FEHLER_AUS_PREISBERECHNUNG,
    ANGEBOT_UNBEPREISBAR;

    public String value() {
        return name();
    }

    public static AngebotsStatus fromValue(String v) {
        return valueOf(v);
    }

}
