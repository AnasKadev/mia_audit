package com.mia.audit.controller;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mia.audit.model.dto.*;
import com.mia.audit.model.entity.*;
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
	return adminService.addUser(user);
	}
 @PatchMapping("/updateUser/{id}")
 public User updateUser(@PathVariable Long id, @RequestBody UserDto user) {
	 return adminService.updateUser(id, user);
 }
 @DeleteMapping("/deleteUser/{id}")
 public void deleteUser(@PathVariable Long id) {
	 adminService.deleteUser(id);
 }
 
 @PostMapping("/assignTask/{userId}/{formId}")
 public void assignTask(@PathVariable Long userId, @PathVariable Long formId) {
	 adminService.assignTask(userId, formId);
 }
 
 @PostMapping("/createDefaultForm")
 public void createDefaultForm(@RequestBody DefaultForm defaultFormDto) {
	 adminService.createDefaultForm(defaultFormDto);
	 System.out.println("Default form created with zone: " + defaultFormDto.getZone());
	 System.out.println("Fields: " + defaultFormDto.getFields());
	 }
 @GetMapping("/user/{id}")
 public void getTaskByUserId(@PathVariable Long id) {
	
 }
 
}
