package com.e2e.userManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2e.userManagement.dao.UserDAOImpl;
import com.e2e.userManagement.persistence.UserRepository;

/**
 * @author Aprimit Garg
 *
 */
@Service
public class DeleteUserService {
	@Autowired
	UserRepository userRepo;

	/* Plain old DAO */
	@Autowired
	UserDAOImpl userDAOImpl;

	public void deleteUser(String username) {
		userRepo.deleteById(username);
	}
}
