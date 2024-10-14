package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) throws Exception
	{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded boiiii....");
		System.out.println();
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDatabase", "root", "V_!m@L2!!2");
		System.out.println("Connection Established boiii");
		
		String s="select * from employee";
		Statement stmt=con.createStatement();
		ResultSet res=stmt.executeQuery(s);
		
		System.out.println();
		ResultSetMetaData rsmd=res.getMetaData();
		for(int i=1;i<=rsmd.getColumnCount();i++)
		{
			System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i));
		}
		System.out.println();
		
		while(res.next()==true)
		{	
			int id=res.getInt(1);
			String fn=res.getString(2);
			String ln=res.getString(3);
			int dn=res.getInt(4);
			double sal=res.getDouble(5);
			
			String pn=res.getString(6);
			String e=res.getString(7); 
			String hd=res.getString(8);
			 
			String j=res.getString(9);
			System.out.println(id+"      "+fn+"      "+ln+"     "+dn+"     "+sal+"     "+pn+
					"    "+e+"  "+hd+"       "+j);
		}
	}
}
