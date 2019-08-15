package service;

import java.sql.SQLException;
import java.util.List;

import pojo.User;

public interface UsersService {

	public void addUser(User sRef) throws ClassNotFoundException, SQLException;
	public void withdrawAmt(User sRef, double amt) throws ClassNotFoundException, SQLException;
	public void depositAmt(User sRef, double amt) throws ClassNotFoundException, SQLException;
	public  List<User> listUsers() throws ClassNotFoundException, SQLException;
	void checkStatus(User ref) throws ClassNotFoundException, SQLException;
	public void updateUser(User sref) throws ClassNotFoundException, SQLException;

	public void showBalance(User sRef) throws ClassNotFoundException, SQLException;
	public void logoutUser(User sRef) throws SQLException, ClassNotFoundException;
	public void logEverybodyOut() throws ClassNotFoundException, SQLException;


}