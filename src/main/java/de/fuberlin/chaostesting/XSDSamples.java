package de.fuberlin.chaostesting;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.deutschebahn.osst.v1_0.AllgemeineAngaben;
import com.deutschebahn.osst.v1_0.AnfrageZughalt;
import com.deutschebahn.osst.v1_0.AngebotsAnfrage;
import com.deutschebahn.osst.v1_0.AngebotsAntwort;
import com.deutschebahn.osst.v1_0.ReisendenTyp;
import com.deutschebahn.osst.v1_0.Reisender;
import com.deutschebahn.osst.v1_0.VerbindungsParameter;
import com.deutschebahn.osst.v1_0.WagenKlasse;

public class XSDSamples {

	public String xsdTest() {
		AngebotsAnfrage anfrage = new AngebotsAnfrage();
		AllgemeineAngaben angaben = new AllgemeineAngaben();
		angaben.setWagenKlasse(WagenKlasse.KLASSE_2);
		anfrage.setAllgemeineAngaben(angaben);
		anfrage.setMsgVersion("1.0");

		Reisender reisender = new Reisender();
		reisender.setAlter(20);
		reisender.setTyp(ReisendenTyp.ERWACHSENER);
		anfrage.getReisende().add(reisender);

		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date = null;
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
		}

		AnfrageZughalt halt1 = new AnfrageZughalt();
		halt1.setBahnhof("8010043");
		VerbindungsParameter params = new VerbindungsParameter();
		params.setZeitpunkt(date);
		params.getHalte().add(halt1);
		anfrage.getVerbindungsParameter().add(params);

		ByteArrayOutputStream stream = new ByteArrayOutputStream();

		JAXB.marshal(anfrage, stream);

		String xml = null;
		try {
			xml = stream.toString(java.nio.charset.StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String responseStr = "";
		
		try {
			URL url = new URL("http://danni-pc:8080/osst");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Content-Type", "text/xml");
			urlConnection.setRequestProperty("Content-Length", "" + Integer.toString(xml.getBytes().length));

			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);

			DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
			wr.writeBytes(xml);
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
		
		try {
			JAXBContext context = JAXBContext.newInstance(AngebotsAntwort.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			AngebotsAntwort antwort = (AngebotsAntwort) unmarshaller.unmarshal(new StringReader(responseStr));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		String hw = "";
		hw += "<xmp>" + responseStr + "</xmp>";
		return hw;
	}

}