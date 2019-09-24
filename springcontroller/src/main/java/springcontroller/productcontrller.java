package springcontroller;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.SupplierDAO;
import model.Category;
import model.Product;
import model.Supplier;
@Controller
public class productcontrller {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@ModelAttribute("addproduct")
	public Product getProduct()
	{
		return new Product();
	}
	@RequestMapping("/ProductDetails")
	public String getProductDetails(Model model,HttpServletRequest request)
	{
		java.util.List<Product> productlist=productDAO.getAllProducts();
     	 model.addAttribute("productlist", productlist);
		String id=request.getParameter("productid");
		java.util.List<Category> categorylist=categoryDAO.getAllCategorys();
		model.addAttribute("categorylist",categorylist);
		java.util.List<Supplier> supplierlist=supplierDAO.getAllSupplier();
		model.addAttribute("supplierlist",supplierlist);
		if(id!=null)
		{
			int pid=Integer.parseInt(id);
			Product p=productDAO.find(pid);
           model.addAttribute("currproduct",p);   
           return "editproduct";
		}
		 return "ProductDetails";
	}
	@RequestMapping(value="addproduct",method=RequestMethod.POST)
	public String addProduct(Product product)
	{
		productDAO.addProduct(product);
				
		try {
		//byte[ bt=image.getBytes();
		//	productDAO.addProduct(product);
			MultipartFile image=(MultipartFile)product.getImage();
			byte[] bt=new byte[(int)image.getSize()];
			try {
				InputStream i=image.getInputStream();
				i.read(bt);
				FileOutputStream f=new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\springcontroller\\src\\main\\webapp\\resources\\images\\"+product.getProductid()+".jpg");
				f.write(bt);
				f.flush();
			}
			catch(Exception e) {
			      System.out.println(e);
			}
		System.out.println(bt);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "redirect:ProductDetails";	
	}
	@RequestMapping(value="updateproduct",method=RequestMethod.POST)
	public String updateProduct(Product product)
	{
		   
		int productid=product.getProductid();
	   Product p=productDAO.find( productid);
	   p.setCategoryId(product.getCategoryId());
	   p.setSupplierId(product.getSupplierId());
	   p.setPrice(product.getPrice());
	   p.setDescription(product.getDescription());
	   p.setQuantity(product.getQuantity());
	   p.setProductName(product.getProductName());
	   productDAO.updateProduct(p);
		try {
		//byte[ bt=image.getBytes();
		//	productDAO.addProduct(product);
			MultipartFile image=(MultipartFile)product.getImage();
			byte[] bt=new byte[(int)image.getSize()];
			try {
				InputStream i=image.getInputStream();
				i.read(bt);
				FileOutputStream f=new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\springcontroller\\src\\main\\webapp\\resources\\images\\"+product.getProductid()+".jpg");
				f.write(bt);
				f.flush();
			}
			catch(Exception e) {
			      System.out.println(e);
			}
		System.out.println(bt);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "redirect:ProductDetails";	
	}
 @RequestMapping("/deleteproduct")
 public String deleteproduct(HttpServletRequest request)
 {
	 int id=Integer.parseInt(request.getParameter("productid"));
    Product pr=productDAO.find(id);
    productDAO.deleteProduct(pr);
    return "redirect:ProductDetails";
 }
}