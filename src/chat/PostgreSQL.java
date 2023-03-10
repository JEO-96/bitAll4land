package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class PostgreSQL {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		
		String connurl	= "jdbc:postgresql://localhost:5432/all4chat";
		String user		= "postgres";
		String password = "1234";
		
		try {
			Connection connection = DriverManager.getConnection(connurl, user, password);
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Test");
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				
				System.out.println(num + "\t" + name);
			}
			rs.close();
			stmt.close();
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결실패");
		} finally {
			
		}
	}

}
