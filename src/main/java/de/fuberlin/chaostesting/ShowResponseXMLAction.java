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

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Response;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.SimpleError;

@UrlBinding("/showResponseXML.action")
public class ShowResponseXMLAction extends GenericActionBean {
	
	Response response;
	String result;
	int id = -1;
	
	DAO<Response> responseDao = DAO.createInstance(Response.class);

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Before(stages = LifecycleStage.BindingAndValidation)
	public void rehydrate() {
		try {
			setId(Integer.parseInt(context.getRequest().getParameter("id")));
		} catch(NumberFormatException e) {
			context.getValidationErrors().add("illegalParameter", new SimpleError("Illegaler Request-Parameter", (Object)null));
			return;
		}
		
		response = responseDao.findById(getId());
	    
	    if(response == null) {
	    	context.getValidationErrors().add("noResponseFound", new SimpleError("Keine Antwort gefunden für " + getId(), (Object)null));
	    }
	}
	
	@DefaultHandler
	public Resolution showXML() {
		setResult(Marshalling.marshal(response));
		
		return new ForwardResolution("/showResponseXML.jsp");
	}
	
	@HandlesEvent("serverVersion")
	public Resolution showServerVersion() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		String xml = Marshalling.marshal(response);

		InputSource source = new InputSource(new StringReader(xml));

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(source);

		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		
		setResult(xpath.evaluate("/angebotsAntwort/@serverVersion", document));
		
		return new ForwardResolution("/showServerVersion.jsp");
	}
}
