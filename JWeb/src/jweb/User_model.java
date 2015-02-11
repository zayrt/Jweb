package jweb;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class User_model {
	private Connection connexion = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultat = null;
	private List<String> errors = new ArrayList<String>();
	private int id;
	private String email;
	private String name;
	private boolean ban;
	private boolean admin;

	public User_model() {
	}
	
	private String convert_to_md5(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
	
	public User_model find(String e, String p) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Class.forName( "com.mysql.jdbc.Driver" );
		
		connexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bdd_jweb", "java", "jweb" );
		preparedStatement = connexion.prepareStatement( "SELECT id, email, name, isban, isadmin  FROM bdd_jweb.User WHERE email = ? && password = ?");
		preparedStatement.setString( 1, e );
		preparedStatement.setString( 2, convert_to_md5(p) );
		
		resultat = preparedStatement.executeQuery();
		
		if (!resultat.next())
			return null;
		id = resultat.getInt("id");
		email = resultat.getString("email");
		name = resultat.getString("name");
		ban = resultat.getBoolean("isban");
		admin = resultat.getBoolean("isadmin");
		
		return (this);
	}
	
	public ArrayList<String> save(String e, String c, String p, String n, String news) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		validation(e, c, p, n);
		if (!errors.isEmpty())
			return (ArrayList<String>) errors;
		Class.forName( "com.mysql.jdbc.Driver" );
		connexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bdd_jweb", "java", "jweb" );
		if (news == null)
			preparedStatement = connexion.prepareStatement( "INSERT INTO bdd_jweb.User (email, password, name, date_inscription) VALUES(?, ?, ?, NOW());" );
		else
			preparedStatement = connexion.prepareStatement( "INSERT INTO bdd_jweb.User (email, password, name, date_inscription, newsletter) VALUES(?, ?, ?, NOW(), ?);" );
		preparedStatement.setString( 1, e );
		preparedStatement.setString( 2, convert_to_md5(p) );
		preparedStatement.setString( 3, n );
		if (news != null)
			preparedStatement.setBoolean( 4, true );
		preparedStatement.executeUpdate();
		return (ArrayList<String>) errors;
	}
	
	private void validation(String e, String c, String p, String n) {
		if (!p.equals(c)) {
			errors.add("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
		} else if (p.trim().length() < 3) {
			errors.add("Les mots de passe doivent contenir au moins 3 caractères.");
		}
		if ( n.trim().length() < 3 ) {
			errors.add( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
		}
		if ( !e.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) || e.trim().length() < 3) {
			errors.add( "Merci de saisir une adresse mail valide.");
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBan() {
		return ban;
	}

	public void setBan(boolean ban) {
		this.ban = ban;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}