<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String usern=session.getAttribute("username").toString() ;%>
<h2>WELCOME <%out.print(usern); %></h2>
 <a href="logout.jsp">Logout</a>
</body>
</html>