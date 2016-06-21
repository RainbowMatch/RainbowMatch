package ch.patrickguenthard.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ch.patrickguenthard.constants.Constants;

public class DataAccessConnectionInitiator {
	private static DataAccessConnectionInitiator instance = null;
	
	private Connection conn;
	
	protected DataAccessConnectionInitiator(){
		try {
			Class.forName(Constants.JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.DB_USERNAME,Constants.DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DataAccessConnectionInitiator getInstance(){
		if(instance == null){
			instance = new DataAccessConnectionInitiator();
		}
		return instance;
	}

	public Connection getConnection() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
}
