package com.niit.shoppingfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.model.RegisterDetails;
import com.niit.shoppingcart.daoimpl.RegisterDetailsDAOImpl;

@Controller
public class LoginController {
@Autowired
RegisterDetailsDAOImpl rdao;
@RequestMapping(value="/registeration",method=RequestMethod.GET)
public ModelAndView submitregister(@ModelAttribute("Register")RegisterDetails register) {
	System.out.println("Entered submit register");
	ModelAndView model=new ModelAndView("home");
	return model;
}
@RequestMapping(value="/registeration",method=RequestMethod.POST)
public ModelAndView sucess(RegisterDetails reg,Model m) {
	rdao.adduser(reg);
	ModelAndView model=new ModelAndView("home","home",new RegisterDetails());
	return model;
}

}