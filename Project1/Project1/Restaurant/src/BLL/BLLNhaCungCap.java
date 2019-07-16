/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.MyCombobox;
import DTO.NhaCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLNhaCungCap {

    public static void DoDuLieu(JTable table) {

        try {
            ResultSet rs = DAL.DALNhaCungCap.GetAll();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[7];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = rs.getString(6);
                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn đổ dữ liệu thực đơn !");
        }
    }
      //2. tim san theo tu khoa
     public static void TimNCCTheoTuKhoa(JTable table , String tuKhoa){
        
        try {
            ResultSet rs = DAL.DALNhaCungCap.GetByTenNCC(tuKhoa);
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while(rs.next()){
                Object obj[] = new Object[7];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = rs.getString(6);
                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu.tìm Sản Phẩm !");
        }
    }
    // 2. Hàm thêm
     
      public static void DoDuLieuVaoCBBNhanVien(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALLoaiNCC.GetAll();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenLoaiNCC"), rs.getInt("MaLoaiNCC"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    public static void SetCBBNhanVien(JComboBox cbb, int MaLoaiNCC) {
        try {
            ResultSet rs = DAL.DALLoaiNCC.GetbyMaLoaiSP(MaLoaiNCC);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenLoaiNCC"),
                        rs.getInt("MaLoaiNCC"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }
     

    public static void Them(NhaCungCap NCC) {
        DAL.DALNhaCungCap.Them(NCC);
    }

    // 3. Hàm sửa
    public static void Sua(NhaCungCap NCC) {
        DAL.DALNhaCungCap.Sua(NCC);
    }

    // 4. Hàm Xóa
    public static void Xoa(int MaCC) {
        DAL.DALNhaCungCap.Xoa(MaCC);
    }

    public static NhaCungCap LayDuaVaoMaNCC(int MaNCC) {
        try {
            ResultSet rs = DAL.DALNhaCungCap.GetbyMaNCC(MaNCC);
            if (rs.next()) {
                NhaCungCap bn = new NhaCungCap();
                bn.setMaNCC(rs.getInt("MaNCC"));
                bn.setTenNCC(rs.getString("TenNCC"));
                bn.setDiaChi(rs.getString("DiaChi"));
                bn.setDienThoai(rs.getString("DienThoai"));
                bn.setGhiChu(rs.getString("GhiChu"));

                return bn;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn Lấy mã Bàn !");
        }
        return null;
    }

    public static void DoDuLieuTheoMaNCC(JTable table, int MaNCC) {

        try {
            ResultSet rs = DAL.DALNhaCungCap.GetbyMaNCC(MaNCC);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[7];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                   obj[6] = rs.getString(6);
                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu NCC !");
        }
    }

    //Khai Báo Biến Toàn Cục (Hàm Kiểm Tra Kí Tự Đặc Biệt)
    static String TenNCC_Pattern = "^[a-zÃ-ỸA-Z\\s_]{3,50}$$";
    static String daucach = "^\\s+";

    public static boolean KiemTra(int MaNCC, String TenNCC, String DiaChi, String DienThoai, String GhiChu) {
        if (TenNCC.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Nhà Cung Cấp Không Được Bỏ Trống !");
            return false;
        }
        Pattern pattern1 = Pattern.compile(daucach);
        if (pattern1.matcher(TenNCC).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên nhà cung cấp không được có khoảng trắng hoặc kí tự đặc biệt !");
            return false;
        }
        //Hàm Kiểm Tra Tên Nhà Cung Cấp
        Pattern pattern = Pattern.compile(TenNCC_Pattern);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (!pattern.matcher(TenNCC).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Nhà Cung Cấp Không Hợp Lệ !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }

        if (TenNCC.length() < 2) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Nhà Cung Cấp tối thiểu 2 kí tự !");
            return false;
        }
        if (TenNCC.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Nhà Cung Cấp tối đa 50 kí tự !");
            return false;
        }

        //Địa chỉ
        if (DiaChi.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Địa chỉ không được bỏ trống !");
            return false;
        }
        if (DiaChi.length() < 5) {
            GUI.frmMain.ThongBao("Thông Báo !", "Địa chỉ tối thiểu 5 kí tự !");
            return false;
        }
        if (DiaChi.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Địa chỉ tối đa 50 kí tự !");
            return false;
        }

        //số điện thoại
        if (DienThoai.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Điện thoại không được bỏ trống !");
            return false;
        }
        if (!DienThoai.matches("0\\d{0,10}")) {
            GUI.frmMain.ThongBao("Thông Báo !", "Điện thoại phải là số !");
            return false;
        }
//        //GhiChu
//        if (GhiChu.length() == 0) {
//            GUI.frmMain.ThongBao("Thông Báo", "GhiChu không được bỏ trống !!!");
//            return false;
//        }
//        if (GhiChu.length() < 3) {
//            GUI.frmMain.ThongBao("Thông Báo", "GhiChu tối thiểu 3 kí tự !!!");
//            return false;
//        }
        if (GhiChu.length() > 255) {
            GUI.frmMain.ThongBao("Thông Báo !", "GhiChu tối đa 255 kí tự !");
            return false;
        }
        return true;
    }
}
