package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/biblioteca?useTimezone=true&serverTimezone=UTC", "root", "3968wyxb");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
