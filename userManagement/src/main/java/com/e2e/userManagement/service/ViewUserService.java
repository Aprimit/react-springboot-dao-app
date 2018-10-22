package com.e2e.userManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2e.userManagement.dao.UserDAOImpl;
import com.e2e.userManagement.pojo.UserPojo;

@Service
public class ViewUserService {

	@Autowired
	UserDAOImpl userDAOImpl;

	public List<UserPojo> getUsers() {

		return userDAOImpl.getAllUsers();
	}

	public UserPojo getUser(String username) {
		return userDAOImpl.getUser(username);
	}
}
