<html>
   <head><title>Scriptlet</title></head>
   
   <body>
     Scriptlet!<br/>
      <%
      out.println("THIS IS Scriptlet Example");   
      out.println("<br/>"); 
      out.println("\n Your IP address is " + request.getRemoteAddr());
      
      out.println("<br/>"); 
      int x = 5;
      int y = 7;
      int z = x + y;
      out.println("z="+z); 
       %>
      
      
      
      
       <%-- 
        <%
      out.println("THIS IS Scriptlet Example");   
      out.println("<br/>"); 
      out.println("\n Your IP address is " + request.getRemoteAddr());
      
      out.println("<br/>"); 
      int a = 5;
      int b = 7;
      int c = a + b;
      out.println("z="+c); 
       %>
       
       --%>
       
       
       
   </body>
</html>