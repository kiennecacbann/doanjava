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

import models.HangHoa;

/**
 * Servlet implementation class Giohang
 */
@WebServlet("/Giohang")
public class Giohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Giohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		TongHoaDon(request, response) ;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("tongtien")!=null) {
			double tongtien = (double) session.getAttribute("tongtien");
			request.setAttribute("tongtien", tongtien);
		}
		else {
		request.setAttribute("tongtien", 0);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Views/Client/Giohang.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private double TongHoaDon(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		double tongtien = 0;
		int i;		
		List<HangHoa> cart = (List<HangHoa>) session.getAttribute("cart");
		List<HangHoa> cart1 = (List<HangHoa>) session.getAttribute("cart1");
		List<HangHoa> cart2 = (List<HangHoa>) session.getAttribute("cart2");
		if(cart != null) {
			for(i = 0 ; i < cart.size();i++) {
				tongtien += cart.get(i).getTongtien();
			}
		}
		
		if(cart1 != null) {
			for( i = 0 ; i < cart1.size();i++) {
				tongtien += cart1.get(i).getTongtien();
			}
		}
		
		if(cart2 != null) {
			for( i = 0 ; i < cart2.size();i++) {
				tongtien += cart2.get(i).getTongtien();
			}
		}
		session.setAttribute("tongtien", tongtien);
		return tongtien ;
	}
}
