package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Supplier;
@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addSupplier(Supplier s) {
		Session session=sessionFactory.getCurrentSession();
		session.save(s);
		return true;
	}
	public Supplier find(int id) {
		Session session=sessionFactory.getCurrentSession();
		Supplier supplier=session.get(Supplier.class,id);
		return supplier;
		
	}
	public Supplier updateSupplierDetails(Supplier s) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(s);
		// TODO Auto-generated method stub
		return s;
	}
	public boolean deleteSupplierDetails(Supplier s) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(s);
		// TODO Auto-generated method stub
		return true;

	}
	public List<Supplier> getAllSupplier() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Supplier s");
		List<Supplier> Supplierlist=query.list();
		return Supplierlist;

	}
	
}
