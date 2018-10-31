package com.e2e.userManagement.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import com.e2e.userManagement.dao.UserDAOImpl;
import com.e2e.userManagement.pojo.UserPojo;
import com.e2e.userManagement.service.ViewUserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ViewUserController.class, secure = false)
public class ViewUserControllerTest {

	private MockMvc mockMvc;

	@MockBean
	private ViewUserService service;

	@MockBean
	private UserDAOImpl userDAOImpl;

	@InjectMocks
	ViewUserController controller;

	List<UserPojo> users = new ArrayList<>();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void getUsers() throws Exception {
		try {
			users = new ObjectMapper().readValue(new File("src/main/java/com/e2e/userManagement/model/data.json"),
					new TypeReference<List<UserPojo>>() {
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
		Mockito.when(service.getUsers()).thenReturn(users);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userManagement/getUser");
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();

		System.out.println("-----------------------------------------------");
		System.out.println(result.getResponse().getContentAsString());
		System.out.println("-----------------------------------------------");
	}

	/**
	 * TODO: Mapping to controller function not working. Need to resolve the issue
	 * and make test case running successfully.
	 * 
	 * @throws Exception
	 */
	@Ignore
	@Test
	public void getUser() throws Exception {
		UserPojo user = new UserPojo();
		user.setUsername("aprimit2202@gmail.com");
		user.setFirstname("Aprimit");
		user.setLastname("Garg");
		user.setOrganization("ABC");
		user.setDepartment("XYZ");
		user.setDesignation("MNO");
		String userJSON = "{\"username\":\"aprimit2202@gmail.com\",\"firstname\":\"Aprimit\",\"lastname\":\"Garg\",\"organization\":\"ABC\",\"department\":\"XYZ\",\"designation\":\"MNO\"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userManagement/getUser/").param("username",
				"aprimit2202@gmail.com");
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		Assert.isTrue(result.getResponse().getContentAsString().equals(userJSON), "User details did not match");
		System.out.println("-----------------------------------------------");
		System.out.println(result.getResponse().getContentAsString());
		System.out.println("-----------------------------------------------");
	}

}
