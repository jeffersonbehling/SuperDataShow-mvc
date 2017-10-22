package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.Database;
import Model.JuridicalPerson;

public class JuridicalPersonsController {
	private Database database = new Database();
	private Connection connection;
	
	public JuridicalPersonsController() {
		if (!database.connect()) {
			System.exit(0);
		} else {
			this.connection = database.getConnection();
		}
	}
	
	public boolean add(JuridicalPerson juridicalPerson) {
		try {
			String SQL = "INSERT INTO juridical_persons (id, cnpj) VALUES (?, ?);";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setInt(1, juridicalPerson.getId());
			pstmt.setString(2, juridicalPerson.getCnpj());
			pstmt.execute();
			pstmt.close();
			
			return true;
						
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return false;
	}
	
	public boolean cnpjIsAlreadyInUse(String cnpj) {
		try {
			String SQL = "SELECT * FROM juridical_persons WHERE cnpj = ?;";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setString(1, cnpj);
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
