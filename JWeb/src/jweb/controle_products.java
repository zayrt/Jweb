package jweb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controle_products")
public class controle_products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<reflex_product> list;
	
    public controle_products() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		model_products model = new model_products();
		String cat = request.getParameter("cat");
		
        try {
			list = model.display_products(cat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        request.setAttribute("products", list);
        this.getServletContext().getRequestDispatcher("/products.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
