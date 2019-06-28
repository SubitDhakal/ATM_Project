import java.util.Scanner;
import java.sql.*;
public class Transfer
{
public void transfer() 
{	
try 
{ 
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");
	Statement stmt = con.createStatement();
	Scanner sc = new Scanner(System.in);
    System.out.println("Enter  your account number !");
	int acc_no = sc.nextInt();
	String query = "select * from deposit where Account_no="+acc_no+"";
	//String query2 ="select Deposit_Amount from deposit where Account_no="+acc_no+"";
	//ResultSet rs2= stmt.executeQuery(query);
	ResultSet rs= stmt.executeQuery(query);
	
	
	if(rs.next()) 
	{ 
	System.out.println("Account number matched !");
	System.out.println("Your Total amount is "+rs.getInt("Deposit_Amount"));
	
	System.out.println("Enter amount to transfer"); 
	int amount = sc.nextInt();
	if(rs.getInt("Deposit_Amount")>=amount)
	{	
	 int deducted = rs.getInt("Deposit_Amount")-amount;
	   query="update deposit set Deposit_Amount ='"+deducted+"'where Account_no='"+acc_no+"'";  
	  stmt.executeUpdate(query); 
	 
	System.out.println("enter account number of receiver");
	int acco_no = sc.nextInt();
	String query1 = "select   Deposit_Amount  from deposit where Account_no ="+acco_no+"";
	ResultSet rs1 = stmt.executeQuery(query1);
	 
	 
	if(rs1.next())
	{
		
		System.out.println("Account number of receiver is matched !");
	    amount = rs1.getInt("Deposit_Amount") + amount;
	    query1="update deposit set Deposit_Amount ='"+amount+"'where Account_no='"+acco_no+"'";
	    stmt.executeUpdate(query1);
        System.out.println("Your amount is successfully transferred !");
	
	}
	else 
		System.out.println("Account number of receiver doesnot matched !\nPlease enter  correct Account number\nThank you !");
	}
	else 
		System.out.println("Sorry ! Insufficient Balance");
		
	}
	else
		System.out.println("Your Account number  doesnot matched !\nPlease enter  your correct Account number\nThank you !");
	
	

}catch (ClassNotFoundException | SQLException e) {
	 System.out.println("database connection failed");
	 e.printStackTrace();
}

}
}