package com.niit.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.Product1DAO;
import com.niit.model.Product1;

@SuppressWarnings("unused")
@Controller
public class Controller1
{
	@Autowired
	private Product1DAO productDao;

	public Product1DAO getProductDao() 
	{
		return productDao;
	}

	public void setProductDao(Product1DAO productDao) 
	{
		this.productDao = productDao;
	}
	
	@RequestMapping("/getAllProducts")
	public ModelAndView getAllProducts() 
	{
		List<Product1> products = productDao.getAllProducts();
		return new ModelAndView("productList", "products", products);
	}
	
	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.GET)
	public String getProductForm(Model model) 
	{
		Product1 product = new Product1();
		product.setP_category("CHOCOLATE");
		model.addAttribute("productFormObj", product);
		return "addProduct";

	}

	@RequestMapping("/getProductsList")
	public @ResponseBody List<Product1> getProductsListInJson() 
	{
		return productDao.getAllProducts();
	}	
	
}	
	
	


