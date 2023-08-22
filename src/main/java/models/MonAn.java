package models;

public class MonAn {
	private int mamon;
	public String tenmon;
	private double giatien;
	private String tinhtrang;	
	private String img;
	private String mota;
	private Dodungthem ddt;
		
	public Dodungthem getDdt() {
		return ddt;
	}
	public void setDdt(Dodungthem ddt) {
		this.ddt = ddt;
	}
	public MonAn() {
		super();
	}
	public MonAn(int mamon, String tenmon, double giatien, String tinhtrang, String img, String mota) {
		this.mamon = mamon;
		this.tenmon = tenmon;
		this.giatien = giatien;
		this.tinhtrang = tinhtrang;
		this.img = img;
		this.mota = mota;
	}
	
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

	public String getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}
	
}
