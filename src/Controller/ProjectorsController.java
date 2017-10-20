package Controller;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.SQLError;

import Model.Database;
import Model.Projector;

public class ProjectorsController {
	private Database database = new Database();
	private Connection connection;
	
	public ProjectorsController() {
		if (!database.connect()) {
			System.exit(0);
		} else {
			this.connection = database.getConnection();
		}
	}
	public boolean add(Projector projector) {
		try {
			String SQL = "INSERT INTO projectors (brand, model, ansi_lumens, serial_number, purchase_date, date_last_lamp_change, projector_state) VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(SQL);
			pstmt.setString(1, projector.getBrand());
			pstmt.setString(2, projector.getModel());
			pstmt.setInt(3, projector.getAnsiLumens());
			pstmt.setString(4, projector.getSerialNumber());
			pstmt.setString(5, projector.getPurchaseDate());
			pstmt.setString(6, projector.getDateLastLampChange());
			pstmt.setString(7, projector.getProjectorState());
			pstmt.execute();
			pstmt.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}
}
