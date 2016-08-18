package de.fuberlin.chaostesting.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	private Date testHinfahrt;
	@Column(name="reisende")
	private String testReisende;
	@Column(name="klasse")
	private String testKlasse;
	@Column(name="preis")
	private String preis;
	
	public Test() {
	}
	
	public Test(String von, String nach, Date hinfahrt, String reisende, 
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

	public void setTestVon(String testVon) {
		this.testVon = testVon;
	}

	public String getTestNach() {
		return testNach;
	}

	public void setTestNach(String testNach) {
		this.testNach = testNach;
	}

	public Date getTestHinfahrt() {
		return testHinfahrt;
	}

	public void setTestHinfahrt(Date testHinfahrt) {
		this.testHinfahrt = testHinfahrt;
	}

	public String getTestReisende() {
		return testReisende;
	}

	public void setTestReisende(String testReisende) {
		this.testReisende = testReisende;
	}

	public String getTestKlasse() {
		return testKlasse;
	}

	public void setTestKlasse(String testKlasse) {
		this.testKlasse = testKlasse;
	}

	public String getPreis() {
		return preis;
	}

	public void setPreis(String preis) {
		this.preis = preis;
	}

	public void register() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();
	}
	
	public static List<Test> list(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Test> tests = session.createQuery("FROM Test", Test.class).getResultList();
		
		session.getTransaction().commit();
		
		return tests;
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
		
		session.close();
		
		return theTest;
	}
}
