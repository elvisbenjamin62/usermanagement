package com.usermanagement.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {
		
	@Autowired
	private UserService userService;
	
	/**
	 * Returns the user given a valid id else null
	 * @Return User object 
	 * @PathVariable id to query user 
	 */
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		//throw new RuntimeException("Something went wrong!!");
		return userService.getUser(id);
	}

	/**
	 * Returns all users
	 * @Return List of users  
	 */
	@RequestMapping("/users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	/**
	 * Adds a new user 
	 * @RequestBody accepts a User object
	 */
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	/**
	 * Updates an existing user 
	 * @RequestBody accepts a User object
	 * @PathVariable accepts the valid user id to update
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateUser(@PathVariable String id, @RequestBody User user) {
		userService.updateUser(id,user);
	}
	
	/**
	 * Deletes an existing user with a valid user id
	 * @PathVariable accepts the valid user id to delete
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
	
	/**
	 * Returns a list of valid user with given condition
	 * @RequestParam accepts key/value pair to filter users returned
	 */
	@RequestMapping("/searchusers")
	public List<User> searchUsers(@RequestParam Map<String, String> requestParam) {
		return userService.getAllUsers(requestParam);
	}
	
	
}
