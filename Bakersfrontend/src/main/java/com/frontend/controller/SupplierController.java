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

import com.niit.dao.SupplierDAO;

import com.niit.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="supplier",  method=RequestMethod.GET)
	public String listOfSupplier(@ModelAttribute("supplier") Supplier supplier,  BindingResult result, Model model, 
		                RedirectAttributes redirectAttrs) 
	{
			  List<Supplier> supplierList = supplierDAO.list();
		      model.addAttribute("supplierList", supplierList);
			  return "SupplierPage";
    }
	
	@RequestMapping(value="addSupplier", method=RequestMethod.POST)
    public String addingsupplierStrategy(@ModelAttribute("supplier") Supplier supplier, 
                                 BindingResult result,  
                                 Model model, 
                                 RedirectAttributes redirectAttrs) 
	{
          	supplierDAO.saveSupplier(supplier);
            
            return "redirect:/supplier";
    }	
	
	@RequestMapping("editsupplier/{supplier_id}")
	public String editSupplier(@PathVariable("supplier_id") int supplier_id, Model model,RedirectAttributes attributes) 
	    {
					System.out.println("editSupplier");
					attributes.addFlashAttribute("supplier", this.supplierDAO.getSupplierById(supplier_id));
					return "redirect:/supplier";
	    }
	
	@RequestMapping(value ="removesupplier/{supplier_id}")
	public String removeSupplier(@PathVariable("supplier_id") int supplier_id,RedirectAttributes attributes) throws Exception 
	{
				supplierDAO.removeSupplierById(supplier_id);
				attributes.addFlashAttribute("DeleteMessage", "supplier has been deleted Successfully");
				return "redirect:/supplier";
	}	 
}
