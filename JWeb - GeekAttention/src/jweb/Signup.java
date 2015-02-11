package jweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> messages = new ArrayList<String>();
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding( "UTF-8" );
					
		this.getServletContext().getRequestDispatcher( "/signup.jsp" ).forward( request, response );
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		User_model user = new User_model();
		messages.add(request.getParameter( "newsletter" ));
		try {
			messages = user.save(request.getParameter( "email" ), request.getParameter( "confirmation" ), request.getParameter( "password" ), 
					request.getParameter( "name" ), request.getParameter( "newsletter" ));
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			messages.add("Cette email est déjà  utilisé.");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if (messages.isEmpty())
			messages.add("Succès de l'inscription !");
		request.setAttribute( "messages", messages );
		this.getServletContext().getRequestDispatcher( "/signup.jsp" ).forward( request, response );
	}
	
}
