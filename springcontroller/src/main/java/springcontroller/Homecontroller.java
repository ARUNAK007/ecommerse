package springcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CartDAO;
import dao.PayementDAO;
import dao.ProductDAO;
import dao.UserDAO;
import model.Cart;
import model.Product;
import model.User;

@Controller
public class Homecontroller {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	CartDAO cartDAO;
@RequestMapping("/")
public String getIndex()
	{
	return "index";
	}
@RequestMapping("/header")
public String getHeader(HttpSession session,Model model)
	{

	return "header";
	}

	@RequestMapping("/login")
	public String getlogin()
	{
		return "Login";
	}
	@RequestMapping("/logout")
	public String getlogout(HttpSession session)
	{
	
		
		return "j_spring_security_logout";
	}
	@RequestMapping("/userdetails")
	public String getuser()
	{
		return "userdetails";
	}


	@RequestMapping("/About")
	public String getAbout()
	{
		return "About";
	}

	@RequestMapping("/contact")
	public String getcontact()
	
	{
		return "contact";
	}
	@RequestMapping("/admin")
	public String getAdminHome()
	{
		return "admin";
	}
	
	@RequestMapping("/userhome")
	public String getuserhome(HttpSession session,Model model)
	{
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("username", username);
		java.util.Date dt=new java.util.Date();
		String cartid= dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
		List<Cart> c=cartDAO.getAllCarts(cartid);
		 int i=0;
		   for(Cart total:c)
		   {
			   i=i+1;
		   }
		   model.addAttribute("cartsize",i);
	if(username.equals("anonymousUser")) {
		String name="Profile";
		model.addAttribute("name", name);
	}else
	{
		
		User u=userDAO.findName(username);
		String name=u.getUserName();
		model.addAttribute("name", name);}
		java.util.List<Product> productlist=productDAO.getAllProducts();
		model.addAttribute("productlist", productlist);
		return "userhome";
	}
	@RequestMapping("/error")
	public String getError()
	{
		return "Login";
}
	
}
