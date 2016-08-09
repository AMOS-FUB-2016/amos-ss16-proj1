package de.fuberlin.chaostesting;

import de.fuberlin.chaostesting.hibernate.User;

public class UserTest {

		public String newTester() {
			new User("Tester", "a822bd7b0419225c972475b4c49f8ff4", false).register();
			return "New tester has been added!";
		}
		
		public String newAdmin() {
			new User("Admin", "95765e67d23b721d87eacb3531b63603", true).register();
			return "New admin has been added!";
		}
		
		public String getUsers() {
			return new User().list();
		}
}