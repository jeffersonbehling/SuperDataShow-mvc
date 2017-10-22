package Controller;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.Client;
import Model.Database;

public class ClientsController {
	private Database database = new Database();
	private Connection connection;
	
	public ClientsController() {
		if (!database.connect()) {
			System.exit(0);
		} else {
			this.connection = database.getConnection();
		}
	}
	
	public int add(Client client) {
		try {
			String SQL = "INSERT INTO clients (name, email, telephone, street, city_id) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setString(1, client.getName());
			pstmt.setString(2, client.getEmail());
			pstmt.setString(3, client.getTelephone());
			pstmt.setString(4, client.getStreet());
			pstmt.setInt(5, client.getCityId());
			pstmt.execute();
		
			int id = (int) pstmt.getLastInsertID();
			pstmt.close();
			
			return id; 	
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return 0;
	}
}
