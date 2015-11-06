package java112.employee;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 * This class will search the employee database using the parameters entered
 * by the user and send the results to the searchResults jsp to display
 *
 * @author sschwert
 */
@WebServlet(
    name = "searchResultsServlet", 
    urlPatterns = { "/results-servlet" }
)

public class SearchResultsServlet extends HttpServlet {
 
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpServletRequest object
     *@param  response              the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure 
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	//create a local variable that references the ServletContext
    	ServletContext context = getServletContext();
    	HttpSession session = request.getSession();
    	
    	//get the EmployeeDirectory instance from the ServletContext that was placed there
    	//by the Application Start Servlet
    	EmployeeDirectory newEmployeeSearch = (EmployeeDirectory)context.getAttribute("employeeDirectory");
    	
    	//get the search type and search term from the form
    	String searchTerm = request.getParameter("searchTerm");
    	String searchType = request.getParameter("searchType");
    	
    	//search for employees by calling the approprate method in the EmployeeDirectory
    	//instance and pass the search type and search term to the method
    	if (searchType.equals("id")) {
    		Search newSearch = new Search();
    		newSearch.setSearchTerm(searchTerm);
    		newSearch.setSearchType(searchType);
    		newEmployeeSearch.searchById(newSearch);
    	
    		session.setAttribute("searchObject", newSearch);
    	}
    	
    	if (searchType.equals("lastName")) {
    		Search newSearch = new Search();
    		newSearch.setSearchTerm(searchTerm);
    		newSearch.setSearchType(searchType);
    		newEmployeeSearch.searchByLastName(newSearch);
    	
    		session.setAttribute("searchObject", newSearch);
    	}
    	
 
        //-----FORWARD TO THE JSP PAGE-----//
        //Create the url
        String url = "/searchResults.jsp";

        //instantiate a RequestDispatcher object and assign the url to it
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        
        //Forward to jsp page
        dispatcher.forward(request, response);
 
    }
 
}