package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Category;
@Repository
@Transactional

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category c) {
		Session session=sessionFactory.getCurrentSession();
		session.save(c);
		return true;

	}

	public Category find(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category c where c.categoryId="+id);
		List<Category> Categorylist=query.list();
		
		return (Category)Categorylist.get(0);

		}

	public Category updateCategory(Category c) {
		Session session=sessionFactory.getCurrentSession();
		session.update(c);
		// TODO Auto-generated method stub
		return c;

	}

	public boolean deleteCategory(Category c) {
		

		Session session=sessionFactory.getCurrentSession();
	
		session.delete(c);
		// TODO Auto-generated method stub
		return true;
	}

	public List<Category> getAllCategorys() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category c");
		
		List<Category> Categorylist=query.list();
		return Categorylist;
	}

	}
