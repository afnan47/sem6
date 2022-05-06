<html>  
<body>  
  
<% out.print("Today is:"+java.util.Calendar.getInstance().getTime()); %>  
<br>
<br>
<%= request.getParameter("name") %>  
  
</body>  
</html>  