package QuanLyCuaHangJ74.QuanLyBanHang.KhachMuaHang;

import java.util.Scanner;

import QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa.HangHoa;
import QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa.QuanLyHangHoa;
import QuanLyCuaHangJ74.CapNhap.CapNhatKhachHang.KhachHang;
import QuanLyCuaHangJ74.CapNhap.CapNhatKhachHang.QuanLyKhachHang;
import QuanLyCuaHangJ74.QuanLyBanHang.thongke.QuanLyDanhSachGioHang;

public class QuanLyGioHang {
	

	static Scanner sc = new Scanner(System.in);

	public static void QuanLyGioHang() {
		
		
		// Khoi tao gio hang cho kahch

		Gio gio = new Gio();

		System.out.println("\n---------------------Chao mung ban den voi cua hang----------------------");
		do {
			System.out.println("Quan ly gio hang cua ban ");
			System.out.println("\t1. Xem gio hang ");
			System.out.println("\t2. Them hang vao gio ");
			System.out.println("\t3. Sua hang trong gio  ");
			System.out.println("\t4. Xoa hang trong  gio hang ");
			System.out.println("\t5. huy gio hang");
			System.out.println("\t0. quay lai");

			System.out.println("Nhap lua chon cua ban :");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				gio.disPlay();
				break;
			case 2:
				add(gio);
				break;
			case 3:
				update(gio);
				break;
			case 4:
				remove(gio);
				break;
			case 5:
				gio = new Gio();

			case 6:
				payment(gio);
				return;
			case 0:
				gio = null;
				return;

			}
		} while (true);

	}

	private static void add(Gio gio) {
		System.out.println("\n---------------------THEM HANG VAO GIO-------------------");
		System.out.println("Nhap vao dia chi id hnag hoa:");
		int idh = Integer.parseInt(sc.nextLine());
		// tim kiem hang hoa nay co trong danh sach  hnag hoa khong
		int index = QuanLyHangHoa.findById(idh);
		if(index == -1) {
		System.out.println("Hang hoa nay khong co trong danh sach ban ");
		return;
	}
		System.out.println("Nhap so luong hang can mua :");
		double amount = Double.parseDouble(sc.nextLine());
		if(amount <=0) {
			System.out.println("So luong hang mua phai lon hon 0");
			return;
		}
		// so luong mua k phai vuot qua 
		
		int indexGio= gio.findByIdh(idh);
		
		if(indexGio != -1) {
			amount += gio.getList().get(indexGio).getAmount();
		}
		// 
		
		if(amount > QuanLyHangHoa.getList().get(index).getAmount()) {
			System.out.println("So luong hang khong du ban , mong ban thong cam ");
			return;
		}
		if(indexGio != -1) {// hang da co trong gio
			gio.getList().get(indexGio).setAmount(amount);
			
		}else {
			gio.getList().add(new Hang(idh, amount));
		}
		System.out.println("Them san pham vao gio thanh cong !");
		}
	

	private static void update(Gio gio) {
	System.out.println("\n-------------------SUA SAN PHAM TRONG GIO---------------------");
	System.out.println("Nhap ma hang hoa can sua :");
	int idh = Integer.parseInt(sc.nextLine());
	// tim kiem hang co trong gio hang khong
	
	int index = gio.findByIdh(idh);
			if(index == -1) {
				System.out.println("Hnag hoa khong co trong gio");
			}
			// Kiem tra so luong phai la so luong duong 
			System.out.println("Nhap so luong moi:");
			double amount = Double.parseDouble(sc.nextLine());
			if(amount<=0) {
				System.out.println("so luong moi phai la so duong ");
				return;
						
			}
			gio.getList().get(index).setAmount(amount);
			System.out.println("Sua hang hoa trong gio hang thanh cong");
			

	}

	private static void remove(Gio gio) {
		System.out.println("\n-------------------XOA HANG TRONG GIO---------------------");
		System.out.println("Nhap ma hang hoa can xoa :");
		int idh = Integer.parseInt(sc.nextLine());
		// tim kiem hang co trong gio hang khong
		
		int index = gio.findByIdh(idh);
				if(index == -1) {
					System.out.println("Hang hoa khong co trong gio");
					return;
				}
				gio.getList().remove(index);
				System.out.println("Da xoa hang ra khoi gio hang");
	}

	private static void payment(Gio gio) {
	
				System.out.println("\n-----------THANH TOAN GIO HANG-------------");
				System.out.print("Nhap ma khach hang: ");
				int idkh = Integer.parseInt(sc.nextLine());
				
				int indexKhach = QuanLyKhachHang.findById(idkh);
				if (indexKhach == -1) {//Khach hang chua co trong danh sach, them moi
					String name = "";
					do {
						System.out.print("Nhap ten khach hang moi: ");
						name = sc.nextLine();
						if (name.trim().length() == 0) {
							System.out.println("Ten khach hang khong duoc de trong");
						}
					} while (name.trim().length() == 0);
					//Them khach hang vao danh sach khach hang
					idkh = QuanLyKhachHang.autoId++;
					QuanLyKhachHang.getList().add(new KhachHang(idkh, name));
				}
				
				//Thiet lap id, idkh cho gio hang
				gio.setId(QuanLyDanhSachGioHang.autoId++);
				gio.setIdkh(idkh);
				
				System.out.println("\n----------HOA DON BAN LE----------");
				gio.disPlay();
				//Luu gio hang vao danh sach gio hang
				QuanLyDanhSachGioHang.list.add(gio);
				//Tru di so luong hang trong danh sach hang ban
				for (Hang x : gio.getList()) {
					for (HangHoa y : QuanLyHangHoa.getList()) {
						if (y.getId() == x.getIdh()) {
							y.setAmount(y.getAmount() - x.getAmount());
						}
					}
				}
		
	}

}
