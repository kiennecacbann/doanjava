package client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;


@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Homepage() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/index.jsp");
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
    	if(user == null) {
    		request.setAttribute("username", "Đăng nhập");  
    		request.setAttribute("logout",null);
    	}
    		
    	else {
    		request.setAttribute("logout", session.getAttribute("logout"));
    		request.setAttribute("username", user.getHoten());
    	}
    		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
