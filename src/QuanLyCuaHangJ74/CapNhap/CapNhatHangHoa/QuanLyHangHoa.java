package QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import QuanLyCuaHangJ74.CapNhap.CapNhatLoaiHang.LoaiHang;
import QuanLyCuaHangJ74.CapNhap.CapNhatLoaiHang.QuanLyLoaiHang;

public class QuanLyHangHoa {

	private  static ArrayList<HangHoa> list = new ArrayList<>();

	public static ArrayList<HangHoa> getList() {
		return list;
	}

	public static void setList(ArrayList<HangHoa> list) {
		QuanLyHangHoa.list = list;
	}
	public static int autoId = 1001;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void init() {
		list.add(new HangHoa(autoId++, 101, "Dau goi Romando 500g", 3, 170));
		list.add(new HangHoa(autoId++, 101, "Sua tam Romando 500g", 3, 155));
		list.add(new HangHoa(autoId++, 102, "NOi chien khong dau", 3, 3700000));
		list.add(new HangHoa(autoId++, 103, "Thit heo say", 45, 70000));
		list.add(new HangHoa(autoId++, 102, "Chao chong dinh ", 35, 270000));
		
	}
	public static void capNhatHangHoa() {
		do {
			System.out.println("\n=====================Cap Nhat Thong tin Hang Hoa====================");
			
			System.out.println("\t1. Xem danh sach hang hoa  ");
			System.out.println("\t2. Them Danh sach hang hoa ");
			System.out.println("\t3. Sua Danh sach hang hoa ");
			System.out.println("\t4. Xoa Danh Sach hang hoa ");
			System.out.println("\t5. Sap Xep Danh sach hang hoa ");
			System.out.println("\t0. Quay lại");
			
			System.out.println("Nhap lua chon cua ban :");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:display();break;
			case 2:add();break;
			case 3:update();break;
			case 4:remove();break;
			case 5:sort();break;
			case 0:return;
			default: System.out.println("Lua chon khong hop le");
			}
		
	}while(true);
	
		
	
}

	
	private static void display() {
		System.out.println("------------------------DANH SACH HANG HOA------------------");
		System.out.printf("%-10s %-20s %-25s %-12s %-15s%n", "Ma Hang", "Ten Loai Hang", 
				"Ten Hang Hoa", "So Luong", "Don gia ban");
		for(HangHoa x: list) {
			x.display();
		}
		
	}

	private static void add() {
System.out.println("\n------------THEM HANG HOA MOI VAO DS----------------");
		
		System.out.print("Nhap (chon) id loai hang: ");
		int idlh = Integer.parseInt(sc.nextLine());
		if (QuanLyLoaiHang.findById(idlh) == -1) {
			System.out.println("Loai hang vua chon khong co trong ds loai hang");
			return;
		}
		
		System.out.print("Nhap ten hang hoa: ");
		String name = sc.nextLine();
		//Kiem tra ten khong rong
		if (name.trim().length() == 0) {
			System.out.println("Ten hang hoa khong duoc de trong");
			return;
		}
		if (findByName(name) != -1) {
			System.out.println("Loai hang nay da co trong danh sach");
			return;
		}
		
		System.out.print("Nhap so luong hang hoa: ");
		double amount = Double.parseDouble(sc.nextLine());
		
		if (amount < 0) {
			System.out.println("So luong khong duoc la so am");
			return;
		}
		
		System.out.print("Nhap don gia ban hang hoa: ");
		double price = Double.parseDouble(sc.nextLine());
		
		if (price < 0) {
			System.out.println("Don gia ban khong duoc la so am");
			return;
		}
		//Them hang hoa moi vao danh sach
		list.add(new HangHoa(autoId++, idlh, name, amount, price));
		System.out.println("Them hang hoa moi thanh cong!");
	}
	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\n----------SUA THONG TIN HANG HOA----------");
		System.out.print("Nhap id cua hang hoa can sua: ");
		int id = Integer.parseInt(sc.nextLine());
		//Tim xem hang co trong danh sach khong
		int index = findById(id);
		if (index == -1) {
			System.out.println("Hang hoa khong co trong danh sach");
			return;
		}
		
		do {
			System.out.println("Sua thong tin hang hoa " + id);
			System.out.println("Chon thong tin can sua");
			System.out.println("\t1. Sua ma loai hang (idlh)");
			System.out.println("\t2. Sua ten hang hoa");
			System.out.println("\t3. Sua so luong hang hoa");
			System.out.println("\t4. Sua don gia ban hang hoa");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: list.get(index).updateIdlh(); break;
			case 2: list.get(index).updateName(); break;
			case 3: list.get(index).updateAmount(); break;
			case 4: list.get(index).updatePrice(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}
	

		
	

	private static void remove() {
		// TODO Auto-generated method stub
		System.out.println("\n------------------Xoa THONG TIN Hang Hoa---------------");
		System.out.println("Nhap id cua hang hoa can xoa :");
		int id = Integer.parseInt(sc.nextLine());
		
		
		//kiem tra hang hoa khong co trong danh sach
		int index = findById(id);
		
		if(index == -1) {
			System.out.println("Hang hoa nay khong co trong danh sach");
           return;
	}
		// kiem tra rang buoc lien ket voi hang hoa da ban
		list.remove(index);
		System.out.println("Xoa ten Hang hoa thanh cong ");
	}

	private static void sort() {
		Collections.sort(list, new Comparator<HangHoa>() {
			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		
		// TODO Auto-generated method stub
		
	}
	//+ Ham tim theo ten  hang hoa 
		public static int findByName(String name) {
			for(int index=0; index< list.size(); index++) {
				if(list.get(index).getName().trim().equalsIgnoreCase(name.trim())) {
					return index;
				}
			}
			return -1;
			
		}
		
		// tim theo id  hang hoa
		public static int findById(int id) {
			for(int index=0; index< list.size(); index++) {
				if(list.get(index).getId()== id) {
					return index;
				}
			}
			return -1;
			
		}
		// lay ten loai hang theo id
		public static int findByIdLoaiHang(int idlh) {
			for (int index = 0; index < list.size(); index++) {
				if (list.get(index).getIdlh() == idlh) {
					return index;
				}
			}
			return -1;
		}
		public static HangHoa getHangHoaById(int id) {
			for(HangHoa x: list) {
				if(x.getId()== id) {
					return x;
				}
			}
			return null;
			
		}
	
	
}
