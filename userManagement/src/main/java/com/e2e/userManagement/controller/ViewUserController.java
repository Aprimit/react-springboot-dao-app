package com.e2e.userManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e2e.userManagement.pojo.UserPojo;
import com.e2e.userManagement.service.ViewUserService;

@RestController
public class ViewUserController {

	@Autowired
	ViewUserService viewUserSvc;

	@RequestMapping("/getUser")
	public List<UserPojo> viewUsers() {
		return viewUserSvc.getUsers();
	}

	@RequestMapping("/getUser/{username}")
	public UserPojo viewUser(@PathVariable("username") String username) {
		return viewUserSvc.getUser(username);
	}
}
