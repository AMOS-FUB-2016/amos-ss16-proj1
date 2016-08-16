package de.fuberlin.chaostesting;

import de.fuberlin.chaostesting.hibernate.User;

public class UserTest {

		public String newTester() {
			new User("Tester", "a822bd7b0419225c972475b4c49f8ff4", false).register();
			return "Test-Anwender wurde gespeichert!";
		}
		
		public String newAdmin() {
			new User("Admin", "95765e67d23b721d87eacb3531b63603", true).register();
			return "Test-Admin wurde gespeichert!";
		}
		
		public String getUsers() {
			return new User().list();
		}
}