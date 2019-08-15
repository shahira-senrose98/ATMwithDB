package controller;

import java.sql.SQLException;
import java.util.Scanner;

import application.Main;
import pojo.User;
import service.UsersService;
import service.UsersServiceImpl;

public class UsersController {

	private UsersService usersServiceRef;
	private User ref;


	public void registration() throws ClassNotFoundException, SQLException {
		usersServiceRef = new UsersServiceImpl();
		ref = new User();
		addInput();
	}

	public void login() throws ClassNotFoundException, SQLException {
		usersServiceRef = new UsersServiceImpl();
		ref = new User();
		userInput();
	}

	public void logoutEverybody() throws ClassNotFoundException, SQLException {
		usersServiceRef = new UsersServiceImpl();
		usersServiceRef.logEverybodyOut();
	}

	public void forgetpass() throws ClassNotFoundException, SQLException {
		usersServiceRef = new UsersServiceImpl();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email Address : ");
		String email = sc.next();

		System.out.println("Enter your Security Key : ");
		String sk = sc.next();

		for (int i=0; i<usersServiceRef.listUsers().size(); i++) {

			User a = usersServiceRef.listUsers().get(i);

			if ((email.equals((a.getUserEmail()))) && (sk.equals((a.getUserSecurityKey())))){


				System.out.println("Enter new password : ");
				String password = sc.next();

				System.out.println("Retype Password: ");
				String retype = sc.next();

				if (password.equals(retype)) {

					System.out.println("What is your favourite color? ");
					String color = sc.next();
					System.out.println( color + " is your security key, if you forget your password");

					a.setUserSecurityKey(color);
					a.setUserPassword(password);
					usersServiceRef.updateUser(a);

					Main.main(null);
				}else {
					System.out.println("Password doesn't match.");
				}


			}
		}


	}

	private void userInput() throws ClassNotFoundException, SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email Address : ");
		String email = sc.next();
		//		refUser.setUserEmail(email);

		System.out.println("Enter your password : ");
		String password = sc.next();
		//		refUser.setUserPassword(password);

		ref = new User(0, email, password, "", 0.0, false);

		usersServiceRef.checkStatus(ref);

	}

	private void addInput() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		User a;


		//step 1 : ask user ID and Password
		System.out.println("Enter Email address : ");
		String emailInput = sc.next();

		for (int i=0; i<usersServiceRef.listUsers().size(); i++) {

			a = usersServiceRef.listUsers().get(i);

			if (emailInput.equalsIgnoreCase(a.getUserEmail())) {

				System.out.println("Email already exists!!!");
				break;
			}else {

				System.out.println("Enter User Password : ");
				String password = sc.next();

				System.out.println("Re-type Password : ");
				String retypePass = sc.next();

				if (password.equals(retypePass)) {


					System.out.println("What is your favourite color?  ");
					String securityKey = sc.next();

					System.out.println(securityKey + " is your security key, incase if you forget your password.");

					//step 2 : create object of User class
					User refUser = new User(usersServiceRef.listUsers().size() + 1, emailInput, password, securityKey, 0, false);
					usersServiceRef.addUser(refUser);
					System.out.println("Would you like to login? (Y/N)");
					String choice = sc.next();

					switch(choice) {
					case "Y":
						userInput();
						break;

					case "N":
						System.out.println("OK THANKS BYE");
						break;

					default: 
						System.out.println("You have entered an invalid choice, please restart application.");
						break;
					}



				}else {
					System.out.println("Password doesnt match!!");
				}
			}



		}

	}
}