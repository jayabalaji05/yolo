package com.niit.suggestioncartfrontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.suggestioncartbackend.dao.ProductDAO;
import com.niit.suggestioncartbackend.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/addproduct",method=RequestMethod.GET)
	public String listPersons(Model model)
	{
		model.addAttribute("product",new Product());
		System.out.println("inside productcontroller");
		
		model.addAttribute("listProduct",productDAO.listProduct());
		return "addproduct";
	}
	
	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product,BindingResult result,HttpServletRequest request,@RequestParam("id") int id)
	{
		
		String filename = null;
		byte[] bytes;
		
		if (!product.getImage().isEmpty()) {

			try {
				
				bytes = product.getImage().getBytes();
				productDAO.addProduct(product);
				System.out.println("Data Inserted");
				String path = request.getSession().getServletContext().getRealPath("/resources/images/" + product.getId() + ".jpg");
				System.out.println("Path = " + path);
				System.out.println("File name = " + product.getImage().getOriginalFilename());
				File f = new File(path);
				BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(f));
				bs.write(bytes);
				bs.close();
				System.out.println("Image uploaded");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		if(result.hasErrors())
		{
			return "addproduct";
		}
		else{
			if (product.getId() == id) {
				productDAO.addProduct(product);
			} else {
				productDAO.updateProduct(product);
			}

			return "redirect:/addproduct";
		}
		
	}

		@RequestMapping("/removeid1/{id}")
		public String removeProduct(@PathVariable("id") int id)
		{
			productDAO.removeProduct(id);
			return "redirect:/addproduct";
		}
		
		@RequestMapping("/editid1/{id}")
		public String editProduct(@PathVariable("id") int id, Model model)
		{
			model.addAttribute("product", productDAO.getProductById(id));
	        model.addAttribute("listProduct", productDAO.listProduct());
	        return "addproduct";
		}

}
