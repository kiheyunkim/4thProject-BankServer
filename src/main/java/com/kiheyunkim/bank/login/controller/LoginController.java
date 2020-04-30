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
		String userId = (String) received.get("userid");
		String password = (String) received.get("password");

		Boolean result = loginService.checkLogin(userId, password);
		
		//결과에 따른 해석
		return "";
	}
	
	@GetMapping(path = {"/signup"})
	public String getSignup() {
		return "";
	}
	
	@PostMapping(path = {"/signup"})
	public String postSignup(@RequestBody HashMap<String, Object> received, Model model) {
		String userId = (String) received.get("userid");
		String password1 = (String) received.get("password1");
		String password2 = (String) received.get("password2");
		
		
		int resultType = loginService.CheckSignUp(userId, password1, password2);
		
		return "";
	}
	
}
