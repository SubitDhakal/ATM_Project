import java.sql.*; 
import java.util.Scanner;
public class ChangePin { 
	public void changePin() { 
		try {
	    Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");
		Statement stmt = con.createStatement();
		System.out.println("Enter your pin number");
		int pin_no = sc.nextInt();
		String query = "select * from deposit where Pin_no="+pin_no+"";
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()) {
			System.out.println("Pin number matched !");
			System.out.println("Enter new pin number of four digit");
			int pin_no1 = sc.nextInt();
			if(pin_no1<1000||pin_no1>10000) {
				System.out.println("Please enter pin number of only four digit\n Thank you! ");
				
			}
			else
			{
				  query="update deposit set Pin_no ='"+pin_no1+"'where Pin_no='"+pin_no+"'";
				  String query1="update createaccount set Pin_no ='"+pin_no1+"'where Pin_no='"+pin_no+"'";
				  stmt.executeUpdate(query);
				  stmt.executeUpdate(query1);
			      System.out.println("Your pin number is successfully changed.");
				
			}
			
			
		}
		else
			System.out.println("Pin number is not matched\nPlease enter correct pin number\nThank you!");
			
		}catch (ClassNotFoundException | SQLException e) {
			 System.out.println("database connection failed");
			 e.printStackTrace();}
		
 	
	}
 
}
