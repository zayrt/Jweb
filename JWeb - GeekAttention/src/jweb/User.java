package jweb;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {
	private Connection connexion = null;
	private Statement statement = null;
	private ResultSet resultat = null;
	private List<String> errors = new ArrayList<String>();
	private int id;
	private String email;
	private String name;
	private boolean ban;
	private boolean admin;

	public User() {
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
	
	public User find(String e, String p) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Class.forName( "com.mysql.jdbc.Driver" );
		
		connexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bdd_jweb", "root", "azerty" );
		statement = connexion.createStatement();
		resultat = statement.executeQuery( "SELECT id, email, name, isban, isadmin  FROM bdd_jweb.User WHERE email = " + '"' + e + '"' + " && password = " +
		'"' + convert_to_md5(p) + '"');
		if (!resultat.next())
			return null;
		id = resultat.getInt("id");
		email = resultat.getString("email");
		name = resultat.getString("name");
		ban = resultat.getBoolean("isban");
		admin = resultat.getBoolean("isadmin");
		
		return (this);
	}
	
	public ArrayList<String> save(String e, String c, String p, String n) throws SQLException, ClassNotFoundException {
		validation(e, c, p, n);
		if (!errors.isEmpty())
			return (ArrayList<String>) errors;
		Class.forName( "com.mysql.jdbc.Driver" );
		connexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bdd_jweb", "root", "azerty" );
		statement = connexion.createStatement();
			
		statement.executeUpdate( "INSERT into bdd_jweb.User(email, password, name, date_inscription) "
				+ "VALUES ('" + e + "', MD5('" + p + "'), '" + n + "', NOW())");
		
		return (ArrayList<String>) errors;
	}
	
	private void validation(String e, String c, String p, String n) {
		if (!p.equals(c)) {
			errors.add("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
		} else if (p.trim().length() < 3) {
			errors.add("Les mots de passe doivent contenir au moins 3 caractères.");
		}
		if ( n != null && n.trim().length() < 3 ) {
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