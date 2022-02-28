<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@
        page import ="java.util.* , model.*"
    %>
<!DOCTYPE html>
<html>
 <head>
  <style>
     
    </style>
  <meta charset="ISO-8859-1">
  <title>Find Contacts</title>
  <link href="./assets/css/display.css" rel="stylesheet" type="text/css">
 </head>
 <body>
       
          <%
            Contact contact = (Contact)request.getAttribute("contact");         
        %>
        <p>Contact Details:</p>
        <div class="card" style="width:400px">
          <img class="card-img-top" src="./assets/<%=contact.getContactImage()%>" alt="Card image" style="width:100%">
          <div class="card-body">
            <h4 class="card-title">Name:<%=contact.getContactName() %></h4>
            <p class="card-text">Number:<%=contact.getContactId() %></p>
            <p class="card-text">Number:<%=contact.getContactNumber() %></p>    
          </div>
        </div>
 </body>
</html>