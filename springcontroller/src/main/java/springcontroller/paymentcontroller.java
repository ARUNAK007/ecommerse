package springcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.CartDAO;
import dao.PayementDAO;
import model.Cart;
import model.Payement;

@Controller
public class paymentcontroller {
	@Autowired
	PayementDAO payementDAO;
	@Autowired
	CartDAO cartDAO;

	  @RequestMapping("/paymentdetails")
	   public String viewCart(HttpSession session,Model model)
	   {
		   String username=(String)session.getAttribute("username");
		   java.util.Date dt=new java.util.Date();
		   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
				   java.util.List<Cart> cartlist=cartDAO.getAllCarts(cartid);

				   float sum=0;
				   for(Cart c:cartlist)
				   {
					   sum=sum+c.getPrice();
				   }
			     model.addAttribute("carttotal",sum);
		   return "paymentdetails";
	   }
	  @RequestMapping(value="add", method=RequestMethod.POST)
	   public String addPayement(Payement p,HttpSession session)
	   {
		  String username=(String)session.getAttribute("username");
		  java.util.Date dt=new java.util.Date();
		  String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
		  p.setCartId(cartid);
			payementDAO.addPayement(p);
			
			return "redirect:invoice";
}
}