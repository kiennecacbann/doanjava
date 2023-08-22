package models;

public class Dodungthem {
	private int madd;
	private String tendd;
	private double gia;
	private String img;
	
	
	/**
	 * 
	 */
	public Dodungthem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMadd() {
		return madd;
	}
	public void setMadd(int madd) {
		this.madd = madd;
	}
	public String getTendd() {
		return tendd;
	}
	public void setTendd(String tendd) {
		this.tendd = tendd;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @param madd
	 * @param tendd
	 * @param gia
	 * @param img
	 */
	public Dodungthem(int madd, String tendd, double gia, String img) {
		this.madd = madd;
		this.tendd = tendd;
		this.gia = gia;
		this.img = img;
	}
	
}
