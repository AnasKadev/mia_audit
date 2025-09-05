package com.mia.audit.service;

import org.springframework.stereotype.Service;

import com.mia.audit.model.entity.User;

import com.mia.audit.repository.UserRepo;
import com.mia.audit.repository.PilotRepo;
import com.mia.audit.repository.DefaultFormRepo;
import com.mia.audit.repository.ActionPlanRepo;
import com.mia.audit.repository.FormRepo;
import com.mia.audit.repository.TaskRepo;


@Service
public class AdminService {

	private UserRepo userRepo;
    private PilotRepo pilotRepo;
    private DefaultFormRepo defaultFormRepo;
    private ActionPlanRepo actionPlanRepo;
    private FormRepo formRepo;
    private TaskRepo taskRepo;
    
 public AdminService(UserRepo userRepo, PilotRepo pilotRepo, DefaultFormRepo defaultFormRepo,
			ActionPlanRepo actionPlanRepo, FormRepo formRepo, TaskRepo taskRepo) {
	 this.pilotRepo = pilotRepo;
	 this.defaultFormRepo = defaultFormRepo;
	 this.actionPlanRepo = actionPlanRepo;
	 this.formRepo = formRepo;
	 this.taskRepo = taskRepo;
	 this.userRepo=userRepo;
 }
 public User AddUser(User user) {
	 return userRepo.save(user);
 }
}
