package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.MyConnection;
import pojo.User;

public class UsersDAOImpl implements UsersDAO {
	boolean status;


	@Override
	public List<User> listUsers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		List<User> myList = new ArrayList<>();
		Connection con = MyConnection.prepareConnection();
		Statement st = con.createStatement();

		String sql = "SELECT * FROM users";

		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getBoolean(6));
			myList.add(user);
		}

		return myList;
	}


	@Override
	public void addUser(User sRef) throws ClassNotFoundException, SQLException {
		Connection con = MyConnection.prepareConnection();
		Statement st = con.createStatement();

		String sqlInsert = "INSERT INTO users ";
		sqlInsert += "VALUES (";
		sqlInsert += "'" + sRef.getId() +"',";

		sqlInsert += "'" + sRef.getUserEmail() +"',";
		sqlInsert += "'" + sRef.getUserPassword() +"',";
		sqlInsert += "'" + sRef.getUserSecurityKey() +"',";
		sqlInsert += "'" + sRef.getBankBalance()+"',";
		sqlInsert += "'" + sRef.isStatus()+"')";


		st.executeUpdate(sqlInsert);
		User.getUserList().add(sRef);

		System.out.println("Registration Successful....");


		// TODO Auto-generated method stub

	}

	@Override
	public void withdrawAmt(User sref, double amt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = MyConnection.prepareConnection();
		Statement st = con.createStatement();
		String get = "SELECT * FROM users WHERE status='true'";
		ResultSet getUser = st.executeQuery(get);

		while(getUser.next()) {
			sref = new User(getUser.getInt(1), getUser.getString(2), getUser.getString(3), getUser.getString(4), getUser.getDouble(5), getUser.getBoolean(6));
		}

		if (sref.getBankBalance() < amt) {
			System.out.println("Sorry!! Insufficient Balance");
		}else {
			double newAmt = sref.getBankBalance() - amt;
			String sqlUpdate = "UPDATE users SET user_balance= '"+ newAmt + "' WHERE user_id=" + sref.getId();

			st.executeUpdate(sqlUpdate);

			System.out.println("Transaction Successful");
			
		}

	}

	@Override
	public void depositAmt(User sref, double amt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = MyConnection.prepareConnection();
		Statement st = con.createStatement();
		String get = "SELECT * FROM users WHERE status='true'";
		ResultSet getUser = st.executeQuery(get);

		while(getUser.next()) {
			sref = new User(getUser.getInt(1), getUser.getString(2), getUser.getString(3), getUser.getString(4), getUser.getDouble(5), getUser.getBoolean(6));
		}


		double newAmt = sref.getBankBalance() + amt;
		String sqlUpdate = "UPDATE users SET user_balance= '"+ newAmt + "' WHERE user_id=" + sref.getId();

		st.executeUpdate(sqlUpdate);

		//		Connection con2 = MyConnection.prepareConnection();
		//		Statement st2 = con2.createStatement(); 
		//
		//		String sql = "SELECT user_balance FROM users WHERE user_id='" + sref.getId() + "'" ;
		//
		//		ResultSet rs1 = st2.executeQuery(sql);
		//		while(rs1.next()) {
		//			if (rs1.getInt(1) == sref.getId()) {
		//				System.out.println("Available Balance: $" + rs1.getDouble(1));
		//
		//			}
		//		}	

	}



	@Override
	public boolean loginValidate(User ref) throws ClassNotFoundException, SQLException {
		List<User> myList = new ArrayList<>();
		Connection con = MyConnection.prepareConnection();
		Statement st = con.createStatement();

		String sql = "SELECT * FROM users";

		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getBoolean(6));
			myList.add(user);
		}

		for (int i=0; i<myList.size(); i++) {

			User a = myList.get(i);

			if ((ref.getUserEmail().equals(a.getUserEmail())) && (ref.getUserPassword().equals(a.getUserPassword())) ){
				String updateStatus = "UPDATE users SET status='true' WHERE user_id='" + a.getId() + "'";
				st.executeUpdate(updateStatus);

				ref.setStatus(true);

				status = true;

			}
		}


		return status;
	}

	@Override
	public void updateUser(User sref) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = MyConnection.prepareConnection();
		Statement st = con.createStatement(); 

		String sqlUpdate = "UPDATE users SET user_password= '"+ sref.getUserPassword() + "',user_sk='" + sref.getUserSecurityKey() + "' WHERE user_id=" + sref.getId();

		st.executeUpdate(sqlUpdate);

	}

	@Override
	public void showBalance(User sRef) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = MyConnection.prepareConnection();
		Statement st = con.createStatement();

		String get = "SELECT * FROM users WHERE status='true'";
		ResultSet getUser = st.executeQuery(get);

		while(getUser.next()) {
			sRef = new User(getUser.getInt(1), getUser.getString(2), getUser.getString(3), getUser.getString(4), getUser.getDouble(5), getUser.getBoolean(6));
		}

		String sql = "SELECT user_balance FROM users WHERE user_id='" + sRef.getId() + "'" ;

		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println("Available Balance: $" + rs.getInt(1));
			//				System.out.println("Available Balance: $" + amt);

		}	

	}


	@Override
	public void logoutUser(User sRef) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = MyConnection.prepareConnection();
		Statement st = con.createStatement();
		String get = "SELECT * FROM users WHERE status='true'";
		ResultSet getUser = st.executeQuery(get);

		while(getUser.next()) {
			sRef = new User(getUser.getInt(1), getUser.getString(2), getUser.getString(3), getUser.getString(4), getUser.getDouble(5), getUser.getBoolean(6));
		}
		String sqlUpdate = "UPDATE users SET status= 'false' WHERE user_id=" + sRef.getId();

		st.executeUpdate(sqlUpdate);
	}


	@Override
	public void logEverybodyOut() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = MyConnection.prepareConnection();
		Statement st = con.createStatement();
		String sqlUpdate = "UPDATE users SET status= 'false'";

		st.executeUpdate(sqlUpdate);
	}

}