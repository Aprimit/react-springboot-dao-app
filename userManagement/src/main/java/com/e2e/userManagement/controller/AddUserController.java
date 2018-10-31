package com.e2e.userManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> addUser(@RequestBody UserPojo user) {
		return new ResponseEntity<>(addUserSvc.addUser(user), HttpStatus.CREATED);
	}
}
