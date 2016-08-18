package de.fuberlin.chaostesting.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fuberlin.chaostesting.hibernate.Test;

public class Definition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String von = "";
	String nach = "";
	String hinfahrt = "";
	String reisende = "";
	String klasse = "";
	String angebot = "false";
	String sparpreis = "false";
	String flexpreis = "false";

    public Definition() {
        super();       
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		resp.setContentType("text/html");
    	//PrintWriter out = resp.getWriter();
    	ServletContext con = getServletContext();
		RequestDispatcher view = con.getRequestDispatcher("/index.jsp");
		view.include(req, resp);		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	von = req.getParameter("von");
    	nach = req.getParameter("nach");
    	hinfahrt = req.getParameter("zeitpunkt") + "T00:00:00+01:00"; // TODO: parse into date and serialize
    	reisende = req.getParameter("reisende");
    	klasse = req.getParameter("klasse");
    	angebot = req.getParameter("angebot");
    	sparpreis = req.getParameter("sparpreis");
    	flexpreis = req.getParameter("flexpreis");
    			
    	resp.setContentType("text/html");
    	PrintWriter out = resp.getWriter();
    	out.println("<b>Test-Definition erfolgreich</b><br />");
    	out.println("Von " + von + " nach " + nach + "<br />");
    	out.println("Datum: " + hinfahrt + "<br />");
    	out.println("Reisende: " + reisende + " Klasse: " + klasse + "<br /><br />");
    	new Test(von, nach, hinfahrt, reisende, klasse, angebot, sparpreis, flexpreis).register();
 
		doGet(req, resp);
	}
}
