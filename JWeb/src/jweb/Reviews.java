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

/**
 * Servlet implementation class Reviews
 */
@WebServlet("/Reviews")
public class Reviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private reflex_product product;
	private List<String> messages = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Reviews_model review_model = new Reviews_model();
		try {
			product = review_model.find((request.getParameter("prod")));
		} catch (ClassNotFoundException | NoSuchAlgorithmException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("product", product);
        this.getServletContext().getRequestDispatcher("/reviews.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Reviews_model review_model = new Reviews_model();
		HttpSession session = request.getSession();
		String user_name = (String) session.getAttribute( "name" );
		
		try {
			messages = review_model.save( request.getParameter("prod"), user_name, request.getParameter("review"));
		} catch (ClassNotFoundException | NoSuchAlgorithmException
				| SQLException e) {
			e.printStackTrace();
		}
		if (messages.isEmpty())
			messages.add("Votre avis a bien été pris en compte !");
		request.setAttribute( "messages", messages );
		doGet(request, response);
	}

}
