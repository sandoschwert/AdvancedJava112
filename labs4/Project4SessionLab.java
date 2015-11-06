package java112.project4;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
  
/**
 *  This class is the servlet for the Session lab
 *
 *@author    sschwert
 */
@WebServlet(
    name = "project4sessionlab", 
    urlPatterns = { "/project4sessionlab" }
)
public class Project4SessionLab extends HttpServlet {
  
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
        throws ServletException, IOException {
    
        HttpSession session = request.getSession();

        Integer sessionCounter = (Integer)session.getAttribute("project4SessionCounter");
        
 
        if (sessionCounter == null) {
        	Integer newCounter = new Integer(1);
        	sessionCounter = newCounter;
        } else {
        	sessionCounter ++;
        }
        session.setAttribute("project4SessionCounter", sessionCounter);

        String url = "/project4Session.jsp";
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        
        dispatcher.forward(request, response);
        
        
    }
  
}
  
