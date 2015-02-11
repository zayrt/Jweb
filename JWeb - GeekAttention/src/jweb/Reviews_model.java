package jweb;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reviews_model {
	private Connection connexion = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet result = null;
	private reflex_product p = new reflex_product();
	private List<String> messages = new ArrayList<String>();
	
	public reflex_product find(String id) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Class.forName( "com.mysql.jdbc.Driver" );
		
		connexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bdd_jweb", "root", "azerty" );
		preparedStatement = connexion.prepareStatement( "SELECT *  FROM bdd_jweb.Products WHERE id = ?");
		preparedStatement.setString( 1, id );
		
		result = preparedStatement.executeQuery();
		if (!result.next())
			return null;
        
		p.setId(result.getString("id"));
		p.setNom(result.getString("nom"));
        p.setDescription(result.getString("description"));
        p.setPrix(result.getString("prix"));
        p.setImage(result.getString("image"));
        p.setCategorie(result.getString("categorie"));
        
        preparedStatement = connexion.prepareStatement( "SELECT user_name, review, date_review  FROM bdd_jweb.Review WHERE product_id = ? Order By date_review desc;");
		preparedStatement.setString( 1, id );
		
		result = preparedStatement.executeQuery();
        
        ArrayList<Reflex_review> reviews = new ArrayList<Reflex_review>();
        
        while (result.next()) {
            Reflex_review review = new Reflex_review();
            
            review.setName(result.getString("user_name"));
            review.setReview(result.getString("review"));
            review.setDate(result.getString("date_review"));

			reviews.add(review);
        }
        
        p.setReviews(reviews);
		
        return (p);
	}

	private void validation(String review)
	{
		if ( review.trim().length() < 3 || review.trim().length() > 500  ) {
			messages.add( "Votre avis doit contenir au moins 3 caractères et au maximum 500." );
		}
	}
	
	public ArrayList<String> save( String p_id, String u_name, String review) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		validation(review);
		if (!messages.isEmpty())
			return (ArrayList<String>) messages;
		Class.forName( "com.mysql.jdbc.Driver" );
		
		connexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bdd_jweb", "root", "azerty" );
		preparedStatement = connexion.prepareStatement( "INSERT INTO bdd_jweb.Review (product_id, user_name, review, date_review) VALUES(?, ?, ?, NOW());" );
		preparedStatement.setString( 1, p_id );
		preparedStatement.setString( 2, u_name );
		preparedStatement.setString( 3, review );
		
		preparedStatement.executeUpdate();
		
        return (ArrayList<String>) (messages);
	}
	
}
