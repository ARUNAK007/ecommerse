package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Payement;
@Repository
@Transactional
public class PayementDAOImpl implements PayementDAO {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addPayement(Payement p) {
		Session session=sessionFactory.getCurrentSession();
		session.save(p);
		return true;
	}

	public boolean deletePayement(Payement p) {
		Session session=sessionFactory.getCurrentSession();		
		session.delete(p);
		return true;
	}

	public Payement findPayement(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Payement p where p.id="+id);
		List<Payement> Payementlist=query.list();
		return (Payement)Payementlist.get(0);	
	}

	public Payement updatePayement(Payement p) {
		Session session=sessionFactory.getCurrentSession();
		session.update(p);
		return p;
		
	}

	public List<Payement> getAllPayements(String cartid) {
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Payement p where p.cartid='"+cartid+"'");
		List<Payement> Payementlist=query.list();
		return Payementlist;
	}

	public Payement find(String cartid) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Payement p where p.cartid='"+cartid+"'");
		List<Payement> Payementlist=query.list();
		return (Payement)Payementlist.get(0);
	}
}
