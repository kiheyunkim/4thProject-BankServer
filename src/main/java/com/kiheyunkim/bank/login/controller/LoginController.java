package com.kiheyunkim.bank.login.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiheyunkim.bank.login.service.LoginService;

@Controller
@RequestMapping(path = {"/login"})
public class LoginController {

	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@GetMapping(path = {"/login"})
	public String getLogin() {
		return "";
	}
	
	@PostMapping(path = {"/login"})
	public String postLogin(@RequestBody HashMap<String, Object> received, Model model){
		String id = (String) received.get("userid");
		String pw = (String) received.get("password");

		model.addAttribute("", "");
		
		Boolean result = loginService.loginCheck(id, pw);
		
		
		return "";
	}
	
	@GetMapping(path = {"/signup"})
	public String getSignup() {
		return "";
	}
	
	@PostMapping(path = {"/signup"})
	public String postSignup(@RequestBody HashMap<String, Object> received, Model model) {
		String id = (String) received.get("userid");
		String pw = (String) received.get("password");
		
		Boolean result = loginService.loginCheck(id, pw);
		
		return "";
	}
	
}
