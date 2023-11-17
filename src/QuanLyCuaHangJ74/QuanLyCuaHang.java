package QuanLyCuaHangJ74;

import java.util.Scanner;

import QuanLyCuaHangJ74.CapNhap.QuanLyCapNhat;
import QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa.QuanLyHangHoa;
import QuanLyCuaHangJ74.CapNhap.CapNhatKhachHang.QuanLyKhachHang;
import QuanLyCuaHangJ74.CapNhap.CapNhatLoaiHang.QuanLyLoaiHang;
import QuanLyCuaHangJ74.QuanLyBanHang.QuanLyBanHang;
import QuanLyCuaHangJ74.QuanLyTimKiem.QuanLyTimKiem;

public class QuanLyCuaHang {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		QuanLyLoaiHang.init();
		QuanLyHangHoa.init();
		QuanLyKhachHang.init();
		do {
			System.out.println("\n=====================CHUONG TRINH QUAN LY CUA HANG JAVA74====================");
			System.out.println("Cac chuc nang quan ly cua cua hang ");
			System.out.println("\t1. Cap nhat thong tin va he thong ");
			System.out.println("\t2. Quan Ly Ban Hang Cua He Thong ");
			System.out.println("\t3. Tim kiem thong tin  he thong ");
			System.out.println("\t0. Thoat ");
			System.out.println("Moi ban chon chuc nang: ");
			int chon = Integer.parseInt(sc.nextLine());
					
					switch(chon) {
					case 1: QuanLyCapNhat.quanLyCapNhat(); break;
					case 2: QuanLyBanHang.quanLyBanHang(); break;
					case 3:QuanLyTimKiem.quanLyTimKiem(); break;
					case 0: 
						System.out.println("Thoat ung dung");
						System.exit(0);
					
					default:
					System.out.println("Lua chon khong hop le");
					}
		}while(true);
		 
	

}
		}
