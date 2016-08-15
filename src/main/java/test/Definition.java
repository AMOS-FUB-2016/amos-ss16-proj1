package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fuberlin.chaostesting.hibernate.Test;
/**
 * Servlet implementation class Definition
 */

public class Definition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String von = "";
	String nach = "";
	String hinfahrt = "";
	String reisende = "";
	String klasse = "";
	String preis = "";
       

    public Definition() {
        super();
       
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		resp.setContentType("text/html");
    	PrintWriter out = resp.getWriter();
    	ServletContext con = getServletContext();
		RequestDispatcher view = con.getRequestDispatcher("/index.jsp");
		view.include(req, resp);		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	von = req.getParameter("von");
    	nach = req.getParameter("nach");
    	hinfahrt = req.getParameter("hinfahrt");
    	reisende = req.getParameter("reisende");
    	klasse = req.getParameter("klasse");
    	preis = req.getParameter("preis");
    			
    	resp.setContentType("text/html");
    	PrintWriter out = resp.getWriter();
    	out.println("<b>Test-Definition erfolgreich</b><br />");
    	out.println("Von " + von + " nach " + nach + "<br />");
    	out.println("Hinfahrt: " + hinfahrt + "<br />");
    	out.println("Reisende: " + reisende + " Klasse: " + klasse + "<br /><br />");
    	out.println("Preis (Sollwert): " + preis + "<br />");
    	new Test(von, nach, hinfahrt, reisende, klasse, preis).register();
 
		doGet(req, resp);
	}

}
