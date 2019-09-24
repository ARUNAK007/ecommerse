package springcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.CategoryDAO;
import model.Category;

@Controller
public class categorycontroller {
	@Autowired
	CategoryDAO categoryDAO;
	@ModelAttribute("addcategory")
		public Category getCategory() {
		return new Category();
		
	}
	@RequestMapping("/categorydetails")
	public String getCategoryPage(Model model,HttpServletRequest request)
	{
		
		java.util.List<Category> categorylist=categoryDAO.getAllCategorys();
    	 model.addAttribute("categorylist", categorylist);
 		String id=request.getParameter("categoryId");
 	
 		if(id!=null)
 		{
 			int pid=Integer.parseInt(id);
 			Category p=categoryDAO.find(pid);
            model.addAttribute("currcategory",p);   
            return "editcategory";

 		}

		
		return "categorydetails";
	}
	@RequestMapping(value="updatecategory",method=RequestMethod.POST)
	public String updateProduct(Category category)
	{
		int categoryId=category.getCategoryId();
	   Category p=categoryDAO.find(categoryId);
	   p.setCategoryId(category.getCategoryId());
	   p.setCategoryname(category.getCategoryname());
	   categoryDAO.updateCategory(p);
	   return "redirect:categorydetails";
	}
	
	@RequestMapping(value="addcategory",method=RequestMethod.POST)
	public String addcategory(@Valid @ModelAttribute("addcategory")Category category,Errors errors,Model model,HttpServletRequest request)
	{ 
		System.out.println(errors.hasErrors());
		if(errors.hasErrors()) {
		List<Category> categorylist=categoryDAO.getAllCategorys();
		model.addAttribute("categorylist",categorylist);
		String id=request.getParameter("categoryId");
		return "categorydetails";
		}
		categoryDAO.addCategory(category);
		return "redirect:categorydetails";
	}
	@RequestMapping("/deleteCategory")
	 public String deleteproduct(HttpServletRequest request)
	 {
		 int id=Integer.parseInt(request.getParameter("categoryId"));
	    Category pr=categoryDAO.find(id);
	    categoryDAO.deleteCategory(pr);
	    return "redirect:categorydetails";
	 }

}
