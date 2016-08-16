package de.fuberlin.chaostesting;

public class Startseite {
    
    public String sayHello() {
    	String hw = new String("Chaos Testing sagt \"Hallo Welt\"!</br>");
    	
        return hw;
    }
    
    public String navTest() {
    	String nav = new String ("<a href=\"index.jsp\">Startseite</a>");
    	nav += " - <a href=\"testDefinition.jsp\">Test-Definition</a>";
    	nav += " - <a href=\"showTests.jsp\">Test-Liste</a>";
    	
        return nav;
    }
    
    public String navUser() {
    	String nav = new String ("<a href=\"newAdmin.jsp\">Test-Admin hinzufügen</a>");
    	nav += " - <a href=\"newTester.jsp\">Test-Anwender hinzufügen</a>";
    	nav += " - <a href=\"showUsers.jsp\">Nutzer-Liste</a>";
    	
        return nav;
    }
    
    public String footer() {
    	String nav = new String ("AMOS-Projekt - Testautomat - FU Berlin - 2016 - Mid-Release 4");
    	
        return nav;
    }
    
}
