package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.form.LoginForm;

@Controller
public class LoginController {
	
	//to get login form page
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm() {
		//return html page name
		return "login"; 
	}
	//checking for login credentials 
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginform") LoginForm loginForm, Model model ) {
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		if("admin".equals(username) && "admin".equals(password)) {
			return "home";
		}
		model.addAttribute("invalidCredentials", true);
		return "login";
	}
}
