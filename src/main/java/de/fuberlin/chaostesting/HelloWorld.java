package de.fuberlin.chaostesting;

public class HelloWorld {
    
    public String sayHello() {
    	String hw = "Hello World from Chaos Testing!</br>";
    	hw += "<a href=\"newAdmin.jsp\">Add Admin</a></br>";
    	hw += "<a href=\"newTester.jsp\">Add Tester</a></br>";
    	hw += "<a href=\"showUsers.jsp\">Show Users</a>";
        return hw;
    }
    
}