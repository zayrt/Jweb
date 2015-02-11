package jweb;

import java.sql.DriverManager;
import java.sql.SQLException;

public class model_ban {
private java.sql.Connection connection = null;
	
	void init_db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_jweb", "java", "jweb");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void ban_user(String user) {
		init_db();
        
        try {
        	java.sql.Statement transmission = connection.createStatement();
            transmission.executeUpdate("UPDATE bdd_jweb.User set isban=1 WHERE name='" + user +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
}
