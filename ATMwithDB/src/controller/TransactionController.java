package controller;

import java.sql.SQLException;
import java.util.Scanner;

import application.Main;
import pojo.User;
import service.UsersService;
import service.UsersServiceImpl;

public class TransactionController {
	 User refUser;
	 UsersService refService;
	 
	 Scanner sc = new Scanner(System.in);
	 
	 public void userTransactionController() throws ClassNotFoundException, SQLException {
		 userInput();
	 }

	void userInput() throws ClassNotFoundException, SQLException {
		refService = new UsersServiceImpl();
		refUser = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Check Available Bank Balance");
		System.out.println("2. Deposit Amount");
		System.err.println("3. Withdraw Amount");
		
		System.out.println("Enter your choice : ");
		
		String userChoice = sc.next();
		
		switch(userChoice) {
		case "1" :
			
			checkBalance();
			continueUser();
			break;
			
		case "2" :
			
			deposit();
			continueUser();
			break;
			
		case "3" :
			
			withdraw();
			continueUser();
			break;
			
		default: 
			System.out.println("Invalid choice.");
			break;
		}
		
	}

	private void withdraw() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Amount : ");
		double amt1 = sc.nextDouble();
		
		refService.withdrawAmt(refUser,amt1);
		refService.showBalance(refUser);
	}

	private void deposit() throws ClassNotFoundException, SQLException{
		System.out.println("Enter Amount : ");
		double amt = sc.nextDouble();
		
		if (amt > 0) {
			refService.depositAmt(refUser, amt);
			System.out.println(amt + " dollars deposited successfully!");
			refService.showBalance(refUser);
		}
		else {
			System.out.println("Amount can't be negative!");
		}
	}

	private void continueUser() throws ClassNotFoundException, SQLException{
		System.out.println("Wish to continue? y/n");		
		String choice = sc.next();
		
		if (choice.equalsIgnoreCase("y")) {
			System.out.println("Enter your choice: ");
			String num = sc.next();
			switch(num) {
			case "1":
				checkBalance();
				continueUser();
				break;
				
			case "2":
				deposit();
				continueUser();
				break;
				
			case "3":
				withdraw();
				continueUser();
				break;
			
			default : 	
				System.out.println("Invalid Choice");
			}
			
		}
		else if(choice.equalsIgnoreCase("n")) {
			System.out.println("Thank you for banking with us!");
			Main.main(null);
		}
		
	}

	private void checkBalance() throws ClassNotFoundException, SQLException{
		refService.showBalance(refUser);
		
	}
}
