package com.e2e.userManagement.dao;

import java.util.List;

import com.e2e.userManagement.pojo.UserPojo;

public interface UserDAO {
	public UserPojo addUser(UserPojo user);

	public UserPojo updateUser(UserPojo user);

	public void deleteUser(String username);

	public UserPojo getUser(String username);

	public List<UserPojo> getAllUsers();
}
