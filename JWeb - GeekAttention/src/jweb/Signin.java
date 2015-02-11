package jweb;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> messages = new ArrayList<String>();
	
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/signin.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User_model u = null;
		try {
			u = new User_model();
			u = u.find(request.getParameter( "email" ), request.getParameter( "password"));
		} catch (ClassNotFoundException | NoSuchAlgorithmException
				| SQLException e) {
			e.printStackTrace();
		}
		messages.clear();
		if (u != null) {
			if (u.isBan())
				messages.add("Vous avez été banni !");
			else {
				messages.add("Vous avez été connecté avec succès !");
				HttpSession session = request.getSession();
			
				session.setAttribute( "email", u.getEmail() );
				session.setAttribute( "id", u.getId() );
				session.setAttribute( "name", u.getName() );
				session.setAttribute( "admin", u.isAdmin() );
			}
		}
		else
			messages.add("Email ou mot de passe incorrect !");
		request.setAttribute( "messages", messages );
		this.getServletContext().getRequestDispatcher( "/signin.jsp" ).forward( request, response );
	}

}
