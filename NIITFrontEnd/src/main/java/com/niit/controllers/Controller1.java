package com.niit.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.backend.DAO.ProductDAO;
import com.backend.model.Product;
 
@Controller
public class Controller1 
{
	String message = "Welcome to Spring MVC!";
 
	@SuppressWarnings("unused")
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/product")
	public String create(String Product)
	{
	   Product product = new Product();
		
		//model.addAttribute("categoryList", categoryDAO.list());
		
		return "Product";
	}
	
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("");
		//mv.addObject("message", message);
		//mv.addObject("name", name);
		return mv;
	}
}
