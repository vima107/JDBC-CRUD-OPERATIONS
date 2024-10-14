package jdbcConnection;
//inserting values to the table

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded.....");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/july_24","root","V_!m@L2!!2");
		System.out.println("Connection established");
		
		String s="insert into student values(?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt=con.prepareStatement(s);
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the id: ");
		int id=sc.nextInt();
		System.out.println("Enter the name: ");
		String name=sc.next();
		System.out.println("Enter marks1: ");
		int marks1=sc.nextInt();
		System.out.println("Enter marks2: ");
		int marks2=sc.nextInt();
		System.out.println("Enter marks3: ");
		int marks3=sc.nextInt();
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, marks1);
		pstmt.setInt(4, marks2);
		pstmt.setInt(5, marks3);
		
		int row=pstmt.executeUpdate();
		System.out.println(row+" effected");
		
	}

}