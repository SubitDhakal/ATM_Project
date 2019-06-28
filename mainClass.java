import java.sql.*;
import java.util.Scanner;
public class mainClass
{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Go To Bank\n2.Go To ATM\nExit");
		System.out.println("Enter your choice");
		int choice =sc.nextInt();
		while (true) {
		switch(choice)
		{
		case 1:
			System.out.println("Welcome to Bank");
			System.out.println("1.Create Account\n2.Deposit\n3.Withdrawal\n4.Transfer\n");
		    int achoice = sc.nextInt();
			switch(achoice)
			{
			case 1:
				CreateAcount CA = new CreateAcount();
				CA.createAccount();
				break;
			case 2:
				Deposite DE = new Deposite();
				DE.deposite();
				break;
			case 3:
			    withDrawn WD = new withDrawn();
			    WD.decrease();
			    break;
			case 4:
				Transfer TF = new Transfer();
				TF.transfer();
				break;
			default:
				System.out.println("Invalid Input");
			}
			break;
		case 2:
			System.out.println("Welcome to ATM");
			System.out.println("1.Change pin\n2.Balance Enquiry\n3.With Drawal\n");
			System.out.println("Enter your choice");
			int bchoice = sc.nextInt();
			switch(bchoice)
			{
			case 1:
				ChangePin CP = new ChangePin();
				CP.changePin();
				break; 
			case 2:
				BalanceEnquiry BE = new BalanceEnquiry();
				BE.enquiry();
				break;
			case 3:
				WithDrawlFromATM WDA = new WithDrawlFromATM();
				WDA.reduce();
				break;
			}
			break;
		case 3:
			System.exit(0);
			break;
		default:
		  System.out.println("Invalid Input");
		}
		}
	}
}