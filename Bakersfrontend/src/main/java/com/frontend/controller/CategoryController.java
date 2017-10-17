package com.frontend.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;




@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
		
	@RequestMapping(value="category",  method=RequestMethod.GET)
	public String listOfCategory(@ModelAttribute("category") Category category,  BindingResult result, Model model, 
		                RedirectAttributes redirectAttrs) 
	{
			  List<Category> categoryList = categoryDAO.list();
		      model.addAttribute("categoryList", categoryList);
			       // model.addAttribute("CategoryPageClicked", "true");
			        
			  return "CategoryPage";
    }
			     
			    @RequestMapping(value="addCategory", method=RequestMethod.POST)
			    public String addingcateogoryStrategy(@ModelAttribute("category") Category category, 
			                                 BindingResult result,  
			                                 Model model, 
			                                 RedirectAttributes redirectAttrs) {
			         
			           	categoryDAO.saveCategory(category);
			            //String message = "Category " + category.getCid()+ " was successfully added";
			          //  model.addAttribute("message", message);
			            return "redirect:/category";
			        
			    }	
			    
				
	    @RequestMapping("editcategory/{category_id}")
		public String editCategory(@PathVariable("category_id") int category_id, Model model,RedirectAttributes attributes) 
	    {
					System.out.println("editCategory");
					attributes.addFlashAttribute("category", this.categoryDAO.getCategoryById(category_id));
					return "redirect:/category";
	    }
				
		@RequestMapping(value ="removecategory/{category_id}")
		public String removeCategory(@PathVariable("category_id") int category_id,RedirectAttributes attributes) throws Exception 
		{
					categoryDAO.removeCategoryById(category_id);
					attributes.addFlashAttribute("DeleteMessage", "Category has been deleted Successfully");
					return "redirect:/category";
		}	    
			
}


