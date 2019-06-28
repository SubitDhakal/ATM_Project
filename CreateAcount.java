/*import java.sql.Connection;
import java.sql.Statement*/
import java.util.Random; 
import java.util.Scanner;
import java.sql.*;
public class CreateAcount 
{ 
	public void  createAccount() throws Exception {
        	  Scanner sc = new Scanner(System.in);
        	    Random rand = new Random(); 
        	Class.forName("com.mysql.jdbc.Driver");
 			 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");
	        Statement stmt = cn.createStatement();
	         String fname,lname,mname,address,phone;
	          char choice;
	         char sex;
	         long acc_no,pin_no;
	         acc_no = rand.nextInt(10000); 
	 	    pin_no=rand.nextInt(10000); 
	 		 System.out.println("Enter Your First Name"); 
     		fname = sc.nextLine();
     		System.out.println("Enter your Middle Name");
     		mname=sc.nextLine();
     		System.out.println("Enter Your Last Name");
     		lname= sc.nextLine();
     		System.out.println("Enter Your address"); 
     	    address = sc.nextLine(); 
     		System.out.println("Enter Your Phone Number"); 
     		phone = sc.nextLine();
             System.out.println("Enter Your Gender (M/F)"); 
     		sex = sc.next().charAt(0); 
     		System.out.println("Your Account Number Is "  +acc_no);
    	    System.out.println("Do you want to create an ATM card ?\nEnter your choice(Y/N)");
            choice = sc.next().charAt(0);
            if (choice =='Y'||choice=='y')    
            {
            	System.out.println("Your ATM pin number is "+pin_no);
           	 String query = "insert into createaccount(First_name,Middle_name,Last_name,Address,Phone,Gender,Account_no,Pin_no) "
      		 		+ "values('"+fname+"','"+mname+"','"+lname+"','"+address+"','"+phone+"','"+sex+"' ,'"+acc_no+"','"+pin_no+"')";
           	String query1 ="insert into deposit (Account_no,Pin_no)values('"+acc_no+"','"+pin_no+"')";
            stmt.executeUpdate(query);  
            stmt.executeUpdate(query1); 
            }   
            else  if (choice=='N'||choice=='n') 
            {  	
            	System.out.println("Thank You !");  
            	 String query = "insert into createaccount(First_name,Middle_name,Last_name,Address,Phone,Gender,Account_no) "
          		 		+ "values('"+fname+"','"+mname+"','"+lname+"','"+address+"','"+phone+"','"+sex+"' ,'"+acc_no+"')";
            	String query1 ="insert into deposit (Account_no)values('"+acc_no+"')";
            	stmt.executeUpdate(query);
            	stmt.executeUpdate(query1);
            } 
             
            else 
            { 
        	System.out.println("Invalid Input");
            }
            System.out.println("Your Account is created successfully !");
            
     	
	 
}  
}

