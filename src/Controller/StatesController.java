package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.Database;

public class StatesController {
	private Database database = new Database();
	private Connection connection;
	
	public StatesController() {
		if (!database.connect()) {
			System.exit(0);
		} else {
			this.connection = database.getConnection();
		}
	}
	
	public ResultSet states() {
		try {
			String SQL = "SELECT name FROM states ORDER BY name ASC;";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs != null) {
				return rs;
			}
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return null;
	}
	
	public int getStateIdByName(String name) {
		try {
			String SQL = "SELECT id FROM states WHERE name = ?;";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("id");
			}
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return 0;
	}
}
