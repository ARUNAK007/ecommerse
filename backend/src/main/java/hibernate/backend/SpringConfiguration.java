package hibernate.backend;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dao.CartDAO;
import dao.CartDAOImpl;
import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import dao.PayementDAO;
import dao.PayementDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Cart;
import model.Category;
import model.Payement;
import model.Product;
import model.Supplier;
import model.User;
@Configuration
@EnableTransactionManagement
public class SpringConfiguration {
	
	 @Bean("dataSource")
	 public DataSource getH2DataSource()
     {
     	System.out.println("Starting of the method getH2DataSource");
     	DriverManagerDataSource dataSource = new DriverManagerDataSource();
     	dataSource.setDriverClassName("org.h2.Driver");
     	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
     	dataSource.setUsername("sa");
     	dataSource.setPassword("");
     	System.out.println("Data source creation");
     	return dataSource;
     }
	  @Bean(name="sessionFactory")
		 public SessionFactory getSessionFactory()
	     {  
	     	System.out.println("------Hibernate Properties----");
	     	Properties prop = new Properties();
	     	prop.setProperty("hibernate.hbm2ddl.auto", "update");
	     	prop.put("hibernate.show_sql", "true");
	     	prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	     	System.out.println("-----Hibernate properties created----");
	     	
	     	System.out.println("----Local session factory builder object creation----");
	     	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
	     	sessionBuilder.addProperties(prop);
	     	System.out.println("-----Factory builder object created----");
	     	sessionBuilder.addAnnotatedClass(Product.class);
	     	sessionBuilder.addAnnotatedClass(Category.class);
	     	sessionBuilder.addAnnotatedClass(Supplier.class);
	     	sessionBuilder.addAnnotatedClass(User.class);
	     	sessionBuilder.addAnnotatedClass(Cart.class);
	     	sessionBuilder.addAnnotatedClass(Payement.class);
	     	System.out.println("Session factory object creation");
	     	SessionFactory sessionFactory = sessionBuilder.buildSessionFactory();
	     	System.out.println("Session factory object created");
	     	return sessionFactory;  	
	     }
	  @Bean("txManager")
	  public HibernateTransactionManager getTransactionManager()
	  {
		  HibernateTransactionManager manager=new HibernateTransactionManager(getSessionFactory());
	    return manager;
	  }
	  @Bean("productDAO")
	  public ProductDAO getProductDAO()
	  {
		  ProductDAOImpl daoimpl=new ProductDAOImpl();
		  return daoimpl;
	  }
	  
	  @Bean("categoryDAO")
	  public CategoryDAO getCategoryDAO()
	  {
		  CategoryDAOImpl catimpl=new CategoryDAOImpl();
		  return catimpl;
	  }
	  @Bean("supplierDAO")
	  public SupplierDAO getSupplierDAO()
	  {
		  SupplierDAOImpl supimpl=new SupplierDAOImpl();
		  return supimpl;
	  }
	  @Bean("userDAO")
	  public UserDAO getUserDAO()
	  {
		  UserDAOImpl useimpl=new UserDAOImpl();
		  return useimpl;
	  }
	  @Bean("cartDAO")
		public CartDAO getCartDAO()
		{
		  CartDAOImpl cimpl=new CartDAOImpl();
			return cimpl;
		}
	  @Bean("payementDAO")
		public PayementDAO getPayementDAO()
		{
		  PayementDAOImpl payimpl=new PayementDAOImpl();
			return payimpl;
		}
}
