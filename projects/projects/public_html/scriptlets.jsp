<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />
 
    <title>JSP Scriptlets</title>
  </head>
 
<%
 
String bgColor = request.getParameter("bgColor");
 
if((bgColor == null) || (bgColor.trim().equals(""))) {
    bgColor = "gray";
}
 
%>
 
  <body bgcolor="<%= bgColor %>">
    <h3>JSP Scriptlets</h3>
 
    <ul>
      <li>
 
<%
 
String greeting = "Well hi there!";
greeting += " This is fun.";
out.println(greeting);
 
%>
 
      </li>
      <li>
      
<% 

int number = 5;
number = number - 3;
out.println("The number is " + number);

%>
      
      </li>
    </ul>
  </body>
</html>
