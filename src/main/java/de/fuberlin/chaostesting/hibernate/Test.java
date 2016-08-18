package de.fuberlin.chaostesting.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="TEST_INFORMATION")
public class Test {	
	@Id	@GeneratedValue
	@Column(name="test_id")
	private int id;
	@Column(name="test_von")
	private String von;
	@Column(name="test_nach")
	private String nach;
	@Column(name="test_zeitpunkt")
	private String zeitpunkt;
	@Column(name="test_reisende")
	private String reisende;
	@Column(name="test_klasse")
	private String klasse;
	@Column(name="test_Angebot")
	private String angebot;
	@Column(name="test_sparpreis")
	private String sparpreis;
	@Column(name="test_flexpreis")
	private String flexpreis;
	
	public Test() {
	}
	
	public Test(String von, String nach, String hinfahrt, String reisende, 
			String klasse, String angebot, String sparpreis, String flexpreis) {
		this.von = von;
		this.nach = nach;
		this.zeitpunkt = hinfahrt;
		this.reisende = reisende;
		this.klasse = klasse;
		this.angebot = angebot;
		this.sparpreis = sparpreis;
		this.flexpreis = flexpreis;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVon() {
		return von;
	}

	public void setVon(String von) {
		this.von = von;
	}

	public String getNach() {
		return nach;
	}

	public void setNach(String nach) {
		this.nach = nach;
	}

	public String getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(String zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public String getReisende() {
		return reisende;
	}

	public void setReisende(String reisende) {
		this.reisende = reisende;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public String isAngebot() {
		return angebot;
	}

	public void setAngebot(String angebot) {
		this.angebot = angebot;
	}

	public String isSparpreis() {
		return sparpreis;
	}

	public void setSparpreis(String sparpreis) {
		this.sparpreis = sparpreis;
	}

	public String isFlexpreis() {
		return flexpreis;
	}

	public void setFlexpreis(String flexpreis) {
		this.flexpreis = flexpreis;
	}

	public void register() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();
	}
	
	public String list(){
		String testList = "<tr><th>Von</th><th>Nach</th><th>Datum</th>"
				+ "<th>Reisende</th><th>Klasse</th><th>Angebot</th>"
				+ "<th>Sparpreis</th><th>Flexpreis</th></tr>\n";
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Test> tests = (List<Test>)session.createQuery("FROM Test").getResultList();
		
		for (Test test : tests) { 
			testList += "<tr><td>" + test.getVon();
			testList += "</td><td>" + test.getNach();
			testList += "</td><td>" + test.getZeitpunkt();
			testList += "</td><td>" + test.getReisende();
			testList += "</td><td>" + test.getKlasse();
			testList += "</td><td>" + test.isAngebot();
			testList += "</td><td>" + test.isSparpreis();
			testList += "</td><td>" + test.isFlexpreis();
			testList += "</td><td><a href=\"executeTest.jsp?id=" + test.getId() + "\">Test ausführen</a>";
			testList += "</td></tr>";
		}		
		
		session.getTransaction().commit();
		
		return testList;
	}
	
	public String toXML(){
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+"<angebotsAnfrage msgVersion=\"1.0\">"
				+"<allgemeineAngaben wagenKlasse_e=\"KLASSE_"+klasse+"\"/>"
				+"<reisender typ_e=\"ERWACHSENER\" anzahl=\""+reisende+"\"/>"
				+"<verbindungsParameter zeitpunkt=\""+zeitpunkt+"\" >"
				+"<halt bahnhof=\""+von+"\"/>"
				+"<halt bahnhof=\""+nach+"\"/>"
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
}
