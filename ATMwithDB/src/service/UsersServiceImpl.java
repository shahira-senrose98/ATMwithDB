package service;

import java.sql.SQLException;
import java.util.List;

import application.Main;
import controller.TransactionController;
import dao.UsersDAO;
import dao.UsersDAOImpl;
import pojo.User;

public class UsersServiceImpl implements UsersService {

	UsersDAO refUserDao;

	@Override
	public void addUser(User sRef) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		refUserDao = new UsersDAOImpl();
		refUserDao.addUser(sRef);
	}

	@Override
	public void withdrawAmt(User sRef, double amt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		refUserDao = new UsersDAOImpl();
		refUserDao.withdrawAmt(sRef, amt);
	}

	@Override
	public void depositAmt(User sRef, double amt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		refUserDao = new UsersDAOImpl();
		refUserDao.depositAmt(sRef, amt);
	}

	@Override
	public List<User> listUsers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		refUserDao = new UsersDAOImpl();
		return 	refUserDao.listUsers();
	}

	@Override
	public void checkStatus(User ref) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		refUserDao = new UsersDAOImpl();
		if(refUserDao.loginValidate(ref) == true) {


			System.out.println("Login Successful!!");
			TransactionController bController = new TransactionController();
			bController.userTransactionController();


		}
		else {
			System.out.println("Not valid... Please restart application.");

		}
	}

	@Override
	public void updateUser(User sref) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		refUserDao = new UsersDAOImpl();
		refUserDao.updateUser(sref);
		System.out.println("Your password has been reset successfully!!\n");

	}

	@Override
	public void showBalance(User sRef) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		refUserDao = new UsersDAOImpl();
		refUserDao.showBalance(sRef);
	}

	@Override
	public void logoutUser(User sRef) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		refUserDao = new UsersDAOImpl();
		refUserDao.logoutUser(sRef);
		System.out.println("You have logged out!");
		Main.main(null);
	}

	@Override
	public void logEverybodyOut() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		refUserDao = new UsersDAOImpl();
		refUserDao.logEverybodyOut();
	}

}