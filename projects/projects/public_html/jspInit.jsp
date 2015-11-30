<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<%!
 
    private int accessCount = 1;
 
    public int getAccessCount() {
        return accessCount++;
    }
 
    public void jspInit() {
        accessCount = 1;
    }
 
%>


 
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />
 
    <title>JSP Declarations</title>
  </head>
<%
 
String bgColor = request.getParameter("bgColor");
 
if((bgColor == null) || (bgColor.trim().equals(""))) {
    bgColor = "lightyellow";
}
 
%>
 
  <body bgcolor="<%= bgColor %>">
    <h3>JSP Declarations</h3>
 
    <h4>This page has been accessed <%= getAccessCount() %> times.</h4>

  </body>
</html>
