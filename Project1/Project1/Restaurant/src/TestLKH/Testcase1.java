package TestLKH;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTable;

import org.junit.jupiter.api.Test;

import BLL.BLLLoaiKH;
import BLL.BLLNhanVien;
import DAL.DALLoaiKhachHang;
import DTO.LoaiKhachHang;
import DTO.NhanVien;

public class Testcase1 {
	BLLLoaiKH lkh;
	BLLNhanVien nv;

//kiểm tra tên loại khách hàng
	@Test
	void testKiemTraTenLoaiKH() {
		boolean result = lkh.KiemTra("Khách Mới");
		assertTrue("Lỗi", result);
	}
	//kiểm tra tên loại khách hàng có giá trị hay không
	@Test
	void testKiemTraTenLoai() {
		LoaiKhachHang result = lkh.KiemTraTenLoaiSP("Khách Mới");
		assertNull("Lỗi");
	}

	// kiểm tra tên loại khách hàng
	@Test
	void testKiemTraLoGin() {
		boolean result = nv.Login("admin", "admin");
		assertTrue("Lỗi", result);
	}

//kiểm tra kết quả trả về thêm loại KH
	@Test
	void testThemLoai() {
		lkh = new BLLLoaiKH();
		String kq = lkh.InsertInto(new LoaiKhachHang("Long Nông", "Free"));
		assertNotEquals("Long Nông", "Free", kq);
	}

	// kiểm tra kết quả trả về sửa loại KH
	@Test
	void testSuaLoai() {
		lkh = new BLLLoaiKH();
		String kq = lkh.Update(new LoaiKhachHang("Nguyen Tan Ha ", "Free"));
		assertNotEquals("Nguyen Tan Ha ", "Free",kq);
	}

	// kiểm tra kết quả trả về xóa loại KH theo mã
	@Test
	void testXoaLoaiKH() {
		lkh = new BLLLoaiKH();
		int kq = lkh.Delete(4);
		assertEquals(4, kq);
	}

}
