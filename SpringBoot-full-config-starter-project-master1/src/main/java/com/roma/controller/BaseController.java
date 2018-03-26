package com.roma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.roma.domain.RegisterRequest;
import com.roma.entity.UserEntity;
import com.roma.mapper.UserMapper;
import com.roma.service.UserService;

@Controller
public class BaseController {

	@Autowired
	private UserService userService;

	@GetMapping({ "/", "/home" })
	public String shoHome() {
		return "home";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegister(Model model) {

		model.addAttribute("userModel", new RegisterRequest());

		return "register";
	}
	@PostMapping("/register")
	public ModelAndView saveUser(
			@Valid @ModelAttribute("userModel") 
			RegisterRequest request, 
			BindingResult br) {
		
		if(br.hasErrors()) {
			return new ModelAndView("register");
		}
		try {
			userService.saveUser(UserMapper.registertoEntity(request));
		} catch (Exception e) {
			return new ModelAndView("register", "error" , "Ooops user dont save.");
		}
		
		
		return new ModelAndView("redirect:/login");
	}
	@GetMapping("/verify")
	public String verifyUser(
			@RequestParam("token") String token,
			@RequestParam("userid") String userIdStr,
			Model model
			) {
			
		
			try {
				int userId = Integer.valueOf(userIdStr);
				UserEntity entity = userService.findUserById(userId);
				if (entity != null) {
					if(entity.getToken().equals(token));
					entity.setToken("");
					entity.setActivated(true);
					
					userService.updateUser(entity);
					
				}
				
			} catch (Exception e) {
				model.addAttribute("error", "Ooops.. verify error");
				return "verify/verify-error";
			}
		
		return "verify/verify-success";
	}
	
	
	
}
