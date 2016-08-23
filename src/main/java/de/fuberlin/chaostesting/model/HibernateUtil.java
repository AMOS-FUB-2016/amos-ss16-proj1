package de.fuberlin.chaostesting.model;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
    private static SessionFactory sessionFactory;
     
    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
        	Configuration configuration = new Configuration().configure();
    		String url = configuration.getProperty("hibernate.connection.url");
    		String hostname = System.getProperty("HIBERNATE_DB_HOST");    		
    		if(hostname != null && url != null) {
    			url = url.replaceFirst("localhost", hostname);
    			configuration.setProperty("hibernate.connection.url", url);
    		}

            sessionFactory = configuration.buildSessionFactory();
            // TODO: what happens when  creation fails?
        }
         
        return sessionFactory;
    }
}
