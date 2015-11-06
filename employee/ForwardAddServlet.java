package java112.project4;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 *  This class has one purpose, to forward to the Employee Search JSP Page
 *
 *@author    sschwert
 */
@WebServlet(
    name = "forwardAdd", 
    urlPatterns = { "/forward-add" }
)
 
public class ForwardAddServlet extends HttpServlet {
 
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general 
     *                              servlet exception
     *@exception  IOException       if there is a general 
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
        throws ServletException, IOException {
        //remove the message from the session
    	HttpSession session = request.getSession();
    	session.removeAttribute("project4AddMessage");
    	
        //Create the url
        String url = "/employeeAdd.jsp";
 
        //Forward to jsp page
        RequestDispatcher  dispatcher = 
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
 
    }
 
}
