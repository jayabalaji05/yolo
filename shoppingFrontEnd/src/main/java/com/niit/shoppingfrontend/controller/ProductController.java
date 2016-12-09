package com.niit.shoppingfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.model.Product;

@Controller
public class ProductController {
	@Autowired(required=true)
	private ProductDAO productDAO;
	
	@Autowired(required=true)
	private Product product;
	
	
	@RequestMapping(value="/product")
	public String listproduct(Model model)
	{
	model.addAttribute("product",product);
	model.addAttribute("productList",this.productDAO.list());
	return "product";
	}
	
	
	@RequestMapping(value="/addproduct")
	public String addproduct(@ModelAttribute("product") Product product,Model model)
	{
		String newid = product.getId();
		product.setId(newid);
	
		productDAO.save(product);
	/*model.addAttribute("category", category);
	model.addAttribute("categoryList", this.categoryDAO.list());*/
		
	return "redirect:/product";
    }

	
	
	@RequestMapping("/removeproduct/{id}")
	public String deleteProduct(@PathVariable("id") Product id, ModelMap model)
	
	{
		System.out.println("delete");
		productDAO.delete(id);
		return "redirect:/product";
	}
	
	
	@RequestMapping("/editproduct/{id}")
	public String editProduct(@PathVariable("id")String id, Model model)
	{
		model.addAttribute("product",this.productDAO.get(id));
		/*model.addAttribute("category", category);*/
		model.addAttribute("productList", this.productDAO.list());
		
		return "product";
	}

}
