package hibernate.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.ProductDAO;
import model.Product;

public class Producttest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
	
	}

	@Test
	public void testAddProduct() {
	/*	Product p=new Product();
		p.setProductName("Cofee");
		p.setPrice(200);
		p.setCategoryId(1);
		p.setSupplierId(1);
		ProductDAO dao=(ProductDAO)context.getBean("productDAO");
	assertTrue(dao.addProduct(p));*/		
	}
	

	@Test
	public void testFind() {
		ProductDAO daoimpl=(ProductDAO)context.getBean("productDAO");
		 Product p=daoimpl.find(2);
		 System.out.println(p.getProductName());
	}

	@Test
	public void testUpdateProduct() {
		ProductDAO daoimpl=(ProductDAO)context.getBean("productDAO");
		 Product p=daoimpl.find(2);
		 p.setPrice(400);
	    	daoimpl.updateProduct(p);
	}

	@Test
	public void testDeleteProduct() {
      ProductDAO daoimpl=(ProductDAO)context.getBean("productDAO");

		 Product p=daoimpl.find(2);
	    	daoimpl.deleteProduct(p);
	}

	@Test
	public void testGetAllProducts() {
		ProductDAO daoimpl=(ProductDAO)context.getBean("productDAO");
		java.util.List<Product> list=daoimpl.getAllProducts();
    	for(Product p :list)
    	{
    		System.out.println(p.getProductName()+" "+p.getPrice()+" "+p.getProductid());
    	}
	}

}
