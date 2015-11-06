package java112.project4.labs4;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is the JSTL Lab1 Servlet
 * @author    sschwert
 */
 //this is what we need the import javax.servlet.annotation
 //this is a configurations -- when someone types /trivial or /simple in the browser it will map here
@WebServlet(
    name = "JSTLLab1Servlet", 
    urlPatterns = { "/JSTLLab1Servlet", "/JSTLLab1" } //THESE MUST BE UNIQUE!!!
)
	
/**
* The First112Servlet class is described above and is a descendant of HttpServlet
*/
public class JSTLLab1Servlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        List strings = new ArrayList();
        
        strings.add("first");
        strings.add("second");
        strings.add("third");
        strings.add("fourth");
        strings.add("fifth");
        strings.add("sixth");
        strings.add("seventh");
        
        session.setAttribute("stringList", strings);
        
        String url = "/jsp/jstl-lab2.jsp";
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        
        dispatcher.forward(request, response);
        
    }

}

