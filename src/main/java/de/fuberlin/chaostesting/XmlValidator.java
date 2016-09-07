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

import de.fuberlin.chaostesting.model.Response;
import de.fuberlin.chaostesting.model.Test;

public class XmlValidator {
	
	public static void validate(Test test, Response response) {
		String xml = Marshalling.marshal(response);
		
		try {
			response.setValid_01(validate_01(xml, test.getKlasse()));
			response.setValid_02(validate_02(xml));
			response.setValid_02a(validate_02a(xml, test.getExpectedBezAngebot().toString()));
			if (response.isValid_01() || response.isValid_02()){
				response.setValid_03a(validate_03a(xml));
				response.setValid_03b(validate_03b(xml, test.getExpectedPreis()));
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return;
	}

	static boolean validate_01(String xml, String klasse) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {
		Document document = createDocument(xml);
		XPath xpath = createXPath();
		
		/*
		 * This returns the Preis of the first Angebote that matches the pattern:
		 * 	typ_e='VERBINDUNGSANGEBOT'
		 * 	@status_e='ANGEBOT_GUELTIG'
		 * 	@bezAngebot='Flexpreis'
		 * 	@fahrscheinTyp_e='NORMALFAHRSCHEIN'
		 *	@angebotsKlasse_e= given Klasse in Test
		 * If none are found, the Preis will be empty, meaning the validation failed.
		*/
		String result = xpath.evaluate("response/antwort/hrKombis/angebote"
				+ "[@typ_e='VERBINDUNGSANGEBOT' and @status_e='ANGEBOT_GUELTIG'"
				+ " and @bezAngebot='Flexpreis' and @fahrscheinTyp_e='NORMALFAHRSCHEIN'"
				+ " and @angebotsKlasse_e='" + klasse + "']"
				+ "/@preis", document);
		
		return (!result.equals(""));
	}
	
	static boolean validate_02(String xml) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {
		Document document = createDocument(xml);
		XPath xpath = createXPath();
		
		/*
		 * This returns the Preis of the first Angebote that matches the pattern:
		 * 	typ_e='ANGEBOT_RELATIONSLOS'
		 * 	@status_e='ANGEBOT_GUELTIG'
		 * 	@angebotsKlasse_e='KLASSE_2'
		 * 	@fahrscheinTyp_e='NORMALFAHRSCHEIN'
		 * 	@bezAngebot='QUER-DURCHS-LAND-T' or @bezAngebot='Schönes-Wochenende-T'
		 * If none are found, the Preis will be empty, meaning the validation failed.
		*/		
		String result = xpath.evaluate("response/antwort/hrKombis/angebote"
				+ "[@typ_e='ANGEBOT_RELATIONSLOS' and @status_e='ANGEBOT_GUELTIG'"
				+ " and @angebotsKlasse_e='KLASSE_2' and @fahrscheinTyp_e='NORMALFAHRSCHEIN'"
				+ " and (@bezAngebot='QUER-DURCHS-LAND-T' or @bezAngebot='Schönes-Wochenende-T')]"
				+ "/@preis", document);
		
		return (!result.equals(""));
	}
	
    static boolean validate_02a(String xml, String bezAngebot) throws ParserConfigurationException,
    		SAXException, IOException, XPathExpressionException {
        String result = "";

        Document document = createDocument(xml);
        XPath xpath = createXPath();
            
        result = xpath.evaluate("angebotsAntwort/hrKombis/angebote"
                + "[@typ_e='ANGEBOT_RELATIONSLOS' and @status_e='ANGEBOT_GUELTIG' "
                + "and @angebotsKlasse_e='KLASSE_2' and @fahrscheinTyp_e='NORMALFAHRSCHEIN']"
                + "/@bezAngebot", document);
        
        return (!result.equals(bezAngebot));        
    }
    
    static boolean validate_03a(String xml) throws ParserConfigurationException,
    		SAXException, IOException, XPathExpressionException {
        String result = "";
        String fahrschein = "";
        int laenge = 0;
        Document document = createDocument(xml);
        XPath xpath = createXPath();
        
        fahrschein = xpath.evaluate("angebotsAntwort/hrKombis/angebot"
                + "/@fahrschein", document);
        if (fahrschein != "") {
    		laenge = Integer.parseInt(fahrschein);
        }
        if (laenge == 1){
        	result = xpath.evaluate("angebotsAntwort/hrKombis/angebot"
                    + "[@typ_e='ANGEBOT_RELATIONSLOS' and @status_e='ANGEBOT_GUELTIG' "
                    + "and @angebotsKlasse_e='KLASSE_2' and @fahrscheinTyp_e='NORMALFAHRSCHEIN']"
                    + "/@bezAngebot", document);
        }
        
        return (!result.equals(""));        
    }
	
    public static boolean validate_03b(String xml, Integer preis) throws ParserConfigurationException,
    		SAXException, IOException, XPathExpressionException {
        String result = "";
        String fahrschein = "";
        int laenge = 0;

        Document document = createDocument(xml);
        XPath xpath = createXPath();
        
        fahrschein = xpath.evaluate("angebotsAntwort/hrKombis/angebot"
                + "/@fahrschein", document);
        if (fahrschein != "") {
        		laenge = Integer.parseInt(fahrschein);
        }
        if (laenge > 1){
        	result = xpath.evaluate("angebotsAntwort/hrKombis/angebot/fahrschein"
        		+ "/@preis", document);
        }
        
        return (!result.equals(preis.toString()));        
    }
    
	static Document createDocument(String xml) throws ParserConfigurationException, SAXException, IOException {
		InputSource source = new InputSource(new StringReader(xml));
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		return db.parse(source);
	}
	
	static XPath createXPath() {
		XPathFactory xpathFactory = XPathFactory.newInstance();
		
		return xpathFactory.newXPath();
	}
}
