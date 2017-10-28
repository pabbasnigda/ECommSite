package com.frontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CardDAO;
import com.niit.dao.CartDAO;
import com.niit.dao.CheckOutDAO;
import com.niit.dao.OrderDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Card;
import com.niit.model.User;



@Controller
public class CheckOutController 
{
	@Autowired
	CheckOutDAO checkOutDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	CardDAO cardDAO;
	
	@RequestMapping(value = "checkout")
	public String CheckoutPage(@ModelAttribute("card")Card card,Model model)
	{
	//	model.addAttribute("total", checkOutDAO.getTotal(userid));
		return "CheckOut";	
	}

		
	@RequestMapping(value="/invoice",method=RequestMethod.POST)
	public String InvoicePage(@ModelAttribute ("card") Card card, HttpSession session, Model model)
	{
		int charges=99;
		int userid = (Integer) session.getAttribute("userid");
		cartDAO.getCartById(userid);
		card.setCard_userid(userid);
		cardDAO.saveCard(card);
		orderDAO.OrderDetails();
		
	   	
		model.addAttribute("user", userDAO.getUserById(userid));
    	model.addAttribute("cd", cartDAO.getCartById(userid));
    	model.addAttribute("total",checkOutDAO.getTotal(userid));
		model.addAttribute("cod", charges);
		cartDAO.removeCartById(userid);
		return "Invoice";
	}
	
	
	@RequestMapping(value="/CodInvoice",method=RequestMethod.POST)
	public String CodInvoicePage(@ModelAttribute ("card") Card card,HttpSession session, Model model)
	{
		int charges=99;	
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User user = userDAO.get(email);
		
		//int userid=user.getId();
		
		int userid = (Integer) session.getAttribute("userid");
		cartDAO.getCartById(userid);
		orderDAO.OrderDetails();
	
		model.addAttribute("user", userDAO.getUserById(userid));
    	model.addAttribute("cd", cartDAO.getCartById(userid));
    	model.addAttribute("total",checkOutDAO.getTotal(userid));
   
		model.addAttribute("cod", charges);
		cartDAO.removeCartById(userid);
		return "Invoice";
	
	}

}