package hibernate.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.CategoryDAO;
import dao.SupplierDAO;
import jdk.nashorn.internal.ir.annotations.Ignore;
import model.Category;
import model.Supplier;

public class Suppliertest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
	}
	@Ignore
	public void testAddSupplier() {
		Supplier s=new Supplier();
		s.getSupplierId();
		s.setSuppliername("reban");
		SupplierDAO catimpl=(SupplierDAO)context.getBean("SupplierDAO");
		assertTrue(catimpl.addSupplier(s));
	}

	@Test
	public void testFind() {
		SupplierDAO supimpl=(SupplierDAO)context.getBean("SupplierDAO");
		 Supplier s=supimpl.find(13);
		 System.out.println(s.getSuppliername());
	
	}

	@Ignore
	public void testUpdateSupplierDetails() {
		SupplierDAO supimpl=(SupplierDAO)context.getBean("SupplierDAO");
		Supplier s=new Supplier();
		 s=supimpl.find(13);
		s.setSuppliername("balaji");
		supimpl.updateSupplierDetails(s);
	
	}

	@Test
	public void testDeleteSupplierDetails() {
		SupplierDAO supimpl=(SupplierDAO)context.getBean("SupplierDAO");
		Supplier s=supimpl.find(14);	
		supimpl.deleteSupplierDetails(s);
	}

	@Ignore
	public void testGetAllSupplier() {
		SupplierDAO supimpl=(SupplierDAO)context.getBean("SupplierDAO");
		java.util.List<Supplier> list=supimpl.getAllSupplier();
    	for(Supplier s: list)
    	{
    		System.out.println(s.getSupplierId()+" "+s.getSuppliername());
    	}

	}

}
