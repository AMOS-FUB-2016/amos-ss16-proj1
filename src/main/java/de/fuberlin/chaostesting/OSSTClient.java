package de.fuberlin.chaostesting;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXB;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.deutschebahn.osst.v1_0.AllgemeineAngaben;
import com.deutschebahn.osst.v1_0.AnfrageZughalt;
import com.deutschebahn.osst.v1_0.AngebotsAnfrage;
import com.deutschebahn.osst.v1_0.ReisendenTyp;
import com.deutschebahn.osst.v1_0.Reisender;
import com.deutschebahn.osst.v1_0.VerbindungsParameter;
import com.deutschebahn.osst.v1_0.WagenKlasse;

import de.fuberlin.chaostesting.model.Response;
import de.fuberlin.chaostesting.model.Test;

public class OSSTClient {

	public Response executeTest(Test test) throws IOException {
		AngebotsAnfrage anfrage;
		anfrage = convertTest(test);
		String testXml = marshalAnfrage(anfrage);	
		String responseStr;
		responseStr = executeHttpRequest(testXml, "http://localhost:8082/osst");

		Response response = new Response(); 
		response.setTimestamp(new Date());	
		response.setXml(responseStr);

		return response;
	}


	private static String marshalAnfrage(AngebotsAnfrage anfrage) {
		String s;

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		JAXB.marshal(anfrage, stream);
		try {
			s = stream.toString(java.nio.charset.StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

		return s;
	}

	private static AngebotsAnfrage convertTest(Test test)  {
		AngebotsAnfrage anfrage = new AngebotsAnfrage();
		anfrage.setMsgVersion(test.getMsgVersion());
		AllgemeineAngaben allgemeineAngaben = new AllgemeineAngaben();
		allgemeineAngaben.setWagenKlasseE(WagenKlasse.valueOf(test.getKlasse()));
		anfrage.setAllgemeineAngaben(allgemeineAngaben);

		VerbindungsParameter parameter = new VerbindungsParameter();
		AnfrageZughalt halt1 = new AnfrageZughalt();
		halt1.setBahnhof(test.getVon().toString());
		AnfrageZughalt halt2 = new AnfrageZughalt();
		halt2.setBahnhof(test.getNach().toString());
		parameter.getHalt().add(halt1);
		parameter.getHalt().add(halt2);

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(test.getZeitpunkt());


		DatatypeFactory factory;
		try {
			factory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}

		XMLGregorianCalendar calendar = factory.newXMLGregorianCalendar(gc);
		parameter.setZeitpunkt(calendar);

		anfrage.getVerbindungsParameter().add(parameter);
		Reisender reisender = new Reisender();
		reisender.setAnzahl(test.getErwachsene());
		reisender.setTypE(ReisendenTyp.ERWACHSENER);
		anfrage.getReisender().add(reisender);

		return anfrage;
	}

	private String executeHttpRequest(String testXml, String url) throws IOException  {
		String responseStr;
		URL _url = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) _url.openConnection();
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

		// Hack to force HttpURLConnection to run the request
		// Otherwise getErrorStream always returns null
		urlConnection.getResponseCode();
		InputStream is = urlConnection.getErrorStream();
		if (is == null) {
			is = urlConnection.getInputStream();
		}
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer responseBuf = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			responseBuf.append(line);
			responseBuf.append('\r');
		}
		rd.close();
		responseStr = responseBuf.toString();

		return responseStr;
	}

}
