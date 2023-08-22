package client;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Dao;
import models.User;


/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	Dao dao = new Dao();
    	HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
    	if(user == null) {
    		request.setAttribute("username", "Đăng nhập");
        	request.setAttribute("logout",null);
    	}
    		
    	else {
    		request.setAttribute("username", user.getHoten());
    		request.setAttribute("logout", session.getAttribute("logout"));
    	}
    	
    	
    	request.setAttribute("monans", dao.getMonAn());
    	request.setAttribute("nuocs", dao.getNuoc());
    	request.setAttribute("dodungs", dao.getDodung());
		RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/menu.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
