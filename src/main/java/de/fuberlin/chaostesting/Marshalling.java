package de.fuberlin.chaostesting;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXB;

public class Marshalling {

	public static <T> T unmarshal(String xml, Class<T> type) {
		return JAXB.unmarshal(new StringReader(xml), type);
	}
	
	public static <T> String marshal(T object) {
		String s;

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		JAXB.marshal(object, stream);
		try {
			s = stream.toString(java.nio.charset.StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

		return s;
	}
	
}
