package hibernate.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.CategoryDAO;
import model.Category;

public class Categorytest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
	}
	@Ignore
	public void testAddCategory() {
		Category c=new Category();
		c.getCategoryId();
		c.setCategoryname("reban");
		CategoryDAO catimpl=(CategoryDAO)context.getBean("CategoryDAO");
		assertTrue(catimpl.addCategory(c));
	}

	@Ignore
	public void testFind() {
		CategoryDAO catimpl=(CategoryDAO)context.getBean("CategoryDAO");
		 Category c=catimpl.find(6);
		 System.out.println(c.getCategoryname());
	}

	@Ignore
	public void testUpdateCategory() {
		CategoryDAO catimpl=(CategoryDAO)context.getBean("CategoryDAO");
		 Category c=catimpl.find(6);
		 c.setCategoryname("ramu");
	    	catimpl.updateCategory(c);

	}

	@Test
	public void testDeleteCategory() {
		CategoryDAO catimpl=(CategoryDAO)context.getBean("CategoryDAO");

		 Category c=catimpl.find(9);
		
	    	catimpl.deleteCategory(c);
	    	c=catimpl.find(8);
	    	catimpl.deleteCategory(c);
	}

	@Ignore
	public void testGetAllCategory() {
		CategoryDAO catimpl=(CategoryDAO)context.getBean("CategoryDAO");
		java.util.List<Category> list=catimpl.getAllCategorys();
    	for(Category c: list)
    	{
    		System.out.println(c.getCategoryId()+" "+c.getCategoryname());
    	}

	}

}
