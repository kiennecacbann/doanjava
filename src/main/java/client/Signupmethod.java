package client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import md5.hash;
import models.Dao;
import models.User;

/**
 * Servlet implementation class Signupmethod
 */
@WebServlet("/Signupmethod")
public class Signupmethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signupmethod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		Dao dao = new Dao();
		try {
			user.setTk(hash.md5hashing(request.getParameter("ID"))) ;
			if(request.getParameter("Password").equals(request.getParameter("Confirm password"))) {
				user.setMk(hash.md5hashing(request.getParameter("Password")));
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/signup.jsp");
				request.setAttribute("Error", "Mật khẩu xác nhận không khớp!");
				rd.forward(request, response);				
			}
			user.setHoten(request.getParameter("HotenKH"));
			user.setEmail(request.getParameter("email"));
			user.setDt(request.getParameter("Phone Number"));
			user.setDiachi(request.getParameter("Address"));
			user.setNgaysinh(request.getParameter("DateofBirth"));
			dao.setUser(user);
		}catch(Exception e) {
			System.out.print(e.getMessage());
			request.setAttribute("Error", "Có lỗi trong quá trình xác nhận thông tin");
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
