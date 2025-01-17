import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class MoiveDataBase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded...");
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_mock_database", "root","V_!m@L2!!2");
		System.out.println("Connection established");
		System.out.println();
		
			System.out.println();
			System.out.println("1.Add new Movie to database \n2.Display Database\n3.Update DataBase\n4.Delete from Database\n5.Exit");
			System.out.println();
			
			System.out.println("Enter your choice: ");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			System.out.println();
			
			switch(choice)
			{
			case 1:addNewMovie(con);
					break;
			
			case 2:displayDatabase(con);
					break;
			
			case 3:updateDatabase(con);
					break;
					
			case 4:deleteFromDatabase(con);
					break;
					
			default: System.out.println("Invalid choice");
					break;
			}
		}
	
	static void addNewMovie(Connection con) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		String s="insert into movie values(?,?,?,?,?,?,?);";
		PreparedStatement pstmt=con.prepareStatement(s);
		
		System.out.println("Enter movie id: ");
		int id=sc.nextInt();
		
		while(true)
		{
			String s1="select * from movie where id=?;";
			PreparedStatement pstmt1=con.prepareStatement(s1);
			pstmt1.setInt(1, id);
			ResultSet res=pstmt1.executeQuery();
			if(res.next())
			{
				System.out.println("movie id already exist. please give unique id: ");
				id=sc.nextInt();
			}
			else {
				break;
			}
		}
		
		System.out.println("Enter movie name: ");
		String movieName=sc.next();
		
		System.out.println("Enter language: ");
		String lang=sc.next();
		
		System.out.println("Enter budget: ");
		long budget=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter Director name: ");
		String dirName=sc.nextLine();
	
		System.out.println("Enter Male lead name: ");
		String maleLead=sc.nextLine();
		
		System.out.println("Enter Female lead name: ");
		String femaleLead=sc.nextLine();
		
		pstmt.setInt(1,id);
		pstmt.setString(2, movieName);
		pstmt.setString(3, lang);
		pstmt.setLong(4, budget);
		pstmt.setString(5, dirName);
		pstmt.setString(6, maleLead);
		pstmt.setString(7, femaleLead);
		
		int row=pstmt.executeUpdate();
		System.out.println(row+" Data row inserted");
	}
	
	static void displayDatabase(Connection con) throws Exception {
		
		String s="select * from movie;";
		Statement stmt=con.createStatement();
		ResultSet res=stmt.executeQuery(s);
		
		String format = "| %-4s | %-12s | %-8s | %-9s | %-21s | %-21s | %-16s |%n";
		System.out.println("+------+--------------+----------+-----------+-----------------------+-----------------------+------------------+");
		System.out.printf(format, "id", "movie_name", "language", "budget", "director", "male_lead", "female_lead");
        System.out.println("+------+--------------+----------+-----------+-----------------------+-----------------------+------------------+");
		while(res.next())
		{
			System.out.printf(format,res.getInt(1),res.getString(2),res.getString(3),res.getLong(4)
								,res.getString(5),res.getString(6),res.getString(7));
		}
		System.out.println("+------+--------------+----------+-----------+-----------------------+-----------------------+------------------+");
		
	}
	
	
	static void updateDatabase(Connection con) throws Exception {
		// id,movie_name,language,budget,director,male_lead,female_lead
		Scanner sc=new Scanner(System.in);
		System.out.println("You can change the following content: ");
		System.out.println("1.Movie name\n2.Language\n3.Budget\n4.Director\n5.Male lead\n6.Female lead");
		int choice=sc.nextInt();
		
		
			System.out.println("Enter the movie id: ");
			int id=sc.nextInt();
			String s="select * from movie where id=?;";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next())
			{
				if(choice==1)
				{
					
				String s1="update movie set movie_name=? where id=?;";
				PreparedStatement pstmt1=con.prepareStatement(s1);
				System.out.println("Enter the movie name for updation: ");
				sc.nextLine();
				String newMovieName=sc.nextLine();
				
				pstmt1.setString(1, newMovieName);
				pstmt1.setInt(2, id);
				
				int row=pstmt1.executeUpdate();
				System.out.println(row+" updated");	
				}
				
				else if(choice==2)
				{
				String s1="update movie set language=? where id=?;";
				PreparedStatement pstmt1=con.prepareStatement(s1);
				System.out.println("Enter the language for updation: ");
				String lang=sc.next();
				pstmt1.setString(1, lang);
				pstmt1.setInt(2, id);
				
				int row=pstmt1.executeUpdate();
				System.out.println(row+" updated");
				}
				
				else if(choice==3)
				{
					String s1="update movie set budget=? where id=?;";
					PreparedStatement pstmt1=con.prepareStatement(s1);
					System.out.println("Enter the budget for updation: ");
					
					long budget=sc.nextLong();
					pstmt1.setLong(1,budget);
					pstmt1.setInt(2, id);
					
					int row=pstmt1.executeUpdate();
					System.out.println(row+" updated");
				}
				
				else if(choice==4)
				{
					String s1="update movie set director=? where id=?;";
					PreparedStatement pstmt1=con.prepareStatement(s1);
					System.out.println("Enter the director name for updation: ");
					sc.nextLine();
					String director=sc.nextLine();
					pstmt1.setString(1,director);
					pstmt1.setInt(2, id);
					
					int row=pstmt1.executeUpdate();
					System.out.println(row+" updated");
				}
				
				else if(choice==5)
				{
					String s1="update movie set male_lead=? where id=?;";
					PreparedStatement pstmt1=con.prepareStatement(s1);
					System.out.println("Enter the male lead name for updation: ");
					sc.nextLine();
					String maleLead=sc.nextLine();
					pstmt1.setString(1,maleLead);
					pstmt1.setInt(2, id);
					
					int row=pstmt1.executeUpdate();
					System.out.println(row+" updated");
				}
				else if(choice==6)
				{
					String s1="update movie set female_lead=? where id=?;";
					PreparedStatement pstmt1=con.prepareStatement(s1);
					System.out.println("Enter the female lead name for updation: ");
					sc.nextLine();
					String femaleLead=sc.nextLine();
					pstmt1.setString(1,femaleLead);
					pstmt1.setInt(2, id);
					
					int row=pstmt1.executeUpdate();
					System.out.println(row+" updated");
				}
			}
			else {
				System.out.println("Invalid id...");
			}
			
			System.out.println("Do u wanna see the table\n1.yes\n2.no");
			choice=sc.nextInt();
			if(choice==1)
			{
				displayDatabase(con);
			}
			else if(choice==2){
				System.out.println(":)");
			}
			else {
				System.out.println("Invalid choice");
			}
		}
		
	
	
	static void deleteFromDatabase(Connection con) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the movie id: ");
		int id=sc.nextInt();
		
		String s="select * from movie where id=?;";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setInt(1, id);
		ResultSet res=pstmt.executeQuery();
		
		if(res.next())
		{
			String s1="delete from movie where id=?";
			PreparedStatement pstmt1=con.prepareStatement(s1);
			pstmt1.setInt(1, id);
			int row=pstmt1.executeUpdate();
			System.out.println(row+" updated....");
			
		}
		else {
			System.out.println("Invalid id....");
		}
		
		System.out.println("Do u wanna see the updated table\n1.yes\n2.no");
		int choice=sc.nextInt();
		if(choice==1)
		{
			displayDatabase(con);
		}
		else if(choice==2){
			System.out.println(":)");
		}
	}

}
