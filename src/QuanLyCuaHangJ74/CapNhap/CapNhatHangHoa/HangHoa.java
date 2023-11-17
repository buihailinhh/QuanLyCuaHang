package QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa;

import java.util.Scanner;

import QuanLyCuaHangJ74.CapNhap.CapNhatLoaiHang.QuanLyLoaiHang;

public class HangHoa {

	private int id;
	private int idlh;
	private String name;
	private double amount;// so luong
	private double price;// don gia
	
	public void display() {
		System.out.printf("%10d %-20s %-25s %,12.2f %,15.2f%n", this.id,
				QuanLyLoaiHang.getNameById(this.idlh), this.name,this.amount, this.price);
		
	}

	public HangHoa() {
		super();
	}

	public HangHoa(int id, int idlh, String name, double amount, double price) {
		super();
		this.id = id;
		this.idlh = idlh;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdlh() {
		return idlh;
	}

	public void setIdlh(int idlh) {
		this.idlh = idlh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	Scanner sc = new Scanner(System.in);
	public void updateIdlh() {
		System.out.print("Nhap (chon) id loai hang: ");
		int idlh = Integer.parseInt(sc.nextLine());
		if (QuanLyLoaiHang.findById(idlh) == -1) {
			System.out.println("Loai hang vua chon khong co trong ds loai hang");
			return;
	}
		this.setId(idlh);
		System.out.println("Sua ma loai hang cong!");
	
}
	public void updateName() {
		System.out.print("Nhap ten hang hoa: ");
		String name = sc.nextLine();
		//Kiem tra ten khong rong
		if (name.trim().length() == 0) {
			System.out.println("Ten hang hoa khong duoc de trong");
			return;
		}
		if (QuanLyHangHoa.findByName(name) != -1) {
			System.out.println("Loai hang nay da co trong danh sach");
			return;
		}
		this.setName(name);
		
		System.out.println("Sua ten hang hoa thanh cong");
	}
	
	public void updateAmount() {
		System.out.print("Nhap so luong hang hoa: ");
		double amount = Double.parseDouble(sc.nextLine());
		
		if (amount < 0) {
			System.out.println("So luong khong duoc la so am");
			return;
		}
		this.setAmount(amount);
		System.out.println("Sua so luong ban hang hoa thanh cong");
		
	}
	public void updatePrice() {
		System.out.print("Nhap don gia ban hang hoa: ");
		double price = Double.parseDouble(sc.nextLine());
		
		if (price < 0) {
			System.out.println("Don gia ban khong duoc la so am");
			return;
		}
		this.setPrice(price);
		System.out.println("Sua don gia ban hang hoa thanh cong!");
		
	}
}
