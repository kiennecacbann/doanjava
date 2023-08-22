package models;

public class Nuoc {
	private int mamon;
	public String tenmon;
	private double giatien;
	private String img;
	public int getMamon() {
		return mamon;
	}
	public void setMamon(int mamon) {
		this.mamon = mamon;
	}
	public String getTenmon() {
		return tenmon;
	}
	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}
	public double getGiatien() {
		return giatien;
	}
	public void setGiatien(double giatien) {
		this.giatien = giatien;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @param mamon
	 * @param tenmon
	 * @param giatien
	 * @param img
	 */
	public Nuoc(int mamon, String tenmon, double giatien, String img) {
		this.mamon = mamon;
		this.tenmon = tenmon;
		this.giatien = giatien;
		this.img = img;
	}
	/**
	 * 
	 */
	public Nuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
