package de.fuberlin.chaostesting.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

@Entity
@Table(name="TEST")
public class Test {	
	@Id	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="von")
	private String testVon;
	@Column(name="nach")
	private String testNach;
	@Column(name="hinfahrt")
	private String testHinfahrt;
	@Column(name="reisende")
	private String testReisende;
	@Column(name="klasse")
	private String testKlasse;
	@Column(name="preis")
	private String preis;
	
	public Test() {
	}
	
	public Test(String von, String nach, String hinfahrt, String reisende, 
			String klasse, String preis) {
		this.testVon = von;
		this.testNach = nach;
		this.testHinfahrt = hinfahrt;
		this.testReisende = reisende;
		this.testKlasse = klasse;
		this.preis = preis;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTestVon() {
		return testVon;
	}
	public void setTestVon(String von) {
		this.testVon = von;
	}
	public String getTestNach() {
		return testNach;
	}
	public void setTestNach(String nach) {
		this.testNach = nach;
	}
	public String getTestHinfahrt() {
		return testHinfahrt;
	}
	public void setTestHinfahrt(String hinfahrt) {
		this.testHinfahrt = hinfahrt;
	}
	public String getTestReisende() {
		return testReisende;
	}
	public void setTestReisende(String reisende) {
		this.testReisende = reisende;
	}
	public String getTestKlasse() {
		return testKlasse;
	}
	public void setTestKlasse(String klasse) {
		this.testKlasse = klasse;
	}
	public String getPreis() {
		return preis;
	}
	public void setPreis(String preis) {
		this.preis = preis;
	}
	
	
	public void register() {
		HibernateUtil.insert(this);
	}
	

	public String list(){
		String testList = "<tr><th>Von</th><th>Nach</th><th>Datum</th>"
				+ "<th>Reisende</th><th>Klasse</th><th>Preis</th>  <th>Option1</th>  <th>Option2</th></tr>";
		
		//Session session = HibernateUtil.startSession();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Test> tests = (List<Test>)session.createQuery("FROM Test").getResultList();
		@SuppressWarnings("unused")
		int íd;
		for (Test test : tests) { 
			testList += "<tr><td>" + test.getTestVon();
			testList += "</td><td>" + test.getTestNach();
			testList += "</td><td>" + test.getTestHinfahrt();
			testList += "</td><td>" + test.getTestReisende();
			testList += "</td><td>" + test.getTestKlasse();
			testList += "</td><td>" + test.getPreis();
			testList += "</td><td><a href=\"executeTest.jsp?id=" + test.getId() + "\">Execute</a> - ";
			testList += "<a href=\"delTest.jsp?id=" + test.getId() + "\">Delete</a>";
			testList += "</td></tr>";
		}		
		
		session.getTransaction().commit();
		
		return testList;
	}
	
	//test?
	public String listDAO(){
		HibernateUtil<Test> res = new HibernateUtil<Test>();
		List<Test> tests = res.list("Test");	
		
		String testList = "<tr><th>Von</th><th>Nach</th><th>Datum</th>"
				+ "<th>Reisende</th><th>Klasse</th><th>Preis</th><th>Option</th></tr>";
		for (Test test : tests) { 
			testList += "<tr><td>" + test.getTestVon();
			testList += "</td><td>" + test.getTestNach();
			testList += "</td><td>" + test.getTestHinfahrt();
			testList += "</td><td>" + test.getTestReisende();
			testList += "</td><td>" + test.getTestKlasse();
			testList += "</td><td>" + test.getPreis();
			testList += "</td><td><a href=\"executeTest.jsp?id=" + test.getId() + "\">Execute</a> - ";
			testList += "<a href=\"delTest.jsp?id=" + test.getId() + "\">Delete</a>";
			testList += "</td></tr>";
		}		
		return testList;
	}
	
	public String toXML(){
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+"<angebotsAnfrage msgVersion=\"1.0\">"
				+"<allgemeineAngaben wagenKlasse_e=\"KLASSE_"+testKlasse+"\"/>"
				+"<reisender typ_e=\"ERWACHSENER\" anzahl=\""+testReisende+"\"/>"
				+"<verbindungsParameter zeitpunkt=\""+testHinfahrt+"\" >"
				+"<halt bahnhof=\""+testVon+"\"/>"
				+"<halt bahnhof=\""+testNach+"\"/>"
				+"</verbindungsParameter>"
				+"</angebotsAnfrage>";		
		return xml;
	}
	
	public static Test byId(int id) {
		Test theTest = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		theTest = session.get(Test.class, id);
		
		return theTest;
	}
	
	
	public static int delete (int id)  
	{  
		return HibernateUtil.delete("Test", id);
	} 
	
}
