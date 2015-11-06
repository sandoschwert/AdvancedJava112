package java112.labs3;
import java.io.*; //for the Print Writer in doGet()
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is part of the MVC Challenge
 * @author    sschwert and dhafenstein
 */
 //this is what we need the import javax.servlet.annotation
 //this is a configurations -- when someone types /trivial or /simple in the browser it will map here
@WebServlet(
    name = "mvcServlet", 
    urlPatterns = { "/mvcServlet", "/mvcTeam" } //THESE MUST BE UNIQUE!!!
)
	
/**
* The MVCServlet class is described above and is a descendant of HttpServlet
*/
public class MVCServlet extends HttpServlet {

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
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><link rel=\"stylesheet\" type=\"text/css\" href=\"css/mvcServlet.css\"><TITLE>MVC Challenge</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<div id=\"site_content\">");
        out.print("<h1>The Planets of Our Solar System</h1>");
        out.print("<h3>Sandi and Debbie</h3>");
        out.print("<div id=\"pics\">");
        out.print("<img alt=\"summer trail\" src=\"images/highSummerTrail.jpg\" />");
        out.print("<br />");
        out.print("</div>");
        out.print("<br />");
        out.print("<a href=\"/java112/index.jsp\">Take me home</a>");
        out.print("<br />");
        out.print("<a target=_blank href=\"http://www.devilslakewisconsin.com/activities/hiking/\">Take me to the trails</a>");
        out.print("<br />");
        out.print("<a href=\"/java112/props\">Properties</a>");
        out.print("<br />");
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

