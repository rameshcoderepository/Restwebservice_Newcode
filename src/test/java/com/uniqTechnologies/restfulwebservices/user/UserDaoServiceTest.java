package com.uniqTechnologies.restfulwebservices.user;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.*;

public class UserDaoServiceTest {

	private UserDaoService userDaoService;

	@BeforeEach
	public void setUp() {
		userDaoService = new UserDaoService();
	}

	@Test
	public void testFindAll() {
		List<User> users = userDaoService.findAll();
		assertEquals(3, users.size());
	}

	public void testSave() {
	    User user = new User(4, "John", new Date());
	    User savedUser = userDaoService.save(user);

	    assertEquals(Integer.valueOf(4), savedUser.getId());
	    assertEquals("John", savedUser.getName());
	    // Add more assertions as needed
	}

	@Test
	public void testFindOne() {
		User user = userDaoService.findOne(2);
		assertEquals("Eve", user.getName());
	}

	@Test
	public void testFindOneNonExistent() {
		User user = userDaoService.findOne(10);
		assertNull(user);
	}

	

	@Test
	public void testDeleteByIdNonExistent() {
		User user = userDaoService.deleteById(10);
		assertNull(user);
	}
}
