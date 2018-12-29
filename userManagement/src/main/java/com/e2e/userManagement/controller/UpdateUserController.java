package com.e2e.userManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.e2e.userManagement.pojo.UserPojo;
import com.e2e.userManagement.service.UpdateUserService;

/**
 * @author Aprimit Garg
 *
 */
@RestController
public class UpdateUserController {

	@Autowired
	UpdateUserService updateUserSvc;

	@RequestMapping(method = RequestMethod.PUT, value = "${spring.application.name}/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody UserPojo user) {
		return new ResponseEntity<>(updateUserSvc.updateUser(user), HttpStatus.OK);
	}
}
