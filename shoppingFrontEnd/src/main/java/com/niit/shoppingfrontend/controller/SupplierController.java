package com.niit.shoppingfrontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.model.Supplier;


public class SupplierController {
	
	private SupplierDAO SupplierDAO;
	
	@Autowired(required=true)
	@Qualifier(value="SupplierDAO")
	public void setSupplierDAO(SupplierDAO ps){
		this.SupplierDAO = ps;
	}
	
	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public String listSuppliers(Model model) {
		model.addAttribute("Supplier", new Supplier());
		model.addAttribute("SupplierList", this.SupplierDAO.list());
		model.addAttribute("clickedSuppliers","true");
		return "admin";
	}
	
	//For add and update Supplier both
	@RequestMapping(value= "/Supplier/add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("Supplier") Supplier Supplier){
		
	
			SupplierDAO.save(Supplier);
		
		return "redirect:/suppliers";
		
	}
	
	@RequestMapping("Supplier/remove/{id}")
    public String deleteSupplier(@PathVariable("id") Supplier id,ModelMap model) throws Exception{
		
       try {
		SupplierDAO.delete(id);
		model.addAttribute("message","Successfully Added");
	} catch (Exception e) {
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
	}
       //redirectAttrs.addFlashAttribute(arg0, arg1)
        return "redirect:/categories";
    }
 
    @RequestMapping("Supplier/edit/{id}")
    public String editSupplier(@PathVariable("id") String id, Model model){
    	System.out.println("editSupplier");
        model.addAttribute("Supplier", this.SupplierDAO.get(id));
        model.addAttribute("listSuppliers", this.SupplierDAO.list());
        return "Supplier";
    }
	}