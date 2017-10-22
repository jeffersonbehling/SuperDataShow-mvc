package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.Database;
import Model.PhysicalPerson;

public class PhysicalPersonsController {
	private Database database = new Database();
	private Connection connection;
	
	public PhysicalPersonsController() {
		if (!database.connect()) {
			System.exit(0);
		} else {
			this.connection = database.getConnection();
		}
	}
	
	public boolean add(PhysicalPerson physicalPerson) {
		try {
			String SQL = "INSERT INTO physical_persons (id, cpf, rg, birthday) VALUES (?, ?, ?, ?);";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setInt(1, physicalPerson.getId());
			pstmt.setString(2, physicalPerson.getCpf());
			pstmt.setString(3, physicalPerson.getRg());
			pstmt.setString(4, physicalPerson.getBirthday());
			pstmt.execute();
			pstmt.close();
			
			return true;
			
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return false;
	}
	
	public boolean cpfIsAlreadyInUse(String cpf) {
		try {
			String SQL = "SELECT * FROM physical_persons WHERE cpf = ?;";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setString(1, cpf);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return false;
	}
	
	public boolean rgIsAlreadyInUse(String rg) {
		try {
			String SQL = "SELECT * FROM physical_persons WHERE rg = ?;";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setString(1, rg);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return false;
	}
}
