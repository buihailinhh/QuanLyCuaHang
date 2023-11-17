package QuanLyCuaHangJ74.QuanLyBanHang.KhachMuaHang;

import java.util.ArrayList;

import QuanLyCuaHangJ74.CapNhap.CapNhatKhachHang.QuanLyKhachHang;

public class Gio {
	private int id;
	private int idkh;
	private ArrayList<Hang> list = new ArrayList<>();
	public Gio() {
		super();
	}
	public Gio(int id, int idkh, ArrayList<Hang> list) {
		super();
		this.id = id;
		this.idkh = idkh;
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdkh() {
		return idkh;
	}
	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}
	public ArrayList<Hang> getList() {
		return list;
	}
	public void setList(ArrayList<Hang> list) {
		this.list = list;
	}
	
	// titm hang hoa trong gio theo idh
	
	int findByIdh(int idh) {
		for(int i=0; i<this.list.size(); i++) {
			if(this.list.get(i).getIdh()== idh) {			
				return i;
			}
		}
		return -1;
	}
	public void disPlay() {
		System.out.println("\tMa gio hang: "+ this.id);
		System.out.println("\tTen khach hang: "+ QuanLyKhachHang.getNameById(this.idkh));
		System.out.println("Danh sach hang hoa");
		System.out.printf("%-25s %-10s %-14s %-15s%n", "Ten Hang Hoa","So luong ", "Don Gia", "Thanh tien" );
		double total =0;
		for(Hang x: list) {
			x.display();
			total+= x.thanhTien();
		}
		System.out.printf("\tCong thanh tien: %,.2f%n", total);
		
	}
	

}
