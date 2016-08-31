package de.fuberlin.chaostesting;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Response;
import de.fuberlin.chaostesting.model.Test;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.SimpleError;

@UrlBinding("/executeTest.action")
public class ExecuteTestAction extends GenericActionBean {
	
	Test test;
	String response;
	int id = -1;
	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
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
		
		test = new DAO<>(Test.class).findById(getId());
	    
	    if(test == null) {
	    	context.getValidationErrors().add("noTestFound", new SimpleError("Kein Test gefunden für " + getId(), (Object)null));
	    }
	}
	
	@DefaultHandler
	public Resolution executeTest() {
		String testXml = test.toXML();
		
		String responseStr = "Keine Antwort erhalten";
		try {
			URL url = new URL("http://localhost:8082/osst");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Content-Type", "text/xml");
			urlConnection.setRequestProperty("Content-Length", "" + Integer.toString(testXml.getBytes().length));
			urlConnection.setRequestProperty("SSL_CLIENT_S_DN_CN", "IAT_FV_J_AUSLAND_J");

			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);

			DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
			wr.writeBytes(testXml);
			wr.flush();
			wr.close();

			// Get Response
			InputStream is = urlConnection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			responseStr = response.toString();
			
			Response persistentResponse = new Response();
			persistentResponse.setId(getId());
			persistentResponse.setXml(responseStr);
			persistentResponse.setValid(validate(responseStr));
			new DAO<>(Response.class).create(persistentResponse);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.response = responseStr;
		
		return new ForwardResolution("/executeTest.jsp");
	}
	
	private boolean validate(String xml){
		return xml.contains("<angebote typ_e=\"VERBINDUNGSANGEBOT\" status_e=\"ANGEBOT_GUELTIG\" bezAngebot=\"Flexpreis\" fahrscheinTyp_e=\"NORMALFAHRSCHEIN\">");
	}
}
