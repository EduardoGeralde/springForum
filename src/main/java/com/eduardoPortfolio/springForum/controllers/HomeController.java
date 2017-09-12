package com.eduardoPortfolio.springForum.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduardoPortfolio.springForum.models.User;

@Controller
public class HomeController {
	
	@Autowired
	private DAOUser daoUser;
	@Autowired
	private DAOTopic daoTopic;
	
	@RequestMapping("/")
	public String index(Map<String, Object>model){
		model.put("topics", getDAOTopic().list());
		model.put("users", getDAOUser().list());
		
		return "index";
	}

	@RequestMapping("/register")
	public String register(Map<String,Object> model){
		if(model.get("user")==null){
			model.put("user", new User());
		}
		return "register";
	}
	
	@RequestMapping(value="/executeRegistry", method=RequestMethod.POST)
	public String executeRegistry (@Valid User user, BindingResult bindingResult, 
																HttpSession session){
		if (bindingResult.hasErrors()){
			Map<String, Object> model = new HashMap <String, Object>();
			model.put("user", user);
			return register(model);
		}
		getDAOUser().persist(user);
		session.setAttribute("user", user);
		return "redirect:/";
	}
	

}
