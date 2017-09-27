package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Controller1
{
	//@RequestMapping(value= "/saveProduct", method = RequestMethod.POST)
	//public String ProductList(@ModelAttribute("product") , ProductList product)
	//@RequestMapping(value = "/product", method = RequestMethod.POST)
	 /* public ModelAndView employee() 
	  {
	    return new ModelAndView("productList", "command", new product());
	  }
	    
	  @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	  public String addProduct(@ModelAttribute("product")ProductList product, ModelMap model) {
	     model.addAttribute("name", product.getName());
	     model.addAttribute("age", product.getQuantity());
	     model.addAttribute("salary", product.getSalary());
	     return "employeeDetail";
	   }
	*/
}	
	
	


