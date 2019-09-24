package hibernate.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.SupplierDAO;
import dao.UserDAO;
import jdk.nashorn.internal.ir.annotations.Ignore;
import model.Supplier;
import model.User;

public class Usertest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
	}
	@Test
	public void testAddUser() {
		User u=new User();
		u.getUserId();
		u.setUserName("vishal");
		u.setEmail("rkvishaal2015@gmail.com");
		u.setMobileNumber("9840995325");
		u.setPassword("rkvishaal");
		u.setUser_role("ROLE_USER");
		UserDAO uimpl=(UserDAO)context.getBean("UserDAO");
		assertTrue(uimpl.addUser(u));
	}

	@Ignore
	public void testUpdateUserDetails() {
		UserDAO uimpl=(UserDAO)context.getBean("UserDAO");
		User u=new User();
		u=uimpl.find(19);
		u.setUserName("Donsheik");
		uimpl.updateUserDetails(u);

	}

	@Test
	public void testDeleteUserDetails() {
		UserDAO uimpl=(UserDAO)context.getBean("UserDAO");

		User s=uimpl.find(24);	
		uimpl.deleteUserDetails(s);
	}

	@Test
	public void testGetAllUser() {
		UserDAO supimpl=(UserDAO)context.getBean("UserDAO");
		java.util.List<User> list=supimpl.getAllUser();
    	for(User s: list)
    	{
    		System.out.println(s.getUserId()+" "+s.getUserName());
    	}

	}

	@Test
	public void testFind() {
		UserDAO uimpl=(UserDAO)context.getBean("UserDAO");
		 User u=uimpl.find(19);
		 System.out.println(u.getUserName());
	
	}

}
