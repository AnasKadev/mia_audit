package com.mia.audit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mia.audit.model.dto.UserDto;
import com.mia.audit.model.entity.User;

import com.mia.audit.repository.UserRepo;
import com.mia.audit.repository.DefaultFormRepo;
import com.mia.audit.repository.ActionPlanRepo;
import com.mia.audit.repository.FormRepo;
import com.mia.audit.repository.TaskRepo;
import com.mia.audit.model.entity.*;


@Service
public class AdminService {

	private UserRepo userRepo;
    private DefaultFormRepo defaultFormRepo;
    private ActionPlanRepo actionPlanRepo;
    private FormRepo formRepo;
    private TaskRepo taskRepo;
    
 public AdminService(UserRepo userRepo, DefaultFormRepo defaultFormRepo,
			ActionPlanRepo actionPlanRepo, FormRepo formRepo, TaskRepo taskRepo) {
	 this.defaultFormRepo = defaultFormRepo;
	 this.actionPlanRepo = actionPlanRepo;
	 this.formRepo = formRepo;
	 this.taskRepo = taskRepo;
	 this.userRepo=userRepo;
 }
 public User addUser(User user) {
	 return userRepo.save(user);
 }
 public User updateUser(Long id,UserDto userdto) {
	 User user = userRepo.findById(id)
			 .orElseThrow(()->new RuntimeException("User not found"));
	 if(userdto.getFirstname()!=null) {
		 user.setFirstname(userdto.getFirstname());
	 }
	 if(userdto.getLastname()!=null) {
		 user.setLastname(userdto.getLastname());
	 }
	 if(userdto.getPwd()!=null) {
		 user.setPwd(userdto.getPwd());
	 }
	 if(userdto.getRole()!=null) {
		 user.setRole(Role.valueOf(userdto.getRole()));
	 }
	 if(userdto.getPilote()!=null) {
		 user.setPilote(userdto.getPilote());
	 }
	 
	 return userRepo.save(user); 
 }
 public void deleteUser(Long id) {
	 userRepo.deleteById(id);
 }
 @Transactional
 public Task assignTask(Long id,Long formId) {
	 User user= userRepo.findById(id)
			 .orElseThrow(()->new RuntimeException("User not found"));
	 DefaultForm defaultForm= defaultFormRepo.findById(formId)
			 .orElseThrow(()->new RuntimeException("Form not found"));
	 return taskRepo.save(new Task(null,user,defaultForm));
	 
 }
 
 public void deleteTask(Long taskId) {
	 taskRepo.deleteById(taskId);
 }
 public void getTask(Long taskId) {
 
 }
 public DefaultForm createDefaultForm(DefaultForm form) {
	 return defaultFormRepo.save(form);
 }
 
 
 
}
