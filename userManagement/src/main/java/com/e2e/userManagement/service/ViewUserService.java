package com.e2e.userManagement.service;

import java.util.List;
import java.util.Optional;

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
public class ViewUserService {

	@Autowired
	UserRepository userRepo;

	/* Plain Old DAO */
	@Autowired
	UserDAOImpl userDAOImpl;

	public List<UserPojo> getUsers() {

		return userDAOImpl.getAllUsers();
	}

	public UserPojo getUser(String username) {
		return userDAOImpl.getUser(username);
	}

	public Optional<UserPojo> findUser(String username) {
		return userRepo.findById(username);
	}

	public Iterable<UserPojo> findAll() {
		return userRepo.findAll();
	}
}
