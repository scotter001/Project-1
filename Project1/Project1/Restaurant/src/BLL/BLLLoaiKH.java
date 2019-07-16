/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOLoaiNCC;
import DTO.LoaiKhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLLoaiKH {

    public static void DoDuLieu(JTable table) {

        try {
            ResultSet rs = DAL.DALLoaiKhachHang.GetAll();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[4];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu Sản Phẩm !");
        }
    }

    public static LoaiKhachHang KiemTraTenLoaiSP(String TenLoaiKH) {
        try {
            ResultSet rs = DAL.DALLoaiKhachHang.GetByTenLoaiKH(TenLoaiKH);
            if (rs.next()) {
                LoaiKhachHang bn = new LoaiKhachHang();
                bn.setMaLoaiKH(rs.getInt("MaLoaiKH"));
                bn.setTenLoaiKH(rs.getString("TenLoaiKH"));
                bn.setUuDai(rs.getString("UuDai"));
                return bn;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn !");
        }
        return null;
    }

    //2.Thêm
    public static String InsertInto(LoaiKhachHang lncc) {
        DAL.DALLoaiKhachHang.Them(lncc);
        return null;
    }

    //3.Sửa
    public static String Update(LoaiKhachHang lncc) {
        DAL.DALLoaiKhachHang.Sua(lncc);
        return null;
    }

    //4.Xóa
    public static int Delete(int MaLoaiNCC) {
        DAL.DALLoaiKhachHang.Xoa(MaLoaiNCC);
        return MaLoaiNCC;
    }

    //Khai Báo Biến Toàn Cục (Hàm Kiểm Tra Kí Tự Đặc Biệt)
    static String TenLoaiSP_Pattern = "^[a-zÃ-ỸA-Z\\s_]{3,50}$$";
    static String daucach = "^\\s+";

    public static boolean KiemTra(String TenLoaiNCC) {
        if (TenLoaiNCC.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Khách Hàng Không Được Để Trống !");
            return false;
        }
        Pattern pattern1 = Pattern.compile(daucach);
        if (pattern1.matcher(TenLoaiNCC).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Khách Hàng Không Được Chứa Khoảng Trắng Đầu Tiên !");
            return false;
        }
//        LoaiKhachHang lkh = BLL.BLLLoaiKH.KiemTraTenLoaiSP(TenLoaiNCC);
//        if (TenLoaiNCC == null) {
//            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Khách Hàng Này Đã Tồn Tại !");
//            return false;
//        }
        //Hàm Khởi Tạo Kiểm Tra Sản Phẩm
        Pattern pattern = Pattern.compile(TenLoaiSP_Pattern);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (!pattern.matcher(TenLoaiNCC).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Khách Hàng Không Hợp Lệ !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }

        if (TenLoaiNCC.length() < 3) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Khách Hàng Tối Thiểu 3 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenLoaiNCC.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Khách Hàng Tối Đa 50 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        //Kiểm Tra Trùng Tên
        DTO.LoaiKhachHang sp = BLL.BLLLoaiKH.KiemTraTenLoaiSP(TenLoaiNCC);
        if (sp != null) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Khách Hàng Đã Tồn Tại !");
            return false;
        }
        return true;
    }
}
