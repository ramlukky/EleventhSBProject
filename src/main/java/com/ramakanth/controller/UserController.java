package com.ramakanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ramakanth.entity.UserEntity;
import com.ramakanth.entity.UserLoginEntity;
import com.ramakanth.service.UserLoginService;
import com.ramakanth.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserLoginService userLoginService;

	@GetMapping("/")
	public String getStart(Model model){
		UserLoginEntity userLogin=new UserLoginEntity();
	model.addAttribute("userLogin", userLogin);
	return "index";
	}

	@GetMapping("/register")
	public String userRegister(Model model){
	UserEntity userEntity=new UserEntity();
	model.addAttribute("userEntity", userEntity);
	return "register";
	}

	@PostMapping("/saveuser")
	public String saveUser(Model model, @Valid UserEntity userEntity, BindingResult bindingResult){
	
	if(!bindingResult.hasErrors())
	{
		String email=userEntity.getUserEmail();
		if(!email.equals(userService.findByUserEmail(email))) {
	userService.save(userEntity);
	
	UserLoginEntity userLoginEntity=new UserLoginEntity();
	userLoginEntity.setUserLoginId(userEntity.getUserEmail());
	userLoginEntity.setUserLoginPassword(userEntity.getUserPassword());	
	userLoginService.saveUserLogin(userLoginEntity);
		System.out.println("recored saved: ");
	
		UserLoginEntity userLogin=new UserLoginEntity();
		model.addAttribute("userLogin", userLogin);
		model.addAttribute("msg", "You are successfully registered, please login");
		return "index";
		}
		else {
			model.addAttribute("msg", "you have already registerd/ please use another email ID");
			return "register";
		}
	
	}
	else 
	{
	return "register";
	}
	}

	@PostMapping("/login")
	public String userLogin(Model model, @Valid UserLoginEntity userLogin, BindingResult bindingResult){
	
	String password=userLogin.getUserLoginPassword();
	String email=userLogin.getUserLoginId();
if(bindingResult.hasErrors())
{
	
	System.out.println("has error in login;   sdfsdf");
	model.addAttribute("userLogin", userLogin);
	return "index";
}
else 
	if(password.equals(userLoginService.findByUserLoginId(email)))
	{
		model.addAttribute("userLogin", userLogin);
	return "home";
}

else{
	model.addAttribute("userLogin", userLogin);
	model.addAttribute("msg", "UserId or Password is incorrect");
	return "index";
}


	}
	}


