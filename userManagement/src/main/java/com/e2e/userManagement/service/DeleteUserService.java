package com.e2e.userManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2e.userManagement.dao.UserDAOImpl;

@Service
public class DeleteUserService {

	@Autowired
	UserDAOImpl userDAOImpl;

	public void deleteUser(String username) {
		userDAOImpl.deleteUser(username);
	}
}
