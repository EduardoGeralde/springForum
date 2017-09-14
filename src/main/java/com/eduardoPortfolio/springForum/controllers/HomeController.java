package com.eduardoPortfolio.springForum.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String executeRegistry (@Valid User user, 
									BindingResult bindingResult, 
									HttpSession session,
						@RequestParam(value="avatar", required=false) MultipartFile avatar){
		if (bindingResult.hasErrors()){
			Map<String, Object> model = new HashMap <String, Object>();
			model.put("user", user);
			return register(model);
		}
		getDAOUser().persist(user);
		
		if (!avatar.isEmpty()){
			processAvatar(user,avatar);
		}
		
		session.setAttribute("user", user);
		return "redirect:/";
	}
	
	private void processAvatar(User user, MultipartFile avatar) {
		File diretorio = new File("/springForum/avatares");
		if (! diretorio.exists()) {
			diretorio.mkdirs();
		}
			try {
				FileOutputStream file = new FileOutputStream(diretorio.getAbsolutePath() + "/" + user.getLogin() + ".png");
				file.write(avatar.getBytes());
				file.close();
			} catch (IOException ex) {
				
			}
		
	}
	

}
