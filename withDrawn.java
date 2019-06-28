import java.sql.*;
import java.util.Scanner;
public class withDrawn 
{

	public void decrease()  
	{ 
		try{
			Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		int acc_no;
		System.out.println("Enter your account number");
		acc_no= sc.nextInt(); 
		String query ="select * from deposit where Account_no="+acc_no+""; 
		ResultSet rs2=stmt.executeQuery(query);  
		if(rs2.next())
		{
			System.out.println("Account number matched !"); 
			System.out.println("Your Total amount is "+rs2.getInt("Deposit_Amount"));
			System.out.println("Enter amount to withdrawn"); 
			int amount = sc.nextInt();
			if (rs2.getInt("Deposit_Amount")>amount)
			{ 
				int bal = rs2 .getInt("Deposit_Amount")-amount;
				 query="update deposit set Deposit_Amount ='"+bal+"'where Account_no='"+acc_no+"'";  
			String query1 ="insert into MiniStatement (WithDrawal_Amount,Available_Balance,Account_no)values('"+amount+"','"+bal+"','"+acc_no+"')";
				 stmt.executeUpdate(query); 
				 stmt.executeUpdate(query1);
				    System.out.println("Your amount is successfully withdrawn !"); 
					
			}
			else  
				System.out.println("Insufficient balance"); 
		     	 
		}
		else
			System.out.println("Your account number doesnot matched!\nPlease! enter a correct account number\nThank you!");
		} catch (ClassNotFoundException | SQLException e) {
			 System.out.println("database connection failed");
			 e.printStackTrace();
			 
		
	} 
	 
	}
	}
 