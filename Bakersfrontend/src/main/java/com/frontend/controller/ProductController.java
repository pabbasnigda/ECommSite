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

import com.niit.dao.ProductDAO;
import com.niit.model.Product;


@Controller
public class ProductController {

		@Autowired
		ProductDAO productDAO;

	
		 @RequestMapping(value="product",  method=RequestMethod.GET)
		    public String listOfProduct(@ModelAttribute("product") Product product,  BindingResult result,  
	                Model model, 
	                RedirectAttributes redirectAttrs) {
		    
		        List<Product> productList = productDAO.list();
		        model.addAttribute("productList", productList);
		       // model.addAttribute("ProductPageClicked", "true");
		        
		       return "ProductPage";
		    }
		     
		    @RequestMapping(value="addProduct", method=RequestMethod.POST)
		    public String addingProductStrategy(@ModelAttribute("product") Product product, 
		                                 BindingResult result,  
		                                 Model model, 
		                                 RedirectAttributes redirectAttrs) {
		         
		    	productDAO.saveProduct(product);
		            //String message = "Product" + Product.getid()+ " was successfully added";
		          //  model.addAttribute("message", message);
		            return "redirect:/product";
		        
		    }	
		    
			
			@RequestMapping("editproduct/{id}")
			public String editProduct(@PathVariable("id") int id, Model model,RedirectAttributes attributes) {
				System.out.println("editProduct");
				attributes.addFlashAttribute("product", this.productDAO.getProductById(id));
				return "redirect:/category";
			}
			@RequestMapping(value ="removeproduct/{id}")
			public String removeProduct(@PathVariable("id") int id,RedirectAttributes attributes) throws Exception {
				productDAO.removeProducyById(id);
				attributes.addFlashAttribute("DeleteMessage", "Product has been deleted Successfully");
				return "redirect:/product";
			}	    
		
	}