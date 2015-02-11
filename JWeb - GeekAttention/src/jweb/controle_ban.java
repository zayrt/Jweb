package jweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controle_ban")
public class controle_ban extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controle_ban() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user= request.getParameter("acc");
		
		if (!user.equals(" ")) {
			model_ban update = new model_ban();
			
			update.ban_user(user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/interface_admin.jsp").forward(request, response);
		}
	}

}
