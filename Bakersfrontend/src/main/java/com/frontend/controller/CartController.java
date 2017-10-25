package com.frontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Cart;
import com.niit.model.Product;
import com.niit.model.User;


@Controller
public class CartController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	int userId;
	
	
	User user;
		
	 @RequestMapping(value="addtoCart/{id}")
	 public String addProductToCart(@PathVariable("id") int id,HttpSession session,Model model,RedirectAttributes attributes)
	 {
	    String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userDAO.get(email);
		//int userId = (int) session.getAttribute("userid");	
		userId=user.getId();
	    System.out.println(userId);
	    int q=1;
	    if (cartDAO.getitem(id, userId) != null) 
	    {
				Cart item = cartDAO.getitem(id, userId);		
				item.setProductQuantity(item.getProductQuantity() + q);
				Product p = productDAO.getProductById(id);
				System.out.println(item);
				item.setProductPrice(p.getPrice());
				item.setSubTotal(item.getProductQuantity() *p.getPrice());
				cartDAO.saveProductToCart(item);
				attributes.addFlashAttribute("ExistingMessage",  p.getName() +"is already exist");
		
				return "CartPage";
		 } 
	    else 
	    {
				Cart item = new Cart();
				Product p = productDAO.getProductById(id);
				item.setProductid(p.getId());
				item.setProductName(p.getName());
				item.setUserId(userId);
				item.setProductQuantity(q);
				item.setStatus("C");
				item.setSubTotal(q * p.getPrice());
				item.setProductPrice(p.getPrice());
				cartDAO.saveProductToCart(item);
				attributes.addFlashAttribute("SuccessMessage", "Item"+p.getName()+" has been deleted Successfully");
				return "redirect:/";
	    }
	    	
	 }

	 @RequestMapping("viewcart")
	 public String viewCart(Model model, HttpSession session) 
	 {
	    	String email = SecurityContextHolder.getContext().getAuthentication().getName();
			
			User user = userDAO.get(email);
			
	    	
	    	 userId = user.getId();
	    
			//int userId = (Integer) session.getAttribute("userid");
			model.addAttribute("CartList", cartDAO.listCart());
			 if(cartDAO.cartsize(userId)!=0){
				
				model.addAttribute("CartPrice", cartDAO.CartPrice(userId));
			} else {
				model.addAttribute("EmptyCart", "true");
			}
			model.addAttribute("IfViewCartClicked", "true");
		//	model.addAttribute("HideOthers", "true");
			return "CartPage";
		}



		@RequestMapping("editCart/{cartid}")
		public String editorder(@PathVariable("cartid") int cartid, @RequestParam("quantity") int q, HttpSession session) {


	    	String email = SecurityContextHolder.getContext().getAuthentication().getName();
			
			User user = userDAO.get(email);
			
	    	
	    	 userId = user.getId();

			
			//int userId = (Integer) session.getAttribute("userid");
			Cart cart = cartDAO.editCartById(cartid);
			Product p = productDAO.getProductById(cart.getProductid());
			cart.setProductQuantity(q);
			//cart.setProductPrice(q * p.getPrice());
			cart.setSubTotal(q * p.getPrice());
			cartDAO.saveProductToCart(cart);
			session.setAttribute("cartsize", cartDAO.cartsize(userId));
			return "redirect:/viewcart";
		}
	    
	    
	    
	    
	@RequestMapping(value="removeCart/{id}")
	public String deleteorder(@PathVariable("id") int id, HttpSession session) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User user = userDAO.get(email);
		
		
		 userId = user.getId();

		cartDAO.removeCartById(id);
		session.setAttribute("cartsize",  cartDAO.cartsize(userId));

		return "redirect:/viewcart";
	}
	

	@RequestMapping("continue_shopping")
	public String continueshopping()
	{
	return "redirect:/";	

	}

}