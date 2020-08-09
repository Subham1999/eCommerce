package user;

import java.util.List;

/*
 * @author Subham Santra
 * clean code
*/

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sessionmanagement.SessionHandler;

public class UserDAO {
	
	public static boolean storeUser(User user) {
		boolean result = true;
		Session session = SessionHandler.getSessionHandler().getSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.persist(user);
			System.out.println(user.getName());
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
		}
		transaction.commit();
		SessionHandler.getSessionHandler().closeSession(session);
		return result;
	}
	
	public static User getUser(String name, String password) {
		if(name == null || password == null) return null;
		Session session = SessionHandler.getSessionHandler().getSession();
		User user = null;
		try{
			String hql = "from User where name = :name and password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			query.setParameter("password", password);
			user = (User)query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		SessionHandler.getSessionHandler().closeSession(session);
		return user;
	}
	
	public static User getUser(Long id) {
		if(id == null) return null;
		Session session = SessionHandler.getSessionHandler().getSession();
		User user = null;
		try{
			String hql = "from User where id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			user = (User)query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		SessionHandler.getSessionHandler().closeSession(session);
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public static List<User> getUserList(){
		List<User> list = null;
		Session session = SessionHandler.getSessionHandler().getSession();
		try{
			String hql = "from User";
			Query query = session.createQuery(hql);
			list = (List<User>)query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			SessionHandler.getSessionHandler().closeSession(session);
		}
		return list;
	}
	
}
