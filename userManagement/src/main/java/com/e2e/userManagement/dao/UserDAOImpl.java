package com.e2e.userManagement.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.e2e.userManagement.pojo.UserPojo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserDAOImpl implements UserDAO {

	@Override
	public UserPojo addUser(UserPojo user) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<UserPojo> users = getAllUsers();
		users.add(user);
		try {
			objectMapper.writerWithDefaultPrettyPrinter()
					.writeValue(new File("src/main/java/com/e2e/userManagement/model/data.json"), users);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getUser(user.getUsername());
	}

	@Override
	public UserPojo updateUser(UserPojo user) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<UserPojo> users = getAllUsers();
		int targetIndex = -1;
		for (UserPojo userCounter : users) {
			if (user.getUsername().equals(userCounter.getUsername())) {
				targetIndex = users.indexOf(userCounter);
			}
		}
		users.set(targetIndex, user);
		try {
			objectMapper.writerWithDefaultPrettyPrinter()
					.writeValue(new File("src/main/java/com/e2e/userManagement/model/data.json"), users);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getUser(user.getUsername());
	}

	@Override
	public void deleteUser(String username) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<UserPojo> users = getAllUsers();
		int targetIndex = -1;
		for (UserPojo user : users) {
			if (user.getUsername().equals(username)) {
				targetIndex = users.indexOf(user);
			}
		}
		users.remove(targetIndex);
		try {
			objectMapper.writerWithDefaultPrettyPrinter()
					.writeValue(new File("src/main/java/com/e2e/userManagement/model/data.json"), users);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserPojo getUser(String username) {
		UserPojo targetUser = null;
		List<UserPojo> users = getAllUsers();
		for (UserPojo user : users) {
			if (user.getUsername().equals(username)) {
				targetUser = user;
			}
		}
		return targetUser;
	}

	@Override
	public List<UserPojo> getAllUsers() {
		ObjectMapper objectMapper = new ObjectMapper();
		List<UserPojo> users = new ArrayList<>();
		try {
			users = objectMapper.readValue(new File("src/main/java/com/e2e/userManagement/model/data.json"),
					new TypeReference<List<UserPojo>>() {
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

}
