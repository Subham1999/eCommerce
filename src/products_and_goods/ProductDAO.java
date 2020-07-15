package products_and_goods;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sessionmanagement.SessionHandler;

public class ProductDAO {
	public static void storeProduct(int type, double price, String description) {
		Product product = BuildProduct.buildProduct(type, price, description);
		Session session = SessionHandler.getSessionHandler().getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(product);
		transaction.commit();
		SessionHandler.getSessionHandler().closeSession(session);
	}
	
	/*
	 * public String getProductDescription(long ID) { Session session =
	 * SessionHandler.getSessionHandler().getSession(); String hql =
	 * "select Product.description from Product where Product.productID = :id";
	 * Query query = session.createQuery(hql); query.setParameter("id", ID); Product
	 * product = (Product)query.getSingleResult();
	 * SessionHandler.getSessionHandler().closeSession(session); return
	 * product.toString(); }
	 */
	public static Product getProduct(long ID) {
		Session session = SessionHandler.getSessionHandler().getSession();
		String hql = "select Product.description from Product where Product.productID = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", ID);
		Product product = (Product)query.getSingleResult();
		SessionHandler.getSessionHandler().closeSession(session);
		return product;
	}
}
