package com.usermanagement.user;
import org.springframework.data.annotation.Id;
import com.usermanagement.dto.Address;


public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String DOB;
	private Address address;
	

	/**
	 * Default User Constructor
     */
	public User() {
	}
	
	/**
	 * Overloaded User constructor
	 * @param id : User ID 
	 * @param firstName : First Name
	 * @param lastName : Last Name
	 * @param dOB : Date of Birth
	 * @param address : Refers to Address class to store address info of user
	 */
	public User(String id, String firstName, String lastName, String dOB, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.DOB = dOB;
		this.address = address;
	}
	
	/**
	 * Overloaded User constructor
	 * @param firstName : First Name
	 * @param lastName : Last Name
	 * @param dOB : Date of Birth
	 * @param address : Refers to Address class to store address info of user
	 */
	public User( String firstName, String lastName, String dOB, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.DOB = dOB;
		this.address = address;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		this.DOB = dOB;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
