package de.fuberlin.chaostesting;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlValidator {

	public static boolean validate_01(String xml) {
		String parsedValue = "";
		try {
		InputSource source = new InputSource(new StringReader(xml));
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(source);
	
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		
		/*
		 * This returns the Preis of the first Angebote that matches the pattern:
		 * 	typ_e='VERBINDUNGSANGEBOT'
		 * 	@status_e='ANGEBOT_GUELTIG'
		 * 	@bezAngebot='Flexpreis'
		 * 	@fahrscheinTyp_e='NORMALFAHRSCHEIN'
		 * If none are found, the Preis will be empty.
		*/
		parsedValue = xpath.evaluate("angebotsAntwort/hrKombis/angebote"
				+ "[@typ_e='VERBINDUNGSANGEBOT' and @status_e='ANGEBOT_GUELTIG' "
				+ "and @bezAngebot='Flexpreis' and @fahrscheinTyp_e='NORMALFAHRSCHEIN']"
				+ "/@preis", document);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return (!parsedValue.equals(""));
	}
	
	public static boolean validate_02(String xml) {
		String parsedValue = "";
		try {
		InputSource source = new InputSource(new StringReader(xml));
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(source);
	
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		
		/*
		 * This returns the Bezugsangebot of the first Angebote that matches the pattern:
		 * 	typ_e='ANGEBOT_RELATIONSLOS'
		 * 	@status_e='ANGEBOT_GUELTIG'
		 * 	@angebotsKlasse_e='KLASSE_2'
		 * 	@fahrscheinTyp_e='NORMALFAHRSCHEIN'
		 * If none are found, the bezAngebot will be empty.
		*/
		
		parsedValue = xpath.evaluate("angebotsAntwort/hrKombis/angebote"
				+ "[@typ_e='ANGEBOT_RELATIONSLOS' and @status_e='ANGEBOT_GUELTIG' "
				+ "and @angebotsKlasse_e='KLASSE_2' and @fahrscheinTyp_e='NORMALFAHRSCHEIN']"
				+ "/@bezAngebot", document);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return (!parsedValue.equals(""));
	}
}
