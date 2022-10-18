package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.repository.Repository;

@Controller
public class WebController {
	
	@Autowired
	Repository repo;

	@RequestMapping("/")
	public String indexpage(Model model) {
		//System.out.println("invoking ");
		List<User> user = (List<User>) repo.findAll();
		
		model.addAttribute("userlist", user);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newFormForUser(Model model) {
		System.out.println("invoking");
		User user = new User();
		//System.out.println(user);
		model.addAttribute("user", user);
		return "register";
	}
	
	@PostMapping("/add")
	public String addUser(User user) {
		repo.save(user);
		return "redirect:/";
	}
}
