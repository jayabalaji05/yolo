	package com.niit.shoppingfrontend.controller;
	
	import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		public String validate(@RequestParam("userID")String userID,@RequestParam("password") String pwd,HttpSession Session)
		{
			if((userID.equals("niit") && pwd.equals("niit"))||(userID.equals("admin")&&pwd.equals("admin")))
			{
				Session.setAttribute("SuccessMessage","Login Successful");
			}
			else
			{
				Session.setAttribute("ErrorMessage","Invalid Credentials");
			}
			return "supplier";
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
		@RequestMapping("/mobile_phones")
		public String products()
		{
			return "product";
		}
		@RequestMapping("/suggestion_cart")
		public String suggestion()
		{
			return "suggestion";
		}
		@RequestMapping("/logout")
		public String logout(HttpSession Session, HttpServletResponse response){
			response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
			response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
			response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
			Session.invalidate();
			return "home";
		}
		@RequestMapping("/wedding_suggestion")
		public String wedding()
		{
			return "suggestion1";
		}
		@RequestMapping("/birthday_suggestion")
		public String birthday()
		{
			return "suggestion2";
		}
	}
