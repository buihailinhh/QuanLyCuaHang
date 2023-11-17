package QuanLyCuaHangJ74.CapNhap.CapNhatKhachHang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa.QuanLyHangHoa;
import QuanLyCuaHangJ74.CapNhap.CapNhatLoaiHang.LoaiHang;
import QuanLyCuaHangJ74.CapNhap.CapNhatLoaiHang.QuanLyLoaiHang;

public class QuanLyKhachHang {
	private static ArrayList<KhachHang> list = new ArrayList<>();

	public static ArrayList<KhachHang> getList() {
		return list;
	}

	public static void setList(ArrayList<KhachHang> list) {
		QuanLyKhachHang.list = list;
	}
	
	public static int autoId = 101;
	
	// Ham khoi tao trc 1 loai hang cho danh sach
	public static void init() {
		list.add(new KhachHang(autoId++, "My Pham"));
		list.add(new KhachHang(autoId++, "Gia Dung"));
		list.add(new KhachHang(autoId++, "Thuc Pham tuoi"));
		
		
	}
	static Scanner sc = new Scanner(System.in);
	
	public static void capNhatKhachHang() {
		do {
			System.out.println("\n=====================CAP NHAT THONG TIN KHACH  HANG====================");
			
			System.out.println("\t1. Xem danh sach khach hang ");
			System.out.println("\t2. Them khach Hang moi ");
			System.out.println("\t3. Sua thong tin khach hang ");
			System.out.println("\t4. Xoa thong tin khach Hang ");
			System.out.println("\t5. Sap Xep Danh sach khach Hang ");
			System.out.println("\t0. Quay Lai ");
			
			System.out.println("Nhap lua chon cua ban :");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch(chon) {
			case 1:display();break;
			case 2:add();break;
			case 3:update();break;
			case 4:remove();break;
			case 5:sort();break;
			case 0:break;
			default: System.out.println("Lua chon khong hop le");
			}
		
	}while(true);
	

}
	
	public static void display() {
		System.out.println("----------------DANH SACH Khach HANG------------------");
		System.out.printf("%-12s %25s%n", "Ma khach Hang", "Ten khach Hang");
		for(KhachHang x: list) {
			x.display();
		}
	}

	
	private static void add() {
		System.out.println("----------------------THEM MOI MOT Khach HANG--------------------");
		System.out.println("Nhap ten khach hang ");
		String name = sc.nextLine();
		
		//kiem tra ten khong rong
		
				if(name .trim().length()==0) {
					System.out.println("ten khach hang khong duoc de trong");
					return;
				}
				
				
		
	// them doi tuong vao danh sach
		
		list.add(new KhachHang(autoId++, name));
		System.out.println("Them moi khach hang thanh cong");
		
	}
		
	private static void update() {
		
		System.out.println("\n------------------SUA THONG TIN KHACH HANG---------------");
		System.out.println("Nhap id cua  khach hang hang can sua :");
		int id = Integer.parseInt(sc.nextLine());
		
		
		//kiem tra loai hang khong co trong danh sach
		int index = findById(id);
		
		if(index == -1) {
			System.out.println("khach hang nay khong co trong danh sach");
           return;
	}
		System.out.print("Nhap ten khach hang:");
		String name = sc.nextLine();
		
		// kiem tra ten hnag khong rong
		if(name.trim().length() ==0) {
			System.out.println("Ten khach hang khong duoc de trong ");
			return;
		}
		
		// them loai hang
		
		list.get(index).setName(name);
		System.out.println("Sua ten khach hang thanh cong");
	}
		

	private static void remove() {
		System.out.println("\n------------------Xoa THONG TIN KHACH HANG---------------");
		System.out.println("Nhap id cua  khach hang can xoa :");
		int id = Integer.parseInt(sc.nextLine());
		
		
		//kiem tra loai hang khong co trong danh sach
		int index = findById(id);
		
		if(index == -1) {
			System.out.println("khach hang nay khong co trong danh sach");
           return;
	}
		// kiem tra tinh rang buoc lien ket voi danh sach hang hoa 
		
		if(QuanLyHangHoa.findByIdLoaiHang(id) != -1) {
			System.out.println("khong the xoa khach hang da co trong danh sach hang hoa");
			return;
		}
		
		list.remove(index);
		System.out.println("Xoa ten khach hang thanh cong ");
	}

	private static void sort() {
Collections.sort(list, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		
	}
	
	
	// Cac ham chuc nang phuc vu 
	
	//+ Ham tim theo ten loai hang 
	public static int findByName(String name) {
		for(int index=0; index< list.size(); index++) {
			if(list.get(index).getName().trim().equalsIgnoreCase(name.trim())) {
				return index;
			}
		}
		return -1;
		
	}
	
	// tim theo id loai hang
	public static int findById(int id) {
		for(int index=0; index< list.size(); index++) {
			if(list.get(index).getId()== id) {
				return index;
			}
		}
		return -1;
		
	}
	// lay ten loai hang theo id
	public static String getNameById(int id) {
		for(KhachHang  x: list) {
			if(x.getId()==id) {
				return x.getName();
			}
		}
		return null;
	}
	
}
