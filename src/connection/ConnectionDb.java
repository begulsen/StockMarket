package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDb {

	public Connection connection() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test","begulsen",""); 
	            Statement stat = conn.createStatement()) {
	        stat.execute("insert into testTable values(100, 'Hello')");
	        try (ResultSet rs = stat.executeQuery("select * from testTable")) {
	            while (rs.next()) {
	                System.out.println(rs.getString("name"));
	            }
	        }
	        return conn;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
}
