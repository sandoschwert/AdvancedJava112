package java112.employee;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 * This class will add or delete employees in the database
 *
 * @author sschwert
 */
@WebServlet(
    name = "addEmployeeServlet", 
    urlPatterns = { "/add-new-employee" }
)

public class AddEmployeeServlet extends HttpServlet {
	
	 /**
     *  Handles HTTP POST requests.
     *
     *@param  request               the HttpServletRequest object
     *@param  response              the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure 
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//create a local variable that references the ServletContext
    	ServletContext context = getServletContext();
    	
    	//get the EmployeeDirectory instance from the ServletContext that was placed there
    	//by the Application Start Servlet
    	EmployeeDirectory newEmployee = (EmployeeDirectory)context.getAttribute("employeeDirectory");
    	
    	//get the employee information from the form
    	String firstName = request.getParameter("txtFirstName");
    	String lastName = request.getParameter("txtLastName");
    	String ssn = request.getParameter("txtSsn");
    	String dept = request.getParameter("txtDepartment");
    	String rmNumber = request.getParameter("txtRoomNumber");
    	String phNumber = request.getParameter("txtPhoneNumber");
    	String submitType = request.getParameter("submitType");
    	
    	//get the session object
    	HttpSession session = request.getSession();
    	
    	//test if the user has chosen to add or delete an employee
    	if(submitType.equals("add")) {
    		newEmployee.addRecords(firstName, lastName, ssn, dept, rmNumber, phNumber);
    		String newMessage = newEmployee.getAddMessage();
    		//add the returned message to the session
    		session.setAttribute("project4AddMessage", newMessage);
    	} else if(submitType.equals("delete")) {
    		newEmployee.deleteRecords(lastName);
    		String newMessage = newEmployee.getDeleteMessage();
    		//add the returned message to the session
    		session.setAttribute("project4AddMessage", newMessage);
    	} else {
    		String newMessage = "there was an error";
    		//add the returned message to the session
    		session.setAttribute("project4AddMessage", newMessage);
    	}
    	
    	//Create the url
        String url = "/java112/employeeAdd.jsp";
 
        // Redirect to JSP page
        response.sendRedirect(url);
    }


}//ends AddEmployeeServlet class
