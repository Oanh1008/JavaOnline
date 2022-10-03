package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;

import com.model.UserModel;

@Controller
public class UserController {
	@GetMapping("/login")
	public String viewLoginPage() {
		String sessionId=RequestContextHolder.currentRequestAttributes().getSessionId();
		System.out.println("Signin Controller: "+sessionId);
		return "login";
	}
	@GetMapping("/user/register")
	public String registerUser(Model model) {
		UserModel user = new UserModel();
		model.addAttribute("user", user);
		return "register";
	}
}
