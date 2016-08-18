package de.fuberlin.chaostesting;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import de.fuberlin.chaostesting.hibernate.Test;

public class TestTest {
	
	private String executeId;
	
	public List<Test> getTests() {
		return Test.list();
	}

	public String getExecuteId() {
		return executeId;
	}
	public void setExecuteId(String executeId) {
		this.executeId = executeId;
	}
	
	public String executeTest() {
		int id;
		try {
			id = Integer.parseInt(executeId);
		} catch (NumberFormatException e) {
			return "ungültiger parameter";
		}
		
		Test test = Test.byId(id);
		String testXml = test.toXML();
		
		String responseStr = "keine antwort erhalten";
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
		
		return "<xmp>" + responseStr + "</xmp>";
	}
}
