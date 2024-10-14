//Program for accessing an individual detail`
package jdbcConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded...");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDatabase", "root", "V_!m@L2!!2");
		System.out.println("Connection established");
		
		
		String s="select * from employee where employee_id=?";
		//when there's a placeholder i.e. (?) then i've to use (PreparedStatement) 
		PreparedStatement pstmt=con.prepareStatement(s);
		
		System.out.println("Enter the id: ");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		
		pstmt.setInt(1, id);
		
		ResultSet res=pstmt.executeQuery();
		
		if(res.next())
		{
			/*
			 * employee_id INT first_name VARCHAR last_name VARCHAR department_id INT salary
			 * DECIMAL phone_number VARCHAR email VARCHAR hire_date DATE job_title VARCHAR
			 */
			id=res.getInt(1);
			String fn=res.getString(2);
			String ln=res.getString(3);
			int did=res.getInt(4);
			double sal=res.getDouble(5);
			String ph=res.getString(6);
			String em=res.getString(7);
			String date=res.getString(8);
			String jt=res.getString(9);
			
			System.out.println(id+"  "+fn+"  "+ln+"  "+did+"  "+sal+"  "+ph+"  "+em+"  "+date+"  "+jt);
			
		}
		else {
			System.out.println("Invalid id....");
		}
	}

}
