package java112.project3;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 * This class is the Servlet for project 3 - it instantiates the HttpRequestData javabean
 * and assigns info to the properties of the HttpRequestData class
 *
 * @author sschwert
 */
@WebServlet(
    name = "requestServlet", 
    urlPatterns = { "/request-servlet" } //MUST BE UNIQUE!!!
)
 
public class HttpRequestServlet extends HttpServlet {
 
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpServletRequest object
     *@param  response              the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure 
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	//instantiate a new instance of the HttpRequestData javbean
        HttpRequestData requestData = new HttpRequestData();
        
        //assign all properties of the HttpRequestData object with information from the request object
        requestData.setRemoteComputer(request.getRemoteHost());
        requestData.setRemoteComputerAddress(request.getRemoteAddr());
        requestData.setRequestMethod(request.getMethod());
        requestData.setRequestURI(request.getRequestURI());
        requestData.setRequestURL(request.getRequestURL().toString());
        requestData.setServerLocation(request.getLocale().toString());
        requestData.setRequestProtocol(request.getProtocol());
        requestData.setServerName(request.getServerName());
        requestData.setServerPort(request.getServerPort());
        requestData.setQueryString(request.getQueryString());
        requestData.setQueryParameter(request.getParameter("queryParameter"));
        requestData.setUserAgent(request.getHeader("user-agent"));
        
        //add the requestData instance to the request using setAttribute()
        request.setAttribute("requestDataProject3", requestData);
 
        //-----FORWARD TO THE JSP PAGE-----//
        //Create the url
        String url = "/project3index.jsp";

        //instantiate a RequestDispatcher object and assign the url to it
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        
        //Forward to jsp page
        dispatcher.forward(request, response);
 
    }
 
}
