package com.eduardoPortfolio.springForum.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eduardoPortfolio.springForum.models.User;

@Controller
public class AuthenticationController {
	
	@Autowired
	private DAOUser daoUser;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("login")String login, 
						@RequestParam("password")String password,
						HttpSession session){
		
		User user = daoUser.getUser(login,password);
		if(user == null){
			return "loginFail";
		} else {
			user.setLastLogin(new Date());
			daoUser.persist(user);
			session.setAttribute("user", user);
			return "redirect:/";
		}
	}
}
