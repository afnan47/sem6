

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session=request.getSession();
		
		String user=request.getParameter("username");
		String upass=request.getParameter("pass");
		
		//database connection
		try {
		
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/myclg", "root", "");
			 Statement stm=conn.createStatement();
			 ResultSet rs=stm.executeQuery("select * from login");
			 boolean flag=false;
			 
			 while(rs.next())
			 {
				 String u=rs.getString(1);
				 String p=rs.getString(2);
				 
				 if(user.equals(u) && upass.equals(p))
				 {
		     	 session.setAttribute("username",user);
					 flag=true;
					 response.sendRedirect("Home.jsp");
					 
				 }
				 
					

		}
			 
			 if(flag==false)
			 {
				 response.sendRedirect("index.html");
				 
			 }
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
