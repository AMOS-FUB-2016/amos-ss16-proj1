package de.fuberlin.chaostesting.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/test")
public class TestRessource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testText() {
		return "Test";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String testXML() {
		return "<?xml version=\"1.0\"?>" + "<test> Test" + "</test>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String testHTML() {
		return "<html> " + "<title>" + "TEST" + "</title>"
				+ "<body><h1>" + "Test" + "</body></h1>" + "</html> ";
	}
}
