package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public static  Connection prepareConnection() throws SQLException, ClassNotFoundException{

		String connectionURL = "jdbc:mysql://localhost:3306/atm";

		String uname = "root";
		String pwd = "admin";

		//Register JDBC Driver

		Class.forName("com.mysql.jdbc.Driver");

		//open a connection

		Connection ref = DriverManager.getConnection(connectionURL, uname, pwd);
		return ref;
	}
}
