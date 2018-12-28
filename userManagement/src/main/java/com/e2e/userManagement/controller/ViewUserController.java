package com.e2e.userManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.e2e.userManagement.pojo.UserPojo;
import com.e2e.userManagement.service.ViewUserService;

@RestController
public class ViewUserController {

	@Autowired
	ViewUserService viewUserSvc;

	@RequestMapping(value = "userManagement/getUser", method = RequestMethod.GET)
	public ResponseEntity<?> viewUsers() {
		HttpStatus status = HttpStatus.OK;
		List<UserPojo> users = viewUserSvc.getUsers();
		if (users.isEmpty())
			status = HttpStatus.NO_CONTENT;
		return new ResponseEntity<>(users, status);
	}

	@RequestMapping(value = "userManagement/getUser/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> viewUser(@PathVariable("username") String username) {
		HttpStatus status = HttpStatus.OK;
		Optional<UserPojo> user = viewUserSvc.findUser(username);
		if (user == null)
			status = HttpStatus.NO_CONTENT;
		return new ResponseEntity<>(user, status);
	}
}
