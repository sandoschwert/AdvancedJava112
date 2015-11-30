package java112.project3;
import java.io.*; //for the Print Writer in doGet()
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is part of project2 and generates html output that specifies my name,
 * course, an image, and a link back to the home page for project 2
 * There may also be some hints about what I'd rather be doing.
 * @author    sschwert
 */
 //this is what we need the import javax.servlet.annotation
 //this is a configurations -- when someone types /trivial or /simple in the browser it will map here
@WebServlet(
    name = "Lab33Servlet", 
    urlPatterns = { "/Lab33Servlet", "/Lab33" } //THESE MUST BE UNIQUE!!!
)
	
/**
* The First112Servlet class is described above and is a descendant of HttpServlet
*/
public class Lab33Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  //there is also a doPost() method you can use, we'll learn that later
            throws ServletException, IOException {
        //response.setContentType("text/html");
        // set the response type before sending data
        
        Map map = new HashMap();
        
        map.put("number", 1);
        map.put("text", "This is some sample text.");
        map.put("html", "<h2>This an h2</h2>");
        map.put("aDate", new Date());
        
        request.setAttribute("map", map);
        
        String url = "/lab33.jsp";
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        
        dispatcher.forward(request, response);
        
    }

}

