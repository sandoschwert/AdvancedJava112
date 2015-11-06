package java112.project4;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
  
/**
 *  This class is the servlet for lab 4.1
 *
 *@author    sschwert
 */
@WebServlet(
    name = "lab41", 
    urlPatterns = { "/lab41" }
)
public class Lab41Servlet extends HttpServlet {
  
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
  
        String  param1  = request.getParameter("param1");
  
        String  param2  = request.getParameter("param2");
        
        String camping = request.getParameter("camping");

        String url = "/lab41.jsp";
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        
        dispatcher.forward(request, response);
        
        
    }
  
}
  
