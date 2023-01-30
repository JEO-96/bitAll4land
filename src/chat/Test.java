package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");

		String connurl = "jdbc:postgresql://localhost:5432/all4chat";
		String user = "postgres";
		String password = "1234";

		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat simple = new SimpleDateFormat("YYYY-MM-DD hh:mm");
		simple.format(now);
		
		System.out.println("---" + now);
		try {
			Connection connection = DriverManager.getConnection(connurl, user, password);
			Statement stmt = connection.createStatement();
			System.out.println(simple.format(now));
			stmt.executeQuery("INSERT INTO users (user_id, nickname, password, kick_count, last_login)"
					+ "VALUES ('user3', 'user3','1234',0,'" + simple.format(now) + "');");

//			while (rs.next()) {
//				
//
//				System.out.println("성공?");
//			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결실패");
		} finally {

		}
	}
}
