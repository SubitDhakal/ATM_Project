import java.util.Scanner; 
import java.sql.*;
public class Deposite {
 
	public void deposite() throws Exception
	{
		try {	 Class.forName("com.mysql.jdbc.Driver");	
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");
				Statement stmt = con.createStatement();
			   
		
		CreateAcount CA = new CreateAcount();  
	    Scanner sc = new Scanner(System.in); 
		System.out.println("Do you have an account(Y/N)?"); 
		long  amount1,acco_no;  
		char choice;
		choice = sc.next().charAt(0); 
		if(choice=='Y'||choice=='y') 
		{
			System.out.println("Enter your Account number");
			acco_no = sc.nextLong();
			String query = "select * from deposit where Account_no="+acco_no+"";
			  ResultSet rs1 = stmt.executeQuery(query);  
			  if (rs1.next()) 
			{ 
			  
				System.out.println("Account number matched"); 
				System.out.println("Enter amount to deposite");  
				amount1 = sc.nextLong();
				amount1+=rs1.getInt("Deposit_Amount");
			query="update deposit set Deposit_Amount ='"+amount1+"'where Account_no='"+acco_no+"'";  
		    stmt.executeUpdate(query); 
			System.out.println("Your amount is successfully deposited !"); 
		   }
			  else
				{ 
				
					System.out.println("Account number doesnot matched.");
				}
			 
		}
		 else if(choice=='N'||choice=='n') 
			{    
				CA.createAccount();
				   
			} 
		
		
}catch (ClassNotFoundException | SQLException e) {
	 System.out.println("database connection failed");
	 e.printStackTrace();
	}
	}
	}

	
	

	
