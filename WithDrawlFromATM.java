import java.sql.*; 
import java.util.Scanner;
public class WithDrawlFromATM {
	public void reduce() {
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
			System.out.println("Enter amount to withdrawn"); 
			int amount = sc.nextInt();
			if (rs2.getInt("Deposit_Amount")>amount)
			{
				int bal = rs2 .getInt("Deposit_Amount")-amount;
				 query="update deposit set Deposit_Amount ='"+amount+"'where Pin_no='"+pin_no+"'"; 
				 
				 
					String query1 ="insert into MiniStatement (WithDrawal_Amount,Available_Balance,Pin_no)values('"+amount+"','"+bal+"','"+pin_no+"')";
					stmt.executeUpdate(query1);
				    stmt.executeUpdate(query); 
				    System.out.println("Your amount is successfully withdrawn !"); 
				    
					
			} 
			else  
				System.out.println("Insufficient balance"); 
		     	 
		}
		else
			System.out.println("Your pin number doesnot matched!\nPlease! enter a correct pin number\nThank you!");
		} catch (ClassNotFoundException | SQLException e) {
			 System.out.println("database connection failed");
			 e.printStackTrace();
			 
		
	} 
	 
	}

}
