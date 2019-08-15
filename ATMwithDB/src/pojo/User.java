package pojo;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String userEmail;
	private String userPassword;
	private String userSecurityKey;
	private double bankBalance;
	private boolean status;
	private int id;

	public static List<User> userList = new ArrayList<>();


	public User(int id, String userEmail, String userPassword, String userSecurityKey, double bankBalance, boolean status) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userSecurityKey = userSecurityKey;
		this.bankBalance = bankBalance;
		this.status = status;
		this.id = id;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public static void setUserList(List<User> userList) {
		User.userList = userList;
	}



	public User() {

	}



	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserSecurityKey() {
		return userSecurityKey;
	}
	public void setUserSecurityKey(String userSecurityKey) {
		this.userSecurityKey = userSecurityKey;
	}

	public static List<User> getUserList() {
		return userList;
	}



	public double getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}





	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}






}