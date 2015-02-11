package jweb;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/model_news")
public class model_news extends HttpServlet {
private static final long serialVersionUID = 1L;
       
	private java.sql.Connection connection = null;
	private PreparedStatement preparedStatement = null;

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
	
	public ArrayList<reflex_news> display_news() throws SQLException {
		init_db();
        java.sql.Statement transmission = connection.createStatement();
        
		ResultSet result = transmission.executeQuery("SELECT * FROM News Order By date desc;");
		
		ArrayList<reflex_news> News = new ArrayList<reflex_news>();
        while (result.next()) {
            String message1 = result.getString("message");
            String date1 = result.getString("date");
            String auteur1 = result.getString("auteur");
            
            reflex_news news1 = new reflex_news();
            news1.setMessage(message1);
            news1.setDate(date1);
            news1.setAuteur(auteur1);

			News.add(news1);
        }
		return (News);
    }
	
	public ArrayList<reflex_news> add_news(String name, String message, String date) throws SQLException {
		init_db();
        java.sql.Statement transmission = connection.createStatement();
        String auteur = name;
        
        try {
        	preparedStatement = connection.prepareStatement("INSERT into bdd_jweb.News(auteur, message, date) VALUES(?,?,?)");
        	preparedStatement.setString( 1, auteur );    	
        	preparedStatement.setString( 2, message );
        	preparedStatement.setString( 3, date );
        	preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		ResultSet result = transmission.executeQuery("SELECT * FROM News Order By date desc;");
		
		ArrayList<reflex_news> News = new ArrayList<reflex_news>();
        while (result.next()) {
        	 String message1 = result.getString("message");
             String date1 = result.getString("date");
             String auteur1 = result.getString("auteur");
             
             reflex_news news1 = new reflex_news();
             news1.setMessage(message1);
             news1.setDate(date1);
             news1.setAuteur(auteur1);

			News.add(news1);
        }
		return (News);
    }
}