package client;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import md5.hash;
import models.Dao;
import models.User;


@WebServlet("/Loginmethod")
public class Loginmethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Loginmethod() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tk = hash.md5hashing(request.getParameter("tk"));
		String mk = hash.md5hashing(request.getParameter("mk"));
		User user = new User();
		Dao dao = new Dao();
		user = dao.getUser(tk, mk);
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("logout", "Đăng xuất");
			request.setAttribute("username", user.getHoten());
			RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/index.jsp");
			rd.forward(request, response);
		}		
		else {
			request.setAttribute("message", "Sai tk hoac mk");
			RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/login.jsp");
			rd.forward(request, response);
		}
	}

}
