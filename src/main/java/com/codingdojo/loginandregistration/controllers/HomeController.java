package com.codingdojo.loginandregistration.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userServ;

	@RequestMapping(value={"/", "", "/home"})
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/login";
		} else {
			User currentUser = userServ.findOneUser(userId);
			model.addAttribute("currentUser", currentUser);
		}
		return "Home.jsp";
	}

}
