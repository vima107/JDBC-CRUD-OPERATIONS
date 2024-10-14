

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//request.getParameter("id") -> gives me the id in the string format 
		// i'm converting id from string to integer by using parseInt()
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		// here i'm getting string anyways i need string only so i'm not converting it
		String name=request.getParameter("name");
		
		int marks1=Integer.parseInt(request.getParameter("marks1"));
		int marks2=Integer.parseInt(request.getParameter("marks2"));
		int marks3=Integer.parseInt(request.getParameter("marks3"));
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/july_24","root","V_!m@L2!!2");
			
			String s="insert into student values(?,?,?,?,?);";
			PreparedStatement pstmt=con.prepareStatement(s);
			
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setInt(3, marks1);
			pstmt.setInt(4, marks2);
			pstmt.setInt(5, marks3);
			
			int row=pstmt.executeUpdate();
			
			PrintWriter out=response.getWriter();
			
			if(row==0)
			{
				out.println("oh oh something went wrong...");
			}
			else {
				out.println("student data added...");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
