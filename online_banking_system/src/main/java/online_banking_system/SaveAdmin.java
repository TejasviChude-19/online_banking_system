package online_banking_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SaveAdmin") 
public class SaveAdmin extends GenericServlet  {

@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_banking","root","Tejasvi@12345");
		      PreparedStatement ps = con .prepareStatement("insert into admin(id,name,email,password)values(?,?,?,?)");
		      ps.setInt(1, Integer.parseInt(id));
		      ps.setString(2, name);
		      ps.setString(3, email);
		      ps.setString(4, password);
		      
		      
		      ps.execute();
		      
		      RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		      rd.forward(req, res) ;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch  (SQLException e) 
		{
			e.printStackTrace();
		}
	}
  
}
