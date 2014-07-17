package com.xy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/loginController")
@SessionAttributes("user")
public class LoginController {

	@RequestMapping(value="/login")
	public String login(Model model){
		return "main";
	}
	
	@RequestMapping(value="/crudGrid")
	public String crudGrid(Model model){
		return "crud-grid";
	}
}
