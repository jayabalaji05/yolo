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
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.model.Category;

@Controller
public class CategoryController {
	@Autowired	
	CategoryDAO cdao;
	public String getdata()
	{
		ArrayList list=(ArrayList) cdao.list();
		Gson gson = new Gson();
		String jsonInString = gson.toJson(list);
		return jsonInString;
	}
	
	// INSERT INTO DATABASE
	@RequestMapping(value="/Category",method=RequestMethod.GET)
	public ModelAndView DisplayCategory(Model m)
	{
		ModelAndView mv=new ModelAndView("addCategory","category",new Category());
		return mv;		
	}
	
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public ModelAndView addCategory(Category categoryId,Model m)
	{
		
		System.out.println("1");
		cdao.save(categoryId);

		System.out.println("2");
		m.addAttribute("list", getdata());

		System.out.println("3");
		ModelAndView mv=new ModelAndView("displaycategory","category",new Category());
		System.out.println("4");
		
		System.out.print("Added successfully");
		return mv;
		
	}
	
	// VIEW THE DATAS IN H2 DB
	@RequestMapping(value="/viewCategory",method=RequestMethod.GET)
	public ModelAndView viewCategory(Model m)
	{
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("displaycategory","category",new Category());
		return mv;
	}
	
	//EDIT VALUES FROM H2 DATABASE
	@RequestMapping(value="/editCategory",method=RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam("Id")String categoryId,Model m)
	{
			
		Category c=cdao.get(categoryId);
		m.addAttribute("Category",c);
		ModelAndView mv=new ModelAndView("editcategory","category",c);
		return mv; 
			
	}
	
	@RequestMapping(value="/editCategory",method=RequestMethod.POST)
	public ModelAndView editCategory(Category category,Model m)
	{
		System.out.println(category.getId());
	    System.out.println(category.getName());
		//System.out.println("Added to database");
		cdao.update(category);
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("displaycategory","category",new Category());
		return mv;
	}
	
		
	// DELETE VALUES FROM H2 DATABASE
	@RequestMapping(value="/delCategory",method=RequestMethod.GET)
	public ModelAndView delCategory(@RequestParam("Id") Category categoryId,Model m)
	{
		cdao.delete(categoryId);
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("displaycategory","displaycategory",new Category());
		return mv;
	}

	// DISPLAYS VALUES FROM H2 DATABASE
	@RequestMapping(value="/displayCategory",method=RequestMethod.GET)
	public String getCategory(Model m)
	{
		m.addAttribute("list", getdata());
		return "displaycategory";
	}
	
	
	
}
