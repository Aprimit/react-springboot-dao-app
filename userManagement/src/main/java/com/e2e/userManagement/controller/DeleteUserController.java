package com.e2e.userManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.e2e.userManagement.service.DeleteUserService;

@RestController
public class DeleteUserController {
	
	@Autowired
	DeleteUserService deleteUserSvc;

	@RequestMapping(value = "${spring.application.name}/deleteUser/{username}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable String username) {
		deleteUserSvc.deleteUser(username);
	}
}
