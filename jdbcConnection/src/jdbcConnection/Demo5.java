//Deleting value from table
package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("driver loaded...");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/july_24","root","V_!m@L2!!2");
			System.out.println("Connection established...");
			
			String s="delete from student where id=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter id: ");
			int id=sc.nextInt();
			
			pstmt.setInt(1, id);
			
			int row=pstmt.executeUpdate();
			
			System.out.println();
			System.out.println(row+" effected...");		
	}
}
