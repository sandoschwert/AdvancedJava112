package java112.project4;
  
import java.io.*;
import java.sql.*;
  
/**
 *
 *@author sschwert
 *
 */
public class JDBCInsertEmployee {
	
	public void runInsert(String[] arguments) {

//try with resources
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/student", "student", "student");
			Statement statement = connection.createStatement()) {
		
			//register the JDBC driver, initialize driver so you can open communications channel with the database
			Class.forName("com.mysql.jdbc.Driver");
			
			//Open a connection, represents a physical connection with a database
			 //db, username, password
			System.out.println("you are connected to db");
			//prepare statement and execute a query, requires using an object of type Statement (declared above, initialized here)
			
			String fName = arguments[0];
			String lName = arguments[1];
			String ssn = arguments[2];
			String dept = arguments[3];
			String room = arguments[4];
			String phone = arguments[5];
			
			
			String sql = "INSERT INTO employees (first_name, last_name, ssn, dept, room, phone) " +
						"VALUES ('" + fName + "','" + lName + "','" + ssn + "','" + dept + "','" + room + "','" + phone + "')";
			
			System.out.println("insert statement: " + sql);
			
			int numberOfRowsAffected = statement.executeUpdate(sql);
						
			statement.executeUpdate(sql);
			System.out.println("Just inserted: " + numberOfRowsAffected + " rows");
			
			System.out.println("Inserted records into the table...");
			
			
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
			

	}//end insertEmployee()

    /**
     *  The main program for the JDBCInsertEmployee class
     *
     *@param  args  The command line arguments
     *
     *@since
     *
     */
    public static void main(String[] args) {
  
        JDBCInsertEmployee employees = new JDBCInsertEmployee();
  
        employees.runInsert(args);
  
    }
	
	
}//end JDBCInsertEmployee class
