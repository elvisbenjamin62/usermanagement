package com.usermanagement.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.usermanagement.dto.Address;



@Service
public class UserService {
		
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	
	@PostConstruct 
	private void postConstruction() {
		/*
		 * Start of DB Test data
		 */
		System.out.println("Saving Test Data ----------");
		userRepository.deleteAll();
		userRepository.save(new User("Benito","Samuelson","1990/4/22",new Address("905 W President George Bush Hwy","Richardson","TX","U.S.A.","75080")));
		userRepository.save(new User("Elvis","Benjamin","1991/9/3",new Address("123 6th St.","Melbourne","FL","U.S.A.","32904")));
		userRepository.save(new User("Annison","Karen","1994/8/26",new Address("71 Pilgrim Avenue","Chevy Chase","MD","U.S.A.","20815")));
		userRepository.save(new User("Don","Benjamin","1994/8/26",new Address("71 Pilgrim Avenue","Chevy Chase","MD","U.S.A.","20815")));
		System.out.println("End of Saving Test Data ----------");

		//End of testing data
	}
	
	/**
	 * Returns list of user from mongo db repo
	 */
	public List<User> getAllUsers(){
		List<User> users=new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	/**
	 * Returns a valid user from mongo db repo for a given id
	 * @param accepts a valid use id
	 */
	public User getUser(String id)
	{
		Optional<User> user= userRepository.findById(id);
		if (user.isPresent())
			return user.get();
		else 
			return null;
	}
	
	/**
	 * Saves the user to the default mongo db repo
	 * @param user
	 */
	public void addUser(User user) {
		userRepository.save(user);
	}

	/**
	 * Updates user given a valid user id and user id is peresent in db
	 * @param id used to identify user to be updated
	 * @param user details of user to be updated
	 */
	public void updateUser(String id, User user) {
		if (id.equals(user.getId()) && userRepository.findById(id).isPresent())
			userRepository.save(user);
	}

	/**
	 * Deletes user who matches id
	 * @param id used to identify user to be deleted
	 */
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}

	/**
	 * Get all users from database where query matches condition
	 * @param requestParam key/value pair for conditions to be matched
	 * @return list of users who matched condition
	 */
	public List<User> getAllUsers(Map<String, String> requestParam) {
		List<User> users=new ArrayList<User>();
		Query query = new Query();
		requestParam.forEach((k,v)->query.addCriteria(Criteria.where(k).regex(v)));
		users= mongoTemplate.find(query, User.class);
		return users;
	}
}
