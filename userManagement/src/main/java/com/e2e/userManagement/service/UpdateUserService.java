package com.e2e.userManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2e.userManagement.dao.UserDAOImpl;
import com.e2e.userManagement.persistence.UserRepository;
import com.e2e.userManagement.pojo.UserPojo;

/**
 * @author Aprimit Garg
 *
 */
@Service
public class UpdateUserService {
	@Autowired
	UserRepository userRepo;

	/* Plain old DAO */
	@Autowired
	UserDAOImpl userDAOImpl;

	public UserPojo updateUser(UserPojo user) {
		return userRepo.save(user);
	}
}
