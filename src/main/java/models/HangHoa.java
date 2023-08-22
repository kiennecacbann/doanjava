package models;

import java.io.Serializable;

public class HangHoa implements Serializable{
	private int mamon ;
	private MonAn monan;
	private Nuoc nuoc;
	private int soluong ;
	private double tongtien;
	private Dodungthem ddt;
	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	
	public HangHoa() {
    	super();
    }
    
	/**
	 * @param mamon
	 * @param monan
	 * @param soluong
	 */
	public HangHoa( MonAn monan, int soluong, Nuoc nuoc, Dodungthem ddt) {		
		this.monan = monan;
		this.soluong = soluong;
		this.nuoc = nuoc;
		this.ddt = ddt;
	}

	public Dodungthem getDdt() {
		return ddt;
	}

	public void setDdt(Dodungthem ddt) {
		this.ddt = ddt;
	}

	public Nuoc getNuoc() {
		return nuoc;
	}

	public void setNuoc(Nuoc nuoc) {
		this.nuoc = nuoc;
	}

	public int getMamon() {
		return mamon;
	}
	public void setMamon(int mamon) {
		this.mamon = mamon;
	}

	public MonAn getMonan() {
		return monan;
	}
	public void setMonan(MonAn monan) {
		this.monan = monan;
	}

	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
    
}
