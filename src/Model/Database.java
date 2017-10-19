package Model;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Database {
public Connection connection;
	
	public Database() {}

	public boolean connect() {
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/superdatashow_db", "root", "");
			System.out.println("Connected!");
			return true;
		} catch (SQLException ex) {
			System.out.println("Error connecting database: " + ex.getMessage());
		}
		return false;
	}
	
	public void disconnect() {
		try {
			connection.close();
			System.out.println("Disconnected!");
		} catch (SQLException ex) {
			System.out.println("Error disconnecting database: " + ex.getMessage());
		}
	}
}
