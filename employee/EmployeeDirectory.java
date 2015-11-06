package java112.employee;
import java.io.*;
import java.util.*;
import java.sql.*;

/**
 * The EmployeeDirectory class initializes the properties file and passes
 * the necessary properties to the application, it creates a database connection,
 * and passes the connection to the addRecords, deleteRecords, searchById,
 * and searchByLastName methods
 * @author    sschwert
 */
public class EmployeeDirectory {
	
	///////-----INSTANCE VARIABLES----/////////
	private Properties properties;
	private String addMessage;
	private String deleteMessage;
	
	////////-----EMPTY CONSTRUCTOR-----////////
	/**
	* Empty constructor for the EmployeeDirectory class
	*/
	public EmployeeDirectory() {
	
	}
	
	////////-----ONE PARAM CONSTRUCTOR-----////////
	/**
	* Constructor for the EmployeeDirectory object calls the empty constructor
	* @param property is a Properties object containing properties from the properties file
	*/
	public EmployeeDirectory(Properties properties) {
		this();
		this.properties = properties;
	}
	
	/**
	* the getDatabaseConnection method establishes a connection tot he database 
	* and returns the connection the calling method
	* @return Connection is the connection to the database
	* @exception ClassNotFoundException from the forName method to be dealt with later
	* @exception SQLException from the getConnection method to be dealt with later
	*/
	private Connection getDatabaseConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(properties.getProperty("url"), 
				properties.getProperty("username"), properties.getProperty("password"));
			
		} catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
			
        return connection;
			
        
	}
	
	/**
	* the addRecords method will add a new record to the Employee table in the database
	* @param id is the employee id from the Employee class
	* @param firstName is the first name from the Employee class
	* @param lastName is the last name from the Employee class
	* @param ssn is the ssn from the Employee class
	* @param department is the department from the Employee class
	* @param roomNumber is the roomNumber from the Employee class
	* @param phoneNumber is the phoneNumber from the Employee class
	*/
	public void addRecords(//String id,
						String firstName,
						String lastName,
						String ssn,
						String department,
						String roomNumber,
						String phoneNumber) {
		
		Connection connection = getDatabaseConnection();
		Statement statement = null;
		Employee employee = new Employee();
		
		try {
			statement = connection.createStatement();

			String sql = "INSERT INTO employees (first_name, last_name, ssn, dept, room, phone)" +
						"VALUES ('" + firstName + "','" + lastName + "','" + ssn + "','" + department + "','" + roomNumber + "','" + phoneNumber + "')";
	  
			System.out.println("queryString: " + sql);

			int numberOfRowsAffected = statement.executeUpdate(sql);
			
			setAddMessage("Success! Number of rows inserted : " + numberOfRowsAffected);
			
			
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
            setAddMessage("Database connection failure");
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
            setAddMessage("General Failure");
        } finally {
            try {
  
                if (statement != null) {
                    statement.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
        
	}
	
	/**
	* the deleteRecords method will delete a new record from the Employee table in the database
	* @param lastName is the last name passed from the AddEmployeeServlet class
	*/
	public void deleteRecords(String lastName) {
		
		Connection connection = getDatabaseConnection();
		Statement statement = null;
		Employee employee = new Employee();
		
		try {
			statement = connection.createStatement();

			String sql = "DELETE FROM employees WHERE last_name = '" + lastName + "'";
						
			System.out.println("queryString: " + sql);

			statement.executeUpdate(sql);
			
			setDeleteMessage("Success! All employees with the last name " + lastName + " were removed.");
			
			
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
            setDeleteMessage("Database connection failure");
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
            setDeleteMessage("General Failure");
        } finally {
            try {
  
                if (statement != null) {
                    statement.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
        
	}
	
	
	/**
	* the searchById method will search for an Employee in the database by employee id
	* @param search is a search object whose value is sent from the SearchResultsServlet class
	*/
	public void searchById(Search search) {
		
		Connection connection = getDatabaseConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
            statement = connection.createStatement();
  
            String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone"
                    + " FROM employees " + "WHERE emp_id LIKE '"
                    + search.getSearchTerm() + "'";
  
            resultSet = statement.executeQuery(queryString);
            
            //test to see if there are any results from the query
            if (resultSet != null) {
            	search.setEmployeeFound(true);
            	
            	while (resultSet.next()) {
					Employee employee = new Employee();
					
					//get the values from the result set from the database and set them to the employee object
					employee.setId(resultSet.getString("emp_id"));
					employee.setFirstName(resultSet.getString("first_name"));
					employee.setLastName(resultSet.getString("last_name"));
					employee.setSsn(resultSet.getString("ssn"));
					employee.setDepartment(resultSet.getString("dept"));
					employee.setRoomNumber(resultSet.getString("room"));
					employee.setPhoneNumber(resultSet.getString("phone"));
					
					//add the employee to the arraylist
					search.addFoundEmployee(employee);

                }

            } else {
            	search.setEmployeeFound(false);
            }

        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
  
                if (statement != null) {
                    statement.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
		
	}
	
	/**
	* the searchByLastName method will search for an Employee in the database by last name
	* @param search is a search object whose value is sent from the SearchResultsServlet class
	*/
	public void searchByLastName(Search search) {
		
		Connection connection = getDatabaseConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
  
            statement = connection.createStatement();
  
            //String searchId = "Smith";
            String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone"
                    + " FROM employees " + "WHERE last_name LIKE '"
                    + search.getSearchTerm() + "%'";
  
            resultSet = statement.executeQuery(queryString);
            
            //test to see if there are any results from the query
            if (resultSet != null) {
            	search.setEmployeeFound(true);
            	while (resultSet.next()) {
					Employee employee = new Employee();
					
					//get the values from the result set from the database and set them to the employee object
					employee.setId(resultSet.getString("emp_id"));
					employee.setFirstName(resultSet.getString("first_name"));
					employee.setLastName(resultSet.getString("last_name"));
					employee.setSsn(resultSet.getString("ssn"));
					employee.setDepartment(resultSet.getString("dept"));
					employee.setRoomNumber(resultSet.getString("room"));
					employee.setPhoneNumber(resultSet.getString("phone"));
					
					//and the employee to the arraylist
					search.addFoundEmployee(employee);
				}
            } else {
				search.setEmployeeFound(false);
			}

        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
  
                if (statement != null) {
                    statement.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
		
	}
	
	////--------GETTERS AND SETTERS FOR ADD AND DELETE DISPLAY MESSAGES-------///////
	/**
	* getAddMessage returns the addMessage
	*/
	public String getAddMessage() {
		return addMessage;
	}
	
	/**
	* setAddMessage sets the value of the addMessage
	* @param the value to assign to addMessage
	*/
	public void setAddMessage(String addMessage) {
		this.addMessage = addMessage;
	}
	
	/**
	* getDeleteMessage returns the deleteMessage
	*/
	public String getDeleteMessage() {
		return deleteMessage;
	}
	
	/**
	* setDeleteMessage sets the value of the deleteMessage
	* @param the value to assign to deleteMessage
	*/
	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}
	
	

}//ends EmployeeDirectory class
