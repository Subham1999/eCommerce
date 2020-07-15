package sessionmanagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/*
 * 
 * @author Subham Santra
 * 
 * SessionHandler is a Singleton class, which will serve 
 * getSession() and closeSession() request throughout application
 * 
*/

public class SessionHandler {
	private StandardServiceRegistry serviceRegistry = null;
	private Metadata metadata = null;
	private SessionFactory sessionFactory = null;
	
	private static SessionHandler instance = null;
	
	public static SessionHandler getSessionHandler() {
		if(instance == null) {
			instance = new SessionHandler();
		}
		return instance;
	}
	
	private SessionHandler() {
		super();
		ConfigureSessionFactory();
	}
	
	private void ConfigureSessionFactory() {
		this.serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		this.metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		this.sessionFactory = metadata.getSessionFactoryBuilder().build();
	}
	
	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	
	public boolean closeSession(Session session) {
		if(session.isConnected()){
			session.close();
			return true;
		} else {
			return false;
		}
	}
	
}
