package com.e2e.userManagement.dao;

import java.util.List;

import com.e2e.userManagement.pojo.UserPojo;

public interface UserDAO {
	public void addUser(UserPojo user);

	public void updateUser(UserPojo user);

	public void deleteUser(String username);

	public UserPojo getUser(String username);

	public List<UserPojo> getAllUsers();
}
