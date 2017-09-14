package com.eduardoPortfolio.springForum.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.eduardoPortfolio.springForum.models.User;

@Controller("user")
//Can receive String or String array, and this String have to correspond with the attribute
//that we want to work.
@SessionAttributes("user")
public class UserController {
	
	@RequestMapping("/user/autheticated")
										 //receives the session attribute to work with
	public ModelAndView infoUserAuthenticated (@ModelAttribute("user") User user){
		
		ModelAndView mav = new ModelAndView("user/show");
		mav.getModel().put("user", user);
		return mav;
	}
	
	@RequestMapping("/user/posts/{login}")
	public String userTopics(@PathVariable("login") String login, Map<String,Object>model){
		
		model.put("topics", getDAOTopics.getUserTopics(getUserDAO().getUser(login)));
		return "user/posts";
	}
	
	

}
