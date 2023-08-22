package models;

import java.sql.Date;

public class User {
	private int makh;	
	private String hoten;
	private String tk;
	private String mk;
	private String email;
	private String diachi;
	private String dt;
	private String ngaysinh;
	
	public User() {
		super();
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	/**
	 * @param hoten
	 * @param tk
	 * @param mk
	 * @param email
	 * @param diachi
	 * @param dt
	 * @param ngaysinh
	 */
	public User(int makh,String hoten, String tk, String mk, String email, String diachi, String dt, String ngaysinh) {
		this.makh = makh;
		this.hoten = hoten;
		this.tk = tk;
		this.mk = mk;
		this.email = email;
		this.diachi = diachi;
		this.dt = dt;
		this.ngaysinh = ngaysinh;
	}
	public User(User user) {
		this.makh = user.makh;
		this.hoten = user.hoten;
		this.tk = user.tk;
		this.mk = user.mk;
		this.email = user.email;
		this.diachi = user.diachi;
		this.dt = user.dt;
		this.ngaysinh = user.ngaysinh;
	}
	
}
