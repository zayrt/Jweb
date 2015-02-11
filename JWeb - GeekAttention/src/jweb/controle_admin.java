package jweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controle_admin")
public class controle_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controle_admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isAdmin = (boolean) session.getAttribute("admin");
		
		if (isAdmin == true)
			this.getServletContext().getRequestDispatcher("/WEB-INF/interface_admin.jsp").forward(request, response);
		else
			this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
