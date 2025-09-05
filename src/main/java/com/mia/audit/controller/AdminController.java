package com.mia.audit.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mia.audit.model.entity.User;
import com.mia.audit.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
 private final AdminService adminService;

 public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
 @PostMapping("/addUser")
 public User addUser(@RequestBody User user) {
	return adminService.AddUser(user);
	}

}
