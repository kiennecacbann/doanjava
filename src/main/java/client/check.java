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

/**
 * Servlet implementation class check
 */
@WebServlet("/check")
public class check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				HttpSession session = request.getSession();
				User user = new User();
				hash md5hashing = new hash();
				Dao dao = new Dao();
				String tk = md5hashing.md5hashing(request.getParameter("tk"));
				user = dao.getUser1(tk, request.getParameter("check"),request.getParameter("check"));
				if(user != null) {
					session.setAttribute("tentk", user.getTk());
					RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/doimk.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("message", "Thong tin khong hop le!");
					RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/quenmk.jsp");
					rd.forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
