package java112.employee;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 * This is the search JavaBean for the employee web app
 * It has the variables and get and set methods for the employee search
 *
 *@author    sschwert
 */
 
 public class Search {
 
 	 ///////-----INSTANCE VARIABLES----/////////
 	 private String searchType;
 	 private String searchTerm;
 	 private List employeeList = new ArrayList();;
 	 private boolean employeeFound;
 	 
 	 ////////-----EMPTY CONSTRUCTOR-----///////
 	 /**
     *  Constructor for the Search object
     */
 	 public Search() {
 	 
 	 }
 	 
 	 /**
 	 * The addFoundEmployee method will add the employee object to the List of found Employee objects
 	 */
 	 public void addFoundEmployee (Employee employee) {

 	 	 employeeList.add(employee);
 	 
 	 }
 	 
 	 
 	 //////-----GET AND SET METHODS----/////////
	/**
	 * Returns the value of searchType.
	 */
	public String getSearchType() {
		return searchType;
	}


	/**
	 * Sets the value of searchType.
	 * @param searchType The value to assign searchType.
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	/**
	 * Returns the value of searchTerm.
	 */
	public String getSearchTerm() {
		return searchTerm;
	}


	/**
	 * Sets the value of searchTerm.
	 * @param searchTerm The value to assign searchTerm.
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}


	/**
	 * Returns the value of results.
	 */
	public List getEmployeeList() {
		return employeeList;
	}


	/**
	 * Sets the value of results.
	 * @param results The value to assign results.
	 */
	public void setEmployeeList(List employeeList) {
		this.employeeList = employeeList;
	}


	/**
	 * Returns the value of employeeFound.
	 */
	public boolean getEmployeeFound() {
		return employeeFound;
	}


	/**
	 * Sets the value of employeeFound.
	 * @param employeeFound The value to assign employeeFound.
	 */
	public void setEmployeeFound(boolean employeeFound) {
		this.employeeFound = employeeFound;
	}
 
 
 }//ends Search class
