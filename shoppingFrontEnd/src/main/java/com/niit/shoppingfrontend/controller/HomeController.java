	package com.niit.shoppingfrontend.controller;
	
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	
	@Controller
	public class HomeController {
		
		@RequestMapping("/")
		public String gotohome()
		{
			return "home";
					
		}
		@RequestMapping("/home")
		public String home()
		{
			return "home";
		}
		
		@RequestMapping("/home1")
		public String logging()
		{
			return "welcome";
		}
		@RequestMapping("/welcome")
		public String validate(@RequestParam("userID")String userID,@RequestParam("password") String pwd,Model model)
		{
			if(userID.equals("niit") && pwd.equals("niit"))
			{
				model.addAttribute("SuccessMessage","Login Successful");
			}
			else
			{
				model.addAttribute("ErrorMessage","Invalid Credentials");
			}
			return "index";
		}
		@RequestMapping("/login")
		public String login( Model model)
		{
		model.addAttribute("userClickedLogin","true");	
		return "login";
		}
		@RequestMapping("/registration")
		public String registeration()
		{
			return "registration";
		}
		@RequestMapping("/products")
		public String products()
		{
			return "product";
		}
	}
