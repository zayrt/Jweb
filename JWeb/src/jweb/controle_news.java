package jweb;

import java.io.IOException;
//import java.util.Date;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controle_news")
public class controle_news extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<reflex_news> list;

    public controle_news() throws SQLException {
        super();       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model_news model = new model_news();
	        
	    try {
			list = model.display_news();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	        
	    request.setAttribute("TheNews", list);
	    this.getServletContext().getRequestDispatcher("/news.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("news");
		HttpSession session = request.getSession(); 
		
		if (!message.equals(" ")) {
			model_news insert = new model_news();
			
			Date wrongdate = new Date();
			SimpleDateFormat format = new SimpleDateFormat ("yyyy.MM.dd" );  
			String date1 = format.format(wrongdate);
			String date = date1.toString();
			
			try {
				list = insert.add_news((String) session.getAttribute("name"), message, date);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			request.setAttribute("TheNews", list);
	        this.getServletContext().getRequestDispatcher("/news.jsp").forward(request, response);
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/interface_admin.jsp").forward(request, response);
		}
	}


}
