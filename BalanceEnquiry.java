import java.sql.*; 
import java.util.Scanner;

public class BalanceEnquiry {
	public void enquiry()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		int pin_no;
		System.out.println("Enter your pin number");
		pin_no= sc.nextInt(); 
		String query ="select * from deposit where Pin_no="+pin_no+""; 
		ResultSet rs2=stmt.executeQuery(query);  
		if(rs2.next())
		{
			System.out.println("pin  number matched !"); 
			System.out.println("Your Total amount is "+rs2.getInt("Deposit_Amount"));
		}
		else
			System.out.println("pin number is not matched");
		}catch (ClassNotFoundException | SQLException e) {
			 System.out.println("database connection failed");
			 e.printStackTrace();
			 
	}
		
	

	}
	}
