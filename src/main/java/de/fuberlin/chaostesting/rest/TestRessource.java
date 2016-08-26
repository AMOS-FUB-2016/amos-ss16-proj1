package de.fuberlin.chaostesting.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestRessource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testText() {
		return "TestText";
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
	
	@GET
	@Path("{codeVersion}-{dataVersion}-{testId}")
	@Produces(MediaType.TEXT_HTML)
	public String testValue(@PathParam("codeVersion") String codeVersion, @PathParam("dataVersion") String dataVersion, @PathParam("testId") String testId) {
		return "<html> " + "<title>" + "TEST" + "</title>"
				+ "<body><h1>" + "Test" + "</body></h1>" + 
				
				"<br>Code-Version = "+codeVersion+"<br><br>Data-Version = "+dataVersion+"<br><br>Test-Id = "+testId +
			
				"</html> ";
		//TextPlain
		//return "Code-Version="+codeVersion+" Data-Version="+dataVersion+" Test-Id="+testId;
	}

	@GET
	@Path("{testID}")
	@Produces(MediaType.TEXT_XML)
	public TestObject getTest (@PathParam("testId") String testId) {
		return new TestObject(testId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String testJSON() {
		return "Test";
	}
}
