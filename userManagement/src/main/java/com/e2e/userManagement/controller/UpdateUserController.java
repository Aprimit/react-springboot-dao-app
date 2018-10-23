package com.e2e.userManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.e2e.userManagement.pojo.UserPojo;
import com.e2e.userManagement.service.UpdateUserService;

@RestController
public class UpdateUserController {
	
	@Autowired
	UpdateUserService updateUserSvc;

	@RequestMapping(method = RequestMethod.PUT, value = "${spring.application.name}/updateUser")
	public void updateUser(@RequestBody UserPojo user) {
		updateUserSvc.updateUser(user);
	}
}
