package springcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.SupplierDAO;
import model.Product;
import model.Supplier;

@Controller
public class SupplierController {
@Autowired
SupplierDAO supplierDAO;
	@ModelAttribute("addsupplier")
	public Supplier getSupplier()
	{
		return new Supplier();
	}
	@RequestMapping("/Supplier")
	public String getSupplierPage(Model model,HttpServletRequest request)
	{
		java.util.List<Supplier> supplierlist=supplierDAO.getAllSupplier();
    	 model.addAttribute("supplierlist", supplierlist);
 		String id=request.getParameter("supplierId");
 	
 		if(id!=null)
 		{
 			int pid=Integer.parseInt(id);
 			Supplier p=supplierDAO.find(pid);
            model.addAttribute("currsupplier",p);   
            return "editsupplier";

 		}

		
		return "Supplier";
	}
	@RequestMapping(value="updatesupplier",method=RequestMethod.POST)
	public String updateSupplierDetails(Supplier supplier)
	{
		int supplierId=supplier.getSupplierId();
	   Supplier p=supplierDAO.find(supplierId);
	   p.setSupplierId(supplierId);
	   p.setSuppliername(supplier.getSuppliername());
	   p.setSupplieraddress(supplier.getSupplieraddress());
	   supplierDAO.updateSupplierDetails(supplier);
		
	   return "redirect:Supplier";
	}
	
	@RequestMapping(value="addsupplier",method=RequestMethod.POST)
	public String addSupplier(Supplier supplier)
	{
		supplierDAO.addSupplier(supplier);
		return "redirect:Supplier";
	}
	@RequestMapping("/deleteSupplierDetails")
	 public String deleteSupplier(HttpServletRequest request)
	 {
		 int id=Integer.parseInt(request.getParameter("supplierId"));
	    Supplier pr=supplierDAO.find(id);
	    supplierDAO.deleteSupplierDetails(pr);
	    return "redirect:Supplier";
	 }

}
