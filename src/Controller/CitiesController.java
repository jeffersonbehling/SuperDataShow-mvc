package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.Database;

public class CitiesController {
	private Database database = new Database();
	private Connection connection;
	
	public CitiesController() {
		if (!database.connect()) {
			System.exit(0);
		} else {
			this.connection = database.getConnection();
		}
	}
	
	public ResultSet cities(int stateId) {
		try {
			String SQL = "SELECT name FROM cities WHERE state_id = ?;";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setInt(1, stateId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs != null) {
				return rs;
			}
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return null;
	}
	
	public int getCityIdByName(String name, int stateId) {
		try {
			String SQL = "SELECT id FROM cities WHERE name = ? AND state_id = ? ORDER BY name ASC;";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setInt(2, stateId);
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
