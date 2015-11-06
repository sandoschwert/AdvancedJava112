package java112.employee;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 * This is the Employee class for project 4
 * It has the variables and get and set methods for a number of employee variables
 *
 *@author    sschwert
 */
 
 public class Employee {
 
 	 ///////-----INSTANCE VARIABLES----/////////
 	 private String id;
 	 private String firstName;
 	 private String lastName;
 	 private String ssn;
 	 private String department;
 	 private String roomNumber;
 	 private String phoneNumber;
 	 
 	 /**
 	 * This toString method overrides the built in toString method
 	 * @return a string of something i never used
 	 */
 	 public String toString() {
 	 	 return "a string";
 	 }
 	 
 	 
 	 //////-----GET AND SET METHODS----/////////
	/**
	 * Returns the value of id.
	 */
	public String getId() {
		return id;
	}


	/**
	 * Sets the value of id.
	 * @param id The value to assign id.
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * Returns the value of firstName.
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Sets the value of firstName.
	 * @param firstName The value to assign firstName.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Returns the value of lastName.
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Sets the value of lastName.
	 * @param lastName The value to assign lastName.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Returns the value of ssn.
	 */
	public String getSsn() {
		return ssn;
	}


	/**
	 * Sets the value of ssn.
	 * @param ssn The value to assign ssn.
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	/**
	 * Returns the value of department.
	 */
	public String getDepartment() {
		return department;
	}


	/**
	 * Sets the value of department.
	 * @param department The value to assign department.
	 */
	public void setDepartment(String department) {
		this.department = department;
	}


	/**
	 * Returns the value of roomNumber.
	 */
	public String getRoomNumber() {
		return roomNumber;
	}


	/**
	 * Sets the value of roomNumber.
	 * @param roomNumber The value to assign roomNumber.
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	/**
	 * Returns the value of phoneNumber.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * Sets the value of phoneNumber.
	 * @param phoneNumber The value to assign phoneNumber.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
 
 }//ends Employee class