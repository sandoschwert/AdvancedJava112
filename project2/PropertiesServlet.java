package java112.project2;
import java.io.*; //for the Print Writer in doGet()
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*; //this is so we can use the Properties class

/**
 * This is part of project2 and generates html output that creates a table of
 * properties from the properties file.  There is also some stuff indicating
 * how much I want to be outside.
 * @author    sschwert
 */
 //this is what we need the import javax.servlet.annotation
 //this is a configurations -- when someone types /trivial or /simple in the browser it will map here
@WebServlet(
    name = "propertiesServlet", 
    urlPatterns = { "/propertiesServlet", "/props" } //THESE MUST BE UNIQUE!!!
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

		////--PAULA SAYS YOU DON'T NEED THIS HERE, PUT IT IN THE LOADPROPERTIES METHOD--////
		//String propertiesFilePath = "/project2.properties";
		//loadProperties(propertiesFilePath);
		
		loadProperties();
	
	}
	
	/**
	* the loadProperties method propertiesFilePath to the getResourceAsStream method 
	* in a try/catch block
	* @param propertiesFilePath is a string representing the location of the properties file
	*/
	public void loadProperties() {
		
		String propertiesFilePath = "/project2.properties";
		
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
 	
        String applicationName = properties.getProperty("application.name");
		String authorName = properties.getProperty("author");
		String authorEmail = properties.getProperty("author.email.address");
		String courseTitle = properties.getProperty("course.title");
		String courseTime = properties.getProperty("course.time");
		String instructorName = properties.getProperty("instructor.name");
		String description = properties.getProperty("description");
            	
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><link rel=\"stylesheet\" type=\"text/css\" href=\"css/styleFirstServlet.css\"><TITLE>Project 2 Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<div id=\"site_content\">");
        out.print("<h1>Mad props, yo.</h1>");
        out.print("<br />");
        out.print("<table>");
        out.print("<tr><td class=\"title\">Application: </td><td>" + applicationName + "</td></tr>");
        out.print("<tr><td class=\"title\">Author Name: </td><td>" + authorName + "</td></tr>");
        out.print("<tr><td class=\"title\">Email: </td><td>" + authorEmail + "</td></tr>");
        out.print("<tr><td class=\"title\">Course: </td><td>" + courseTitle + " at " + courseTime + " with " + instructorName + "</td></tr>");
        out.print("<tr><td class=\"title\">Description: </td><td>" + description + "</td></tr>");
        out.print("</table>");
        out.print("<br />");
        out.print("<div id=\"pics\">");
        out.print("<img alt=\"summer trail\" src=\"images/mountainTrail.jpg\" />");
        out.print("</div>");
        out.print("<br />");
        out.print("<a href=\"/java112/index.jsp\">Take me home</a>");
        out.print("<br />");
        out.print("<a target=_blank href=\"http://www.devilslakewisconsin.com/activities/hiking/\">Take me to the trails</a>");
        out.print("<br />");
        out.print("<a href=\"/java112/firsties\">First 112 Servlet</a>");
        out.print("<br />");;
        out.print("<a href=\"trivial\">Trivial Servlet</a>");
        out.print("<br />");
        out.print("<a href=\"linkingDemo.html\">Linking Demo</a>");  
        out.print("</div>");        
        System.out.println("Is this logging?"); //this goes in the catalina log
        log("Is this logging?"); //this goes into localhost log **preferred
        out.print("</BODY>");
        out.print("</HTML>");
        out.close(); //must close the print writer or it won't display the information
    }

}

