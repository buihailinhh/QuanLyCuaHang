package QuanLyCuaHangJ74.QuanLyBanHang.KhachMuaHang;

import QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa.HangHoa;
import QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa.QuanLyHangHoa;

public class Hang {
	private int idh;
	private double amount;
	public Hang() {
		super();
	}
	public Hang(int idh, double amount) {
		super();
		this.idh = idh;
		this.amount = amount;
	}
	public int getIdh() {
		return idh;
	}
	public void setIdh(int idh) {
		this.idh = idh;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void display() {
		HangHoa x = QuanLyHangHoa.getHangHoaById(this.idh);
		
		System.out.printf("%-25s %10.1f %,14.2f %,15.2f%n", x.getName(), this.amount, x.getPrice(),
				this.amount* x.getPrice());
		
	}
	public double thanhTien() {
		HangHoa x = QuanLyHangHoa.getHangHoaById(this.idh);
		return this.amount* x.getPrice();
		
	}

}
