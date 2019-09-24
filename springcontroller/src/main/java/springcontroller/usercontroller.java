package springcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.CartDAO;
import dao.UserDAO;
import model.Cart;
import model.Product;
import model.Supplier;
import model.User;

@Controller
public class usercontroller {
	@Autowired
	UserDAO userDAO;
	@Autowired
	CartDAO cartDAO;

	@RequestMapping(value="adduser",method=RequestMethod.POST)
	public String addUser(User user,HttpSession session,Model model)
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
		userDAO.addUser(user);
		return "Login";
	}

}
