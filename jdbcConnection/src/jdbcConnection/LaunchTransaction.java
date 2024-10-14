package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class LaunchTransaction {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded boiiii....");
		System.out.println();
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/july_24", "root", "V_!m@L2!!2");
		System.out.println("Connection Established boiii");
		
		Scanner sc=new Scanner(System.in);
		
		// By default in java the auto commit file be in 'true' i.e, if i terminate the program just after entering the data for 1 st student on row will be add
		// and another one will remain as it is... so the thing is the program should execute successfully without any problem or else it should not at all
		//like for example see.. if i make a money transaction the money is deducted from my account and some problem got occur within a program and the money 
		// did not created to my friend account it's a huge problem for that.. to solve this problem
		// i've to do setAutoCommit(false) so any changes happening will be stored in the temporary storage and once it encounters commit() at the end line of program
		// it will store the data into actual database... from this i can reduce the problem of partial execution..
		con.setAutoCommit(false);
		
		String s="insert into student values(?,?,?,?,?);";
		PreparedStatement pstmt=con.prepareStatement(s);
		
		System.out.println("id: ");
		int id=sc.nextInt();
		System.out.println("name: ");
		String name=sc.next();
		System.out.println("marks 1: ");
		int m1=sc.nextInt();
		System.out.println("marks 2: ");
		int m2=sc.nextInt();
		System.out.println("marks 3: ");
		int m3=sc.nextInt();
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, m1);
		pstmt.setInt(4, m2);
		pstmt.setInt(5, m3);
		
		pstmt.executeUpdate();
		
		
		String s1="insert into student values(?,?,?,?,?);";
		PreparedStatement pstmt1=con.prepareStatement(s1);
		
		System.out.println("id: ");
		int id1=sc.nextInt();
		System.out.println("name: ");
		String name1=sc.next();
		System.out.println("marks 1: ");
		int m11=sc.nextInt();
		System.out.println("marks 2: ");
		int m21=sc.nextInt();
		System.out.println("marks 3: ");
		int m31=sc.nextInt();
		
		pstmt1.setInt(1, id1);
		pstmt1.setString(2, name1);
		pstmt1.setInt(3, m11);
		pstmt1.setInt(4, m21);
		pstmt1.setInt(5, m31);
		
		pstmt1.executeUpdate();
		
		
		con.commit();
		
		
		
	}

}
