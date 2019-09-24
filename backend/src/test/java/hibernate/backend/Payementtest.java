package hibernate.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.CartDAO;
import dao.PayementDAO;
import model.Cart;
import model.Payement;

public class Payementtest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
	}

	@Test
	public void testAddPayement() {
		PayementDAO payimpl=(PayementDAO)context.getBean("PayementDAO");
		Payement p=new Payement();
		p.settotal(678);
		p.setPaymenttype("upi");
		assertTrue(payimpl.addPayement(p));
		
	}

	@Test
	public void testDeletePayement() {
		PayementDAO payimpl=(PayementDAO)context.getBean("PayementDAO");
		Payement p=new Payement();
		p=payimpl.findPayement(4);
		payimpl.deletePayement(p);
		
	}

	@Test
	public void testFindPayement() {
		PayementDAO payimpl=(PayementDAO)context.getBean("PayementDAO");
		Payement p=new Payement();
		p=payimpl.findPayement(3);
		System.out.println(p.gettotal()+" "+p.getPaymenttype());
	}

	@Test
	public void testUpdatePayement() {
		PayementDAO payimpl=(PayementDAO)context.getBean("PayementDAO");
		Payement p=new Payement();
		p=payimpl.findPayement(1);
		p.setPaymenttype("upi");
		payimpl.updatePayement(p);
	}

	@Test
	public void testGetAllPayements(String cartId) {
		String cartId1="20:119:8enperuarun@gmail.com/";
		PayementDAO catimpl=(PayementDAO)context.getBean("PayementDAO");
		java.util.List<Payement> list=catimpl.getAllPayements(cartId1);
    	for(Payement p: list)
    	{
    		System.out.println(p.getCartId()+" "+p.getPaymenttype());
    	}
		
	}

}
