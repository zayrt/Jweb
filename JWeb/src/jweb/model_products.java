package jweb;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class model_products {

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
	
	public ArrayList<reflex_product> display_products(String cat) throws SQLException {
		init_db();
        java.sql.Statement transmission = connection.createStatement();
        int cat1 = Integer.parseInt(cat);
		ResultSet result = transmission.executeQuery("SELECT * FROM bdd_jweb.Products WHERE categorie ="+ cat1);
		
		ArrayList<reflex_product> list_products = new ArrayList<reflex_product>();
        while (result.next()) {
            String nom = result.getString("nom");
            String description = result.getString("description");
            String prix = result.getString("prix");
            String image = result.getString("image");
            String id = result.getString("id");
            String categorie = result.getString("categorie");
            
            reflex_product produit = new reflex_product();
            produit.setNom(nom);
            produit.setDescription(description);
            produit.setPrix(prix);
            produit.setImage(image);
            produit.setId(id);
            produit.setCategorie(categorie);

			list_products.add(produit);
        }
		return (list_products);
    }
}
