package de.fuberlin.chaostesting.hibernate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="USER_INFORMATION")
public class User {	
	@Id
	private int id;
	private String userName; 
	private String passHash;
	private boolean isAdmin;
	
	public User() {
	}
	
	public User(String name, String hash, boolean admin) {
		this.userName = name;
		this.passHash = hash;
		this.isAdmin = admin;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassHash() {
		return passHash;
	}
	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}
	public boolean getisAdmin() {
		return isAdmin;
	}
	public void setisAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public void register() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	public String list( ){
		String userList = "<tr><th>Nutzername</th><th>Passwort-Hash</th><th>Admin</th></tr>\n";
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List users = session.createQuery("FROM User").getResultList();
		
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next(); 
			userList += "<tr><td>" + user.getUserName();
			userList += "</td><td>" + user.getPassHash();
			userList += "</td><td>" + user.getisAdmin() + "</td></tr>\n";
		}		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		return userList;
	}
}