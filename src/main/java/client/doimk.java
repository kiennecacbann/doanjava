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

/**
 * Servlet implementation class doimk
 */
@WebServlet("/doimk")
public class doimk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doimk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("mkmoi").equals(request.getParameter("checkmk"))) {
			HttpSession session = request.getSession();
			Dao dao = new Dao();
			hash hashing = new hash();
			String tk = (String) session.getAttribute("tentk");
			dao.updateMKUser(hashing.md5hashing(request.getParameter("mkmoi")),tk);
			RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/login.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message", "Mat khau khong khop");
			RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/doimk.jsp");
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
