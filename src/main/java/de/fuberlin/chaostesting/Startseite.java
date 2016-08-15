package de.fuberlin.chaostesting;

import de.fuberlin.chaostesting.hibernate.Test;

public class Startseite {
    
    public String sayHello() {

    	String hw = new String("Hello World from Chaos Testing!</br>");
        return hw;
    }
    
    public String navTest() {

    	String nav = new String ("<a href=\"index.jsp\">Startseite</a> - ");
    	nav += "<a href=\"testDefinition.jsp\">Test-Definition</a>";
        return nav;
    }   
    
    public String navUser() {

    	String nav = new String ("<a href=\"newAdmin.jsp\">Add Admin</a> - ");
    	nav += "<a href=\"newTester.jsp\">Add Tester</a> - ";
    	nav += "<a href=\"showUsers.jsp\">Show Users</a>";
        return nav;
    }
    
    public String footer() {

    	String nav = new String ("AMOS-Projekt - Testautomat - FU Berlin - 2016 - Mid-Release 4");
    	
        return nav;
    }
    
}