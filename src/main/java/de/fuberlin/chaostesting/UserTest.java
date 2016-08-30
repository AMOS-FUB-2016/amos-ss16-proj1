package de.fuberlin.chaostesting;

import java.util.List;

import de.fuberlin.chaostesting.model.DAO;
import de.fuberlin.chaostesting.model.Test;
import de.fuberlin.chaostesting.model.User;

public class UserTest {
		DAO<User> userDao = DAO.createInstance(User.class);
	
		public String newTester() {
			userDao.create(new User("Tester", "a822bd7b0419225c972475b4c49f8ff4", false));
			return "Test-Anwender wurde gespeichert!";
		}
		
		public String newAdmin() {
			userDao.create(new User("Admin", "95765e67d23b721d87eacb3531b63603", true));
			return "Test-Admin wurde gespeichert!";
		}
		
		public List<User> getUsers() {
			return userDao.findAll();
		}
}
