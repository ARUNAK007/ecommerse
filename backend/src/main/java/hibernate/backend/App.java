package hibernate.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.CategoryDAO;
import dao.PayementDAO;
import dao.ProductDAO;
import dao.UserDAO;
import model.Category;
import model.Payement;
import model.Product;
import model.User;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;


public class App 
{
    public static void main( String[] args )
    {
        
    	try {
    		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfiguration.class);
    	    
  /* ProductDAO daoimpl=(ProductDAO)ctx.getBean("productDAO");
         Product p=new Product();
    	 p.setProductName("TEA");
    	 p.setPrice(200);
    	 p.setCategoryId(2);
    	 p.setSupplierId(1);
    	 p.setQuantity(5);
    	if( daoimpl.addProduct(p))
    	{
    		System.out.println("product added");
    	}
    	CategoryDAO catimpl=(CategoryDAO)ctx.getBean("CategoryDAO");
		Category c=new Category();
 	    c.getCategoryId();
 		c.setCategoryname("homeappliance");
 		if( catimpl.addCategory(c))
     	{
     		System.out.println("Category added");
     	}
 		UserDAO useimpl=(UserDAO)ctx.getBean("UserDAO");
 	User u=new User();
 	u.setUserId(9);
 	u.setEmail("arunkumar.malaikannan@gmail.com");
 	u.setMobileNumber("7358159133");
 	u.setPassword("arunAK");
 	u.setUserName("Arun kumar");

 		if( useimpl.addUser(u))
     	{
     		System.out.println("Customer added");
     	}*/
    		/*CartDAO cimpl=(CartDAO)ctx.getBean("CartDAO");
    		Cart p=new Cart();
    		p.setEmail("arun@gmail.com");
    		p.setProductid(1);
    		p.setPrice(120);
    		*/
    	// Product p=daoimpl.find(2);
    //	daoimpl.deleteProduct(p);
    	// p.setProductName("");
    	//daoimpl.updateProduct(p);
    	 //System.out.println(p.getProductName());
    	/*java.util.List<Product> list=daoimpl.getAllProducts();
    	for(Product p :list)
    	{
    		System.out.println(p.getProductName()+" "+p.getPrice()+" "+p.getProductid());
    	}*/
    	/*	PayementDAO payimpl=(PayementDAO)ctx.getBean("payementDAO");
    		Payement p=new Payement();
    		p.setCartId(4);
    		p.settotal(6798);
    		p.setPaymenttype("card");
    		payimpl.addPayement(p);
    	}*/}
    		catch (Throwable e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	        
    	    }
    	}
