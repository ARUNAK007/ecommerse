package hibernate.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.CartDAO;
import dao.CategoryDAO;
import dao.CartDAO;
import model.Cart;
import model.Category;
import model.Cart;

public class Carttest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
	}

	@Test
	public void testAddCart() {
		Cart p=new Cart();
		p.setEmail("arun@gmail.com");
		p.setProductid(8);
		p.setPrice(1300);
		
		java.util.Date dt=new java.util.Date();
		String cartid=dt.getDate()+":"+dt.getYear()+p.getEmail();
		p.setCartid(cartid );
		CartDAO cimpl=(CartDAO)context.getBean("CartDAO");
		assertTrue(cimpl.addCart(p));
	}

	@Test
	public void testDeleteCart() {
		CartDAO cimpl=(CartDAO)context.getBean("CartDAO");
		 Cart p=cimpl.findCart(3);
		cimpl.deleteCart(p);
		
	}

	@Test
	public void testFindCart() {
		CartDAO cimpl=(CartDAO)context.getBean("CartDAO");
		 Cart p=cimpl.findCart(1);
		 System.out.println(p.getCartid());
	}

	@Test
	public void testUpdateCart() {
		CartDAO cimpl=(CartDAO)context.getBean("CartDAO");
		Cart p=cimpl.findCart(1);
		p.setPrice(670);
		cimpl.updateCart(p);
	}

	@Test
	public void testGetAllCarts() {
		CartDAO catimpl=(CartDAO)context.getBean("CartDAO");
		java.util.List<Cart> list=catimpl.getAllCarts("");
    	for(Cart c: list)
    	{
    		System.out.println(c.getProductid()+" "+c.getCartid());
    	}
	}

}
