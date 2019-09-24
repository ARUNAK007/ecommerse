package springcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CartDAO;
import dao.PayementDAO;
import model.Cart;
import model.Payement;

@Controller
public class invoicecontroller {
@Autowired
PayementDAO payementDAO;
@Autowired
CartDAO cartDAO;
@RequestMapping("/invoice")
public String viewCart(HttpSession session,Model model,HttpServletRequest request)
{
String username=(String)session.getAttribute("username");
java.util.Date dt=new java.util.Date();
String cartid= dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
//java.util.List<Payement> p=payementDAO.getAllPayements(cartid);
Payement p=payementDAO.find(cartid);

float sum=0;
sum=p.gettotal();
 String shippingaddress=p.getShippingaddress();
  model.addAttribute("carttotal",sum);
  model.addAttribute("shippingaddress",shippingaddress);
p.setCartId(cartid);
Cart cart=cartDAO.find(cartid);
   cartDAO.deleteCart(cart);
return "invoice";
}
}
