package client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BunContext;
import models.Dao;
import models.User;
import models.HangHoa;

/**
 * Servlet implementation class ThanhToan
 */
@WebServlet("/ThanhToan")
public class ThanhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Dao dao = new Dao();
		double tongtien = (double) session.getAttribute("tongtien");
		User user = (User) session.getAttribute("user");
		if(user == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/login.jsp");
			rd.forward(request, response);
		}
		String date = request.getParameter("NgayGiao");
		int mahd = dao.setHoaDon(user.getMakh(), tongtien, date);
		List<HangHoa> cart = (List<HangHoa>) session.getAttribute("cart");
		List<HangHoa> cart1 = (List<HangHoa>) session.getAttribute("cart1");
		List<HangHoa> cart2 = (List<HangHoa>) session.getAttribute("cart2");
		if(cart != null) {
			dao.setChitietMonAn(mahd, cart);
		}
		if(cart1 != null) {
			dao.setChitietDodung(mahd, cart1);
		}
		if(cart2 != null) {
			dao.setChitietNuoc(mahd, cart2);
		}			
		session.setAttribute("cart", null);
		session.setAttribute("cart1", null);
		session.setAttribute("cart2", null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
