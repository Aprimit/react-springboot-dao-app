package com.e2e.userManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2e.userManagement.dao.UserDAOImpl;
import com.e2e.userManagement.pojo.UserPojo;

@Service
public class AddUserService {
	@Autowired
	UserDAOImpl userDAOImpl;

	public void addUser(UserPojo user) {
		userDAOImpl.addUser(user);
	}
}
