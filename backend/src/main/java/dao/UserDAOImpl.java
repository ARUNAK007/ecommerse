package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import model.User;
@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory sessionFactory;
	public boolean addUser(User u) {
		Session session=sessionFactory.getCurrentSession();
		session.save(u);
		return true;
	}
public User find(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where u.userId="+id);
		List<User> Userlist=query.list();
		
		return (User)Userlist.get(0);
	}
	public User updateUserDetails(User u) {
	
		Session session=sessionFactory.getCurrentSession();
		session.update(u);
		return u;
	}
	public boolean deleteUserDetails(User u) {
		Session session=sessionFactory.getCurrentSession();
		
	
		session.delete(u);
		return true;
	}
	public List<User> getAllUser() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u");
		List<User> Userlist=query.list();
		return Userlist;
	}
	public User findName(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where u.email='"+username+"'");
		List<User> Userlist=query.list();
		
		return (User)Userlist.get(0);
	}

	


}
