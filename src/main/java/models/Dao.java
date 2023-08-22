package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.text.DateFormatter;

public class Dao {
	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	Statement stmt = null;
	public List<MonAn> getMonAn(){
		List<MonAn> LMA = new ArrayList<MonAn>();
		String querry = "select * from bunbo";
		try {
			con = new BunContext().getConnection();// Connect to mysql;
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery();
			while(rs.next()) {
				LMA.add(new MonAn(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)));
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return LMA;		
	}
		
	public MonAn getMonAnTheoId(int string) {
		MonAn monan = new MonAn();
		String querry = "select * from bunbo where mamon="+string;
		try {
			con = new BunContext().getConnection();// Connect to mysql;
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) == string) {
				monan = new MonAn(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6));
					return monan;
				}
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	public User getUser(String tk,String mk) {
		User user = new User();
		String querry = "select * from kh where TaikhoanKH = '" + tk + "' and MatkhauKH = '" + mk + "'";
		try {
			con = new BunContext().getConnection();// Connect to mysql;
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString(3).equals(tk) && rs.getString(4).equals(mk)) {
					user = new User(rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							rs.getString(8));
					return user;
				}				
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	public User getUser1(String tk,String dt,String email) {
		User user = new User();
		String querry = "select * from kh where TaikhoanKH = '" + tk + "' and DienthoaiKH = '" + dt + "'";
		String querry2 = "select * from kh where TaikhoanKH = '" + tk + "' and EmailKH = '" + email + "'";
		try {
			con = new BunContext().getConnection();// Connect to mysql;
			ps1 = con.prepareStatement(querry);
			rs1 = ps1.executeQuery();
			ps = con.prepareStatement(querry2);
			rs = ps.executeQuery();		
			
				while(rs.next()) {
					if(rs.getString(5).equals(email) && rs.getString(3).equals(tk) ) {
						user = new User(rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8));
						if(user != null)
						return user;
					}	
				  }	
				
			while(rs1.next()) {
				if(rs1.getString(7).equals(dt) && rs1.getString(3).equals(tk) ) {
					user = new User(rs1.getInt(1),
							rs1.getString(2),
							rs1.getString(3),
							rs1.getString(4),
							rs1.getString(5),
							rs1.getString(6),
							rs1.getString(7),
							rs1.getString(8));
					if(user != null)
					return user;
				}				
			}		
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	public void updateMKUser(String mk,String tk) {
		String querry = "UPDATE kh SET MatkhauKH = '" + mk + "' where TaikhoanKH = '" + tk + "'";
		try {
			con = new BunContext().getConnection();// Connect to mysql;		
			stmt = con.createStatement();
			stmt.executeUpdate(querry);			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public Dodungthem getDodungthemtheoId(int string) {
		Dodungthem dodung = new Dodungthem();
		String querry = "select * from dodungthem where madodungthem="+string;
		try {
			con = new BunContext().getConnection();// Connect to mysql;
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) == string) {
					dodung = new Dodungthem(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(5));
					return dodung;
				}
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	public List<Dodungthem> getDodung(){
		List<Dodungthem> LMA = new ArrayList<Dodungthem>();
		String querry = "select * from dodungthem";
		try {
			con = new BunContext().getConnection();// Connect to mysql;
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery();
			while(rs.next()) {
				LMA.add(new Dodungthem(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(5)));
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return LMA;		
	}
	
	public Nuoc getNuocTheoId(int string) {
		Nuoc nuoc = new Nuoc();
		String querry = "select * from nuoc where Manuoc="+string;
		try {
			con = new BunContext().getConnection();// Connect to mysql;
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) == string) {
					nuoc = new Nuoc(rs.getInt(1),
							rs.getString(2),
							rs.getDouble(3),						
							rs.getString(4));
					return nuoc;
				}
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	} 
	
	public List<Nuoc> getNuoc(){
		List<Nuoc> LMA = new ArrayList<Nuoc>();
		String querry = "select * from nuoc";
		try {
			con = new BunContext().getConnection();// Connect to mysql;
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery();
			while(rs.next()) {
				LMA.add(new Nuoc(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),						
						rs.getString(4)));
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return LMA;		
	}
	
	public void setUser(User user) {
		String querry = "INSERT INTO kh (HoTenKH,TaikhoanKH,MatkhauKH,EmailKH,DiachiKH,DienthoaiKH,NgaysinhKH) "
				//+ "VALUES (?,?,?,?,?,?,?)";
		+"VALUES ('"+ user.getHoten() + "','" + user.getTk() + "','" + user.getMk() + "','" + user.getEmail() + "','" + user.getDiachi() + "','" + user.getDt() + "',STR_TO_DATE('" + user.getNgaysinh() + "','%Y-%m-%d'));";
	try {
		con = new BunContext().getConnection();// Connect to mysql;		
		stmt = con.createStatement();
		stmt.executeUpdate(querry);		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		//JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage());   
	}
	}
	
	public int setHoaDon(int userid,double tonghoadon,String date) {
		LocalDate ngaydat = LocalDate.now();
		Random rand = new Random();
		int madh = rand.nextInt(50);
		String querry = "INSERT INTO dondathang (MaDonHang,Ngaydat,Ngaygiao,IDKH,Tongtien) "
		+"VALUES ("+ madh + ",STR_TO_DATE('" + ngaydat + "','%Y-%m-%d'),STR_TO_DATE('" + date + "','%Y-%m-%d')," + userid + "," + tonghoadon +");";
	try {
		if(con==null)
		con = new BunContext().getConnection();// Connect to mysql;		
		stmt = con.createStatement();
		stmt.executeUpdate(querry);		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		//JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage());   
	}
	return madh;
	}
	
	public void setChitietMonAn(int madh,List<HangHoa> cart) {
		for (HangHoa item : cart) {
			String querry = "INSERT INTO chitietdonthang (MaDonHang,Mamon,Soluong,Dongia) "
					+"VALUES ("+ madh + "," + item.getMonan().getMamon() + "," + item.getSoluong() + "," + item.getTongtien()/item.getSoluong() + ");";
				try {
					if(con==null)
					con = new BunContext().getConnection();// Connect to mysql;		
					stmt = con.createStatement();
					stmt.executeUpdate(querry);		
				}catch(Exception e) {
					System.out.println(e.getMessage()); 
				}
        };	
	}
	
	public void setChitietNuoc(int madh,List<HangHoa> cart) {
		for (HangHoa item : cart) {
			String querry = "INSERT INTO chitiethoadonnuoc (MaHoaDon,Manuoc,Soluong,Dongia) "
					+"VALUES ("+ madh + "," + item.getNuoc().getMamon() + "," + item.getSoluong() + "," + item.getTongtien()/item.getSoluong() + ");";
				try {
					if(con==null)
					con = new BunContext().getConnection();// Connect to mysql;		
					stmt = con.createStatement();
					stmt.executeUpdate(querry);		
					con.close();
				}catch(Exception e) {
					System.out.println(e.getMessage()); 
				}
        };
		}
	
	
	public void setChitietDodung(int madh,List<HangHoa> cart) {
		for (HangHoa item : cart) {
			String querry = "INSERT INTO chitiethoadonddt (MaHoaDon,Madodungthem,Soluong,Dongia) "
					+"VALUES ("+ madh + "," + item.getDdt().getMadd() + "," + item.getSoluong() + "," + item.getTongtien()/item.getSoluong() + ");";
				try {
					if(con==null)
					con = new BunContext().getConnection();// Connect to mysql;		
					stmt = con.createStatement();
					stmt.executeUpdate(querry);							
				}catch(Exception e) {
					System.out.println(e.getMessage()); 
				}
        };
	}
	
}
	
