package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

//updating table

public class Demo4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded...");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/july_24","root","V_!m@L2!!2");
		System.out.println("Conection Established");
		
		String s="update student set name=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name: ");
		String name=sc.next();
		System.out.println("Enter the id: ");
		int id=sc.nextInt();
		
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		
		int row=pstmt.executeUpdate();
		//pstmt.executeUpdate() will return int type data;
		System.out.println(row+" effected..");
		
	}

}
