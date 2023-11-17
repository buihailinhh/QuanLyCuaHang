package QuanLyCuaHangJ74.CapNhap;

import java.util.Scanner;

import QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa.QuanLyHangHoa;
import QuanLyCuaHangJ74.CapNhap.CapNhatKhachHang.QuanLyKhachHang;
import QuanLyCuaHangJ74.CapNhap.CapNhatLoaiHang.QuanLyLoaiHang;

public class QuanLyCapNhat {
	
	static Scanner sc = new Scanner(System.in);
	public static void quanLyCapNhat() {
		
		do {
		
		  System.out.println("\n CAP NHAT THONG TIN HE THONG");
		  System.out.println("Chon thong tin cap nhat :");
		  System.out.println("\t1. Cap nhat thong tin chung loai ");
		  System.out.println("\t2. Cap nhat thong tin hang hoa ");
		  System.out.println("\t3. Cap nhat thong tin khach hang ");
		  System.out.println("\t0. Quay Lai ");
		  
		  System.out.println(" Lua chon cua ban:");
		  int chon = Integer.parseInt(sc.nextLine());
		  
		  switch(chon) {
		  case 1:QuanLyLoaiHang.capNhatLoaiHang(); break;
		  case 2: QuanLyHangHoa.capNhatHangHoa();break;
		  case 3:QuanLyKhachHang.capNhatKhachHang(); break;
		  case 0: return;
		  
		  default:
			  System.out.println("Lua chon khong hop le !!");
		  }
		
	}while(true);

}
}
