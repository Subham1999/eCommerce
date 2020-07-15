package user;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sessionmanagement.SessionHandler;

public class UserDAO {
	
	public static void storeUser(User user) {
		Session session = SessionHandler.getSessionHandler().getSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.persist(user);
			System.out.println(user.getName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		transaction.commit();
		SessionHandler.getSessionHandler().closeSession(session);
	}
	
	public static void storeCustomer(Customer user) {
		Session session = SessionHandler.getSessionHandler().getSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.persist(user);
			System.out.println(user.getName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		transaction.commit();
		SessionHandler.getSessionHandler().closeSession(session);
	}
	
	public static void storeAdmin(Admin user) {
		SessionHandler sessionHandler = SessionHandler.getSessionHandler();
		Session session = sessionHandler.getSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.persist(user);
			System.out.println(user.getName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		transaction.commit();
		SessionHandler.getSessionHandler().closeSession(session);
	}
	
	public static User getUser(long id) {
		Session session = SessionHandler.getSessionHandler().getSession();
		Transaction transaction = session.beginTransaction();
		User user = null;
		try {
			String hql = "from User where id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			user = (User)query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			transaction.commit();
			SessionHandler.getSessionHandler().closeSession(session);
		}
		return user;
	}
	
	public static Customer getCustomer(long id) {
		Session session = SessionHandler.getSessionHandler().getSession();
		Transaction transaction = session.beginTransaction();
		Customer user = null;
		try {
			String hql = "from Customer where id =:id";
			Query query = session.createQuery(hql);
			query.setParameter("is", id);
			user = (Customer)query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			transaction.commit();
			SessionHandler.getSessionHandler().closeSession(session);
		}
		return user;
	}
	
	public static User getAdmin(String name, String password) {
		Session session = SessionHandler.getSessionHandler().getSession();
		Transaction transaction = session.beginTransaction();
		Admin user = null;
		try {
			String hql = "from Admin where user_name := n and user_password := p";
			Query query = session.createQuery(hql);
			query.setParameter("n", name);
			query.setParameter("p", password);
			user = (Admin)query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			transaction.commit();
			SessionHandler.getSessionHandler().closeSession(session);
		}
		return user;
	}
}
