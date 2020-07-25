package products_and_goods;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.persistence.Query;
//import javax.servlet.http.Part;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sessionmanagement.SessionHandler;

public class ProductDAO {
	public static void storeProduct(String name, String type, String price, String description, String path, Part raw_image) {
		Session session = SessionHandler.getSessionHandler().getSession();
		Transaction transaction = session.beginTransaction();	
		try {
			Product product = BuildProduct.buildProduct(name, type, 
					Double.parseDouble(price), description, 
					raw_image.getSubmittedFileName());
			session.persist(product);
			FileOutputStream fileOut = new FileOutputStream(path + File.separator + raw_image.getSubmittedFileName());
			InputStream ios = raw_image.getInputStream();
			byte input[] = new byte[ios.available()];
			ios.read(input);
			fileOut.write(input);
			System.out.println(path + File.separator + raw_image.getSubmittedFileName());
			fileOut.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			SessionHandler.getSessionHandler().closeSession(session);
		}
		return;
	}
	
	public static Product getProduct(long ID) {
		Session session = SessionHandler.getSessionHandler().getSession();
		String hql = "select description from Product where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", ID);
		Product product = (Product)query.getSingleResult();
		SessionHandler.getSessionHandler().closeSession(session);
		return product;
	}
	
	public static List<Product> getLaptop() {
		Session session = SessionHandler.getSessionHandler().getSession();
		String hql = "from Product where type = :type";
		Query query = session.createQuery(hql);
		query.setParameter("type", 3);
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>)query.getResultList();
		System.out.println("returned " + list.size());
		SessionHandler.getSessionHandler().closeSession(session);
		return list;
	}
	
	public static List<Product> getPhone() {
		Session session = SessionHandler.getSessionHandler().getSession();
		String hql = "from Product where type = :type";
		Query query = session.createQuery(hql);
		query.setParameter("type", 0);
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>)query.getResultList();
		System.out.println("returned " + list.size());
		SessionHandler.getSessionHandler().closeSession(session);
		return list;
	}
}
