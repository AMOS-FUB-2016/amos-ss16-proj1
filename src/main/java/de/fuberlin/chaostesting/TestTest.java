package de.fuberlin.chaostesting;

import de.fuberlin.chaostesting.hibernate.Test;

public class TestTest {
	
		public String getTests() {
			return new Test().list();
		}
}
