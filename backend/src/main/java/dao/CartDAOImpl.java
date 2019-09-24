package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Cart;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {
	@Autowired 
	SessionFactory sessionFactory;
	public boolean addCart(Cart p) {
      sessionFactory.getCurrentSession().save(p);		
	
		// TODO Auto-generated method stub
		return true;
	}
	public boolean deleteCart(Cart p) {
	      sessionFactory.getCurrentSession().delete(p);		

		return true;
	}

	public Cart findCart(int id) {
		Session session=sessionFactory.getCurrentSession();		
Query query=session.createQuery("from Cart p where p.id="+id);
List<Cart> Cartlist=query.list();

return (Cart)Cartlist.get(0);
	
	}

	public Cart updateCart(Cart p) {
		 sessionFactory.getCurrentSession().update(p);		
		  	
			// TODO Auto-generated method stub
			return p;
	}

	public List<Cart> getAllCarts(String cartid) {
		 return  sessionFactory.getCurrentSession().createQuery("from Cart p where p.cartid='"+cartid+"'").list();	

	
	}
	public Cart find(String cartid) {
		
		Session session=sessionFactory.getCurrentSession();		
		Query query=session.createQuery("from Cart p where p.cartid='"+cartid+"'");
		List<Cart> Cartlist=query.list();

		return (Cart)Cartlist.get(0);

	}

}
