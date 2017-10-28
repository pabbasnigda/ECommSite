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
	
	
	User user;
		
	 @RequestMapping(value="addtoCart/{id}")
	 public String addProductToCart(@PathVariable("id") int id,HttpSession session,Model model,RedirectAttributes attributes)
	 {
	    String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userDAO.get(email);
		int userid = (Integer) session.getAttribute("userid");	
		userid=user.getId();
	    System.out.println(userid);
	    int q=1;
	    if (cartDAO.getitem(id, userid) != null) 
	    {
				Cart item = cartDAO.getitem(id, userid);		
				item.setQuantity(item.getQuantity() + q);
				Product p = productDAO.getProductById(id);
				System.out.println(item);
				item.setProductprice(p.getPrice());
				item.setSubTotal(item.getProductprice() *p.getPrice());
				cartDAO.saveProductToCart(item);
				attributes.addFlashAttribute("ExistingMessage",  p.getName() +"is already exist");
		
				return "CartPage";
		 } 
	    else 
	    {
				Cart item = new Cart();
				Product p = productDAO.getProductById(id);
				item.setProductid(p.getId());
				item.setProductname(p.getName());
				item.setUserid(userid);
				item.setQuantity(q);
				item.setStatus("C");
				item.setSubTotal(q * p.getPrice());
				item.setProductprice(p.getPrice());
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
			
	    	
			int userid = user.getId();
	    
			//int userId = (Integer) session.getAttribute("userid");
			model.addAttribute("CartList", cartDAO.getCart(userid));
			 if(cartDAO.cartsize(userid)!=0){
				
				model.addAttribute("CartPrice", cartDAO.CartPrice(userid));
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
			
	    	
	    	// userId = user.getId();

			
			int userid = (Integer) session.getAttribute("userid");
			Cart cart = cartDAO.editCartById(cartid);
			Product p = productDAO.getProductById(cart.getProductid());
			cart.setQuantity(q);
			//cart.setProductPrice(q * p.getPrice());
			cart.setSubTotal(q * p.getPrice());
			cartDAO.saveProductToCart(cart);
			session.setAttribute("cartsize", cartDAO.cartsize(userid));
			return "redirect:/viewcart";
		}
	    
	    
	    @RequestMapping(value="removeCart/{id}")
		public String deleteorder(@PathVariable("id") int id, HttpSession session) 
		{
			cartDAO.removeCartById(id);
			session.setAttribute("cartsize", cartDAO.cartsize((Integer) session.getAttribute("userid")));
			return "redirect:/viewcart";
		}
	

	    @RequestMapping("continue_shopping")
	    public String continueshopping()
	    {
	    	return "loggedin";	

	    }
	    
	    
}