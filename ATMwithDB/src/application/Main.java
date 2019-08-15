package application;

import java.sql.SQLException;
import java.util.Scanner;

import controller.UsersController;

import pojo.User;
import application.Main;
import service.UsersService;
import service.UsersServiceImpl;
import controller.UsersController;
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		UsersController controller = new UsersController();
		controller.logoutEverybody();
		System.out.println("User Home Page : ");
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. Forget Password");
		System.out.println("4. Logout (exit)");
		
		System.out.println("Enter your choice : ");
		
		// Creates new scanner
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		
		switch (input) {
		case "1" :
			controller.registration();
			break;
			
		case "2" :
			controller.login();
			break;
			
		case "3" :
			controller.forgetpass();
			break;
			
		case "4" :
			System.out.println("Logout Successfully!!");
			break;
			
		default: 
			System.out.println("Your choice is invalid");
			break;
		}
}
}
