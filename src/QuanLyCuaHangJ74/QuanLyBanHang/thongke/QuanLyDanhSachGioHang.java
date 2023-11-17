package QuanLyCuaHangJ74.QuanLyBanHang.thongke;

import java.util.ArrayList;

import QuanLyCuaHangJ74.QuanLyBanHang.KhachMuaHang.Gio;

public class QuanLyDanhSachGioHang {
	public static int autoId = 201;
	public static ArrayList<Gio> list = new ArrayList<>();
	public static void hienThiDanhSachGioHang() {
		System.out.println("\n---------------------DANH SACH GIO HANG-----------------------");
		for(Gio x : list) {
			x.disPlay();
			System.out.println();
		}
		
	}

}
