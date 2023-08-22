package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Dao;
import models.Dodungthem;
import models.HangHoa;
import models.MonAn;
import models.Nuoc;

/**
 * Servlet implementation class ThemGioHang
 */
@WebServlet("/ThemGioHang")
public class ThemGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_DisplayCart(request, response);
		} else {
			if (action.equalsIgnoreCase("buy")) {
				doGet_Buy(request, response);
			} else if (action.equalsIgnoreCase("buydodung")) {
				doGet_BuyDodung(request, response);
			}else if (action.equalsIgnoreCase("buynuoc")) {
				doGet_BuyNuoc(request, response);
			}else if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			}
		}
	}

	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/Views/Client/menu.jsp").forward(request, response);
	}

	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		if(request.getParameter("id") != null ) {
			List<HangHoa> cart = (List<HangHoa>) session.getAttribute("cart");
			int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);				
			cart.remove(index);		
			session.setAttribute("cart", cart);	
		}
		
		if(request.getParameter("idnuoc") != null ) {
			List<HangHoa> cart2 = (List<HangHoa>) session.getAttribute("cart2");
			int index = isExisting2(Integer.parseInt(request.getParameter("idnuoc")), cart2);				
			cart2.remove(index);		
			session.setAttribute("cart2", cart2);	
		}
		
		if(request.getParameter("iddodung") != null ) {
			List<HangHoa> cart1 = (List<HangHoa>) session.getAttribute("cart1");
			int index = isExisting1(Integer.parseInt(request.getParameter("iddodung")), cart1);				
			cart1.remove(index);		
			session.setAttribute("cart1", cart1);	
		}
		
		response.sendRedirect("Giohang");
		
	}

	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao productModel = new Dao();
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			List<HangHoa> cart = new ArrayList<HangHoa>();
			cart.add(new HangHoa(productModel.getMonAnTheoId(Integer.parseInt(request.getParameter("id"))),
					1, 
					null,
					null));	
			
			MonAn temp = productModel.getMonAnTheoId(Integer.parseInt(request.getParameter("id")));			
			cart.get(0).setTongtien(temp.getGiatien());
			session.setAttribute("cart", cart);
		} else {
			List<HangHoa> cart = (List<HangHoa>) session.getAttribute("cart");
			int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
			if (index == -1) {
				cart.add(new HangHoa(productModel.getMonAnTheoId(Integer.parseInt(request.getParameter("id"))),
						1, 
						null,
						null));
				
				MonAn temp = productModel.getMonAnTheoId(Integer.parseInt(request.getParameter("id")));				
				cart.get(cart.size()-1).setTongtien(temp.getGiatien());
			} else {
				
				int quantity = cart.get(index).getSoluong() + 1;
				cart.get(index).setSoluong(quantity);
				cart.get(index).setTongtien(cart.get(index).getSoluong() * cart.get(index).getMonan().getGiatien());
			}
			session.setAttribute("cart", cart);
		}
		response.sendRedirect("Menu");
	}
	
	protected void doGet_BuyDodung(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao productModel = new Dao();
		HttpSession session = request.getSession();
		if (session.getAttribute("cart1") == null) {
			List<HangHoa> cart1 = new ArrayList<HangHoa>();
			cart1.add(new HangHoa(null,
					1, 
					null,
					productModel.getDodungthemtheoId(Integer.parseInt(request.getParameter("iddodung")))));	
			
			Dodungthem temp = productModel.getDodungthemtheoId(Integer.parseInt(request.getParameter("iddodung")));	
			
			cart1.get(0).setTongtien(temp.getGia());
			session.setAttribute("cart1", cart1);
		} else {
			List<HangHoa> cart1 = (List<HangHoa>) session.getAttribute("cart1");
			int index = isExisting1(Integer.parseInt(request.getParameter("iddodung")), cart1);
			if (index == -1) {
				cart1.add(new HangHoa(null,
						1, 
						null,
						productModel.getDodungthemtheoId(Integer.parseInt(request.getParameter("iddodung")))));
				
				Dodungthem temp = productModel.getDodungthemtheoId(Integer.parseInt(request.getParameter("iddodung")));				
				cart1.get(cart1.size()-1).setTongtien(temp.getGia());
			} else {
				
				int quantity = cart1.get(index).getSoluong() + 1;
				cart1.get(index).setSoluong(quantity);
				cart1.get(index).setTongtien(cart1.get(index).getSoluong() * cart1.get(index).getDdt().getGia());
			}
			session.setAttribute("cart1", cart1);
		}
		response.sendRedirect("Menu");
	}
	
	protected void doGet_BuyNuoc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao productModel = new Dao();
		HttpSession session = request.getSession();
		if (session.getAttribute("cart2") == null) {
			List<HangHoa> cart2 = new ArrayList<HangHoa>();
			cart2.add(new HangHoa(null,
					1, 
					productModel.getNuocTheoId(Integer.parseInt(request.getParameter("idnuoc"))),
					null));	
			
			Nuoc temp = productModel.getNuocTheoId(Integer.parseInt(request.getParameter("idnuoc")));			
			cart2.get(0).setTongtien(temp.getGiatien());
			session.setAttribute("cart2", cart2);
		} else {
			List<HangHoa> cart2 = (List<HangHoa>) session.getAttribute("cart2");
			int index = isExisting2(Integer.parseInt(request.getParameter("idnuoc")), cart2);
			if (index == -1) {
				cart2.add(new HangHoa(null,
						1, 
						productModel.getNuocTheoId(Integer.parseInt(request.getParameter("idnuoc"))),
						null));
				
				Nuoc temp = productModel.getNuocTheoId(Integer.parseInt(request.getParameter("idnuoc")));				
				cart2.get(cart2.size()-1).setTongtien(temp.getGiatien());
			} else {
				
				int quantity = cart2.get(index).getSoluong() + 1;
				cart2.get(index).setSoluong(quantity);
				cart2.get(index).setTongtien(cart2.get(index).getSoluong() * cart2.get(index).getNuoc().getGiatien());
			}
			session.setAttribute("cart2", cart2);
		}
		response.sendRedirect("Menu");
	}
	
	private int isExisting(int id, List<HangHoa> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getMonan().getMamon() == id) {
				return i;
			}
		}
		return -1;
	}
	private int isExisting2(int id, List<HangHoa> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getNuoc().getMamon() == id) {
				return i;
			}
		}
		return -1;
	}
	private int isExisting1(int id, List<HangHoa> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getDdt().getMadd() == id) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

