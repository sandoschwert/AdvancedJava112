package java112.project2;

import java.io.*; //for the Print Writer in doGet()
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
 //this is what we need the import javax.servlet.annotation
 //this is a configurations -- when someone types /trivial or /simple in the browser it will map here
@WebServlet(
    name = "trivialServlet", 
    urlPatterns = { "/trivial", "/simple" } //THESE MUST BE UNIQUE!!!
)
public class TrivialServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  //there is alos a doPost() method you can use, we'll learn that later
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>TrivialServlet Here!</h1>");
        System.out.println("Is this logging?"); //this goes in the catalina log
        log("Is this logging?"); //this goes into localhost log **preferred
        out.print("</BODY>");
        out.print("</HTML>");
        out.close(); //must close the print writer or it won't display the information
    }

}

