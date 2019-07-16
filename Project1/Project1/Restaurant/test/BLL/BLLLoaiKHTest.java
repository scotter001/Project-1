/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.LoaiKhachHang;
import javax.swing.JTable;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LONG-PC
 */
public class BLLLoaiKHTest {
   @Test
	void testKiemTraLoaiKH() {
		BLLLoaiKH lkh = new BLLLoaiKH();
		boolean a = lkh.KiemTra("Khách Thường");
		assertTrue(a);
	}
	
}
