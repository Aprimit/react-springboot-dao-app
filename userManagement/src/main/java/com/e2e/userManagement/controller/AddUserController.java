package com.e2e.userManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.e2e.userManagement.pojo.UserPojo;
import com.e2e.userManagement.service.AddUserService;

@RestController
public class AddUserController {
	
	@Autowired
	AddUserService addUserSvc;

	@RequestMapping(method = RequestMethod.POST, value = "${spring.application.name}/addUser")
	public void addUser(@RequestBody UserPojo user) {
		addUserSvc.addUser(user);
	}
}
