package com.frontend.controller;


import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController 
{
		@Autowired
		ProductDAO productDAO;

		@Autowired
		CategoryDAO categoryDAO;
		
		@Autowired
		SupplierDAO supplierDAO;
	
		@SuppressWarnings("unused")
		@RequestMapping(value="product",  method=RequestMethod.GET)
		public String listOfProduct(@ModelAttribute("product") Product product,  BindingResult result,  
	                Model model, 
	                RedirectAttributes redirectAttrs) 
		{    
		        List<Product> productList = productDAO.list();
		        model.addAttribute("productList", productList);
		        List<Category>categotyList = categoryDAO.list();
		        model.addAttribute("categoryList", categoryDAO.list());
		        List<Supplier>csupplierList = supplierDAO.list();
		        model.addAttribute("supplierList", supplierDAO.list());
		       // model.addAttribute("ProductPageClicked", "true");
		        
		       return "ProductPage";
		 }
		     
/*		 @RequestMapping(value="/saveProduct")
			public String updateproduct(@ModelAttribute("product") Product product,HttpServletRequest request,Model m,
					@RequestParam("file") MultipartFile file){
				
				String image=uploadFile(file);
				//log.info("Server File Location="	+ image
				if(!image.isEmpty())
				{
					product.setImage(image);
					
				}
					product.setInstock(true);
					  productDAO.saveProduct(product);
				
				
		        return "redirect:/product";
			}
*/			
			
			
			
			/*
			public  String uploadFile(MultipartFile file)
			{
				String name=null;
				if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();
						// Creating the directory to store file
						String rootPath = System.getProperty("catalina.base");
						File dir = new File(rootPath +"This PC/Desktop");
						if (!dir.exists())
							dir.mkdirs();
						  name=String.valueOf(new Date().getTime()+".jpg");
						 // Create the file on server
						File serverFile = new File(rootPath + File.separator);
						BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();
					//	log.info("Server File Location="	+ serverFile.getAbsolutePath());
						return  name;
					} catch (Exception e) {
						return "You failed to upload " + name + " => " + e.getMessage();
					}
				} else {
					return "You failed to upload " + name+ " because the file was empty.";
				}
			}
*/		   



		 @RequestMapping(value="addProduct",method = RequestMethod.POST)
		 public String addItem(@ModelAttribute("product") Product p,@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException
		 {
			 	p.setImage(file.getBytes());
			 	this.productDAO.saveProduct(p);
			 	return "redirect:product";
	
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