package com.e2e.userManagement.controller;

import java.util.List;

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

	@RequestMapping(method = RequestMethod.POST, value = "userManagement/addUser")
	public UserPojo addUser(@RequestBody UserPojo user) {
		return addUserSvc.addUser(user);
	}
}
