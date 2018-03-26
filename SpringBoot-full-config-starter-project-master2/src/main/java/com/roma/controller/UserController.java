package com.roma.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.roma.entity.ImageRequest;
import com.roma.entity.UserEntity;
import com.roma.mapper.UserMapper;
import com.roma.service.UserService;
import com.roma.service.utils.CustomFileUtils;

@Controller
@RequestMapping({"/user","/admin"})
@SessionAttributes("editUserModel")
public class UserController {
	
	@Autowired private UserService userService;
	
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public String showProfile(Model model, Principal principal) throws IOException{
		UserEntity user = userService.findUserByEmail(principal.getName());
		user.setImagePath(CustomFileUtils.getImage("user_"+ user.getId(),user.getImagePath()));
		model.addAttribute("userProfile", UserMapper.entityToUserProfile(user));
		
		return"user/profile";
	}
	
	@GetMapping("/profile/image")
	public String uploadImage(Model model) {
		model.addAttribute("uploadModel", new ImageRequest());
		return"user/upload";
		
	}
	
	@PostMapping("/profile/image")
	public String saveImage(@ModelAttribute("uploadModel" )ImageRequest request, Principal principal) throws IOException {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		entity.setImagePath(request.getFile().getOriginalFilename());
		CustomFileUtils.createImage("user_" + entity.getId(), request.getFile());
		userService.updateUser(entity);
		
		return"redirect:/user";
	}
	
	@GetMapping("/profile/edit")
	public String editUser(Model model,Principal principal) {
		
		UserEntity entity = userService.findUserByEmail(principal.getName());
		model.addAttribute("editUserModel" , entity);
		
		return"user/edit";
	}
	
	@PostMapping("/profile/edit")
	public String saveEditUser(@ModelAttribute("editUserModel")UserEntity entity) {
		userService.updateUser(entity);
		return"redirect:/user";
	}
	
	
	@GetMapping("/users")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showAllUsers(Model model) throws IOException {
		
		List<UserEntity> userEntities = userService.findAllUsers();
		
		for(int i = 0; i < userEntities.size(); i++) {
			UserEntity entity = userEntities.get(i);
			String image = CustomFileUtils.getImage("user_"+ entity.getId(), entity.getImagePath());
			userEntities.get(i).setImagePath(image);
			
		}
		model.addAttribute("users", userEntities);
		return "user/users";
		
	}
}
