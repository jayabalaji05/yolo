package com.niit.shoppingfrontend.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.model.Supplier;

@Controller
public class SupplierController {
	@Autowired	
	SupplierDAO cdao;
	public String getdata()
	{
		ArrayList list=(ArrayList) cdao.list();
		Gson gson = new Gson();
		String jsonInString = gson.toJson(list);
		return jsonInString;
	}
	
	// INSERT INTO DATABASE
	@RequestMapping(value="/Supplier",method=RequestMethod.GET)
	public ModelAndView DisplaySupplier(Model m)
	{
		ModelAndView mv=new ModelAndView("addSupplier","supplier",new Supplier());
		return mv;		
	}
	
	@RequestMapping(value="/addSupplier",method=RequestMethod.POST)
	public ModelAndView addSupplier(Supplier supplierId,Model m)
	{
		
		System.out.println("1");
		cdao.save(supplierId);

		System.out.println("2");
		m.addAttribute("list", getdata());

		System.out.println("3");
		ModelAndView mv=new ModelAndView("displaysupplier","supplier",new Supplier());
		System.out.println("4");
		
		System.out.print("Added successfully");
		return mv;
		
	}
	
	// VIEW THE DATAS IN H2 DB
	@RequestMapping(value="/viewSupplier",method=RequestMethod.GET)
	public ModelAndView viewSupplier(Model m)
	{
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("displaysupplier","supplier",new Supplier());
		return mv;
	}
	
	//EDIT VALUES FROM H2 DATABASE
	@RequestMapping(value="/editSupplier",method=RequestMethod.GET)
	public ModelAndView editSupplier(@RequestParam("Id")String supplierId,Model m)
	{
			
		Supplier c=cdao.get(supplierId);
		m.addAttribute("Supplier",c);
		ModelAndView mv=new ModelAndView("editsupplier","Supplier",c);
		return mv; 
			
	}
	
	@RequestMapping(value="/editSupplier",method=RequestMethod.POST)
	public ModelAndView editSupplier(Supplier supplier,Model m)
	{
		System.out.println(supplier.getId());
	    System.out.println(supplier.getName());
		//System.out.println("Added to database");
		cdao.update(supplier);
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("displaysupplier","Supplier",new Supplier());
		return mv;
	}
	
		
	// DELETE VALUES FROM H2 DATABASE
	@RequestMapping(value="/delsupplier",method=RequestMethod.GET)
	public ModelAndView delSupplier(@RequestParam("Id") Supplier supplierId,Model m)
	{
		cdao.delete(supplierId);
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("displaysupplier","displaysupplier",new Supplier());
		return mv;
	}

	// DISPLAYS VALUES FROM H2 DATABASE
	@RequestMapping(value="/displaysupplier",method=RequestMethod.GET)
	public String getSupplier(Model m)
	{
		m.addAttribute("list", getdata());
		return "displaysupplier";
	}
	
	
	
}
