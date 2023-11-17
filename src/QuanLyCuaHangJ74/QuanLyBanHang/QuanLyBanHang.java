package QuanLyCuaHangJ74.QuanLyBanHang;

import java.util.Scanner;

import QuanLyCuaHangJ74.CapNhap.CapNhatHangHoa.QuanLyHangHoa;
import QuanLyCuaHangJ74.CapNhap.CapNhatKhachHang.QuanLyKhachHang;
import QuanLyCuaHangJ74.CapNhap.CapNhatLoaiHang.QuanLyLoaiHang;
import QuanLyCuaHangJ74.QuanLyBanHang.KhachMuaHang.QuanLyGioHang;
import QuanLyCuaHangJ74.QuanLyBanHang.thongke.QuanLyDanhSachGioHang;

public class QuanLyBanHang {
	static Scanner sc = new Scanner(System.in);

	public static void quanLyBanHang() {

		do {

			System.out.println("\n QUAN LY BAN HANG");
			System.out.println("Chon chuc nag quan ly :");
			System.out.println("\t1. Danh cho khach hang ");
			System.out.println("\t2. Danh cho nguoi quan ly ");
			System.out.println("\t0. Quay Lai ");

			System.out.println(" Lua chon cua ban:");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				 QuanLyGioHang.QuanLyGioHang();;
			case 2:
				QuanLyDanhSachGioHang.hienThiDanhSachGioHang();
				break;
			
			case 0:
				return;

			default:
				System.out.println("Lua chon khong hop le !!");
			}

		} while (true);

	}

}
