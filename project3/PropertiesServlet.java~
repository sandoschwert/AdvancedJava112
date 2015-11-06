package java112.project3;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 * This is part of project3 and generates html output that creates a table of
 * properties from the properties file.
 * @author    sschwert
 */

@WebServlet(
    name = "project3PropertiesServlet", 
    urlPatterns = { "/project3-properties", "/props3" } 
)

/**
* The PropertiesServlet class is described above and is a descendant of HttpServlet
*/
public class PropertiesServlet extends HttpServlet {
	
	///////-----INSTANCE VARIABLES----/////////
	private Properties properties;
	
	/**
	* the init method instantiates the properties object and calls the loadProperties method
	* @exception ServletException from the properties object, to be dealt with later...
	*/
	public void init() throws ServletException {

		properties = new Properties();
		
		loadProperties();
	
	}
	
	/**
	* the loadProperties method sends the propertiesFilePath to the getResourceAsStream method 
	* in a try/catch block
	* @param propertiesFilePath is a string representing the location of the properties file
	*/
	public void loadProperties() {
		
		String propertiesFilePath = "/project3.properties";
		
		try {
			properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpServletRequest object
     *@param  response              the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  //there is also a doPost() method you can use, we'll learn that later
            throws ServletException, IOException {
        
        //add the requestData instance to the request using setAttribute()
		request.setAttribute("project3Properties", properties);
		
		//-----FORWARD TO THE JSP PAGE-----//
        //Create the url
        String url = "/project3properties.jsp";

        //instantiate a RequestDispatcher object and assign the url to it
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        
        //Forward to jsp page
        dispatcher.forward(request, response);
            	
        
    }

}

