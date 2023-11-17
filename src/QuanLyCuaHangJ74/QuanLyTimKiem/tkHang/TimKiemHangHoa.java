package QuanLyCuaHangJ74.QuanLyTimKiem.tkHang;

import java.util.Scanner;

import QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa.QuanLyHangHoa;

public class TimKiemHangHoa {
	static Scanner sc = new Scanner(System.in);
	public static void timKiemHangHoa() {
		System.out.println("\n------------------------TIM KIEM THONG TIN HANG HOA----------------------");
		System.out.println("Tieu chi tim kiem");
		System.out.println("\t1. tim kiem theo ma hang hoa ");
		System.out.println("\t2. tim kiem theo ten hang hoa ");
	
		
		System.out.println("Lua chon cua ban ");
		int chon = Integer.parseInt(sc.nextLine());
		switch(chon) {
		case 1: timTheoIdHangHoa(); break;
		case 2: timTheoTenHangHoa(); break;
		case 0: return;
		
		default: System.out.println("Lua chon k hop le");
		}
		
	}
	private static void timTheoIdHangHoa() {
		System.out.println("Nhap ma hang can tim :");
          int id = Integer.parseInt(sc.nextLine());
          int index = QuanLyHangHoa.findById(id);
          if(index== -1) {
        	  System.out.println("Hang hoa khong co trong danh sach ");
        	  return;
          }
          System.out.println("Thong tin hang hoa tim duoc:");
          QuanLyHangHoa.getList().get(index).display();
	}
	private static void timTheoTenHangHoa() {
	
		System.out.println("Nhap ten hang can tim :");
        String name = sc.nextLine();
        int index = QuanLyHangHoa.findByName(name);
        
        if(index== -1) {
      	  System.out.println("Hang hoa khong co trong danh sach ");
      	  return;
        }
        System.out.println("Thong tin hang hoa tim duoc:");
        QuanLyHangHoa.getList().get(index).display();
	}

}
