package controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	public DAOUser getDaoUser() {
		return daoUser;
	}

	public void setDaoUser(DAOUser daoUser) {
		this.daoUser = daoUser;
	}

	public DAOTopic getDaoTopic() {
		return daoTopic;
	}

	public void setDaoTopic(DAOTopic daoTopic) {
		this.daoTopic = daoTopic;
	}
	
	

}
