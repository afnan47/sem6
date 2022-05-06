<html>
   <head><title>Declarations</title></head>
   
   <body>
      Declarations1 <br/>
      <%! 
      int x = 5;
      int y = 7;
      int z = 0;
		%>
		
	  Sciptlet1 <br/>
	  <%
      int z = x + y;
      out.println("z="+z); 
       %>
	  
	  Declarations1 <br/>Declarations.jsp
	  <%! 
      int a = 10;
      int b = 20;
      int c = 0;
	  %>
		
	  Scriptlet2<br/>
	  <% int c = a + b;  %>
	  		
		Expression<br/>
		<%= "c="+c %>
		
		Expression<br/>
		<%= "c="+c %>
		
		 <%-- This comment will not be visible in the page source
		 
		 Expression<br/>
		<%= "c="+c %>
		  --%> 
		
		
 
   </body>
</html>