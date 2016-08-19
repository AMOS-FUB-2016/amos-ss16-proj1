package de.fuberlin.chaostesting;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import de.fuberlin.chaostesting.hibernate.Test;
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

	@Before(stages = LifecycleStage.BindingAndValidation)
	public void rehydrate() {
		int id = -1;
		try {
			id = Integer.parseInt(context.getRequest().getParameter("id"));
		} catch(NumberFormatException e) {
			context.getValidationErrors().add("illegalParameter", new SimpleError("Illegaler Request-Parameter", (Object)null));
			return;
		}
		
	    test = Test.byId(id);
	    
	    if(test == null) {
	    	context.getValidationErrors().add("noTestFound", new SimpleError("Kein Test gefunden für " + id, (Object)null));
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
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.response = responseStr;
		
		return new ForwardResolution("/executeTest.jsp");
	}
}
