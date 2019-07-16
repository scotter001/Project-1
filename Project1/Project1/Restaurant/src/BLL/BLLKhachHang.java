/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.KhachHang;
import DTO.MyCombobox;
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
public class BLLKhachHang {

    public static void DoDuLieu(JTable table) {

        try {
            ResultSet rs = DAL.DALKhachHang.GetAll();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[8];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = rs.getString(6);
                obj[7] = rs.getString(7);

                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu Sản Phẩm !");
        }
    }
    //2. tim san theo tu khoa

    public static void TimKhachHangTheoTuKhoa(JTable table, String tuKhoa) {

        try {
            ResultSet rs = DAL.DALKhachHang.GetByTenKH(tuKhoa);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[8];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = rs.getString(6);
                obj[7] = rs.getString(7);

                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu.tìm Sản Phẩm !");
        }
    }

    public static void DoDuLieuLoaiKH(JTable table, int MaLoaiKH) {

        try {
            ResultSet rs = DAL.DALKhachHang.GetbyMaLoaiKH(MaLoaiKH);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[8];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = rs.getString(6);
                obj[7] = rs.getString(7);

                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu Sản Phẩm !");
        }
    }

    //2.Thêm
    public static void InsertInto(KhachHang KH) {
        DAL.DALKhachHang.Them(KH);
    }

    //3.Sửa
    public static void Update(KhachHang KH) {
        DAL.DALKhachHang.Sua(KH);
    }

    //4.Xóa
    public static void Delete(int MaKH) {
        DAL.DALKhachHang.Xoa(MaKH);
    }

    public static KhachHang LayDuaVaoMaKH(int MaKH) {
        try {
            ResultSet rs = DAL.DALKhachHang.GetbyMaKH(MaKH);
            if (rs.next()) {
                KhachHang sp = new KhachHang();
                sp.setMaKH(rs.getInt("MaKH"));
                sp.setTenKH(rs.getString("TenKH"));
                sp.setDiaChi(rs.getString("DiaChi"));
                sp.setGioiTinh(rs.getString("GioiTinh"));
                sp.setDienThoai(rs.getString("DienThoai"));
                sp.setMaLoaiKH(rs.getInt("MaLoaiKH"));
                sp.setGhiChu(rs.getString("GhiChu"));

                return sp;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn !");
        }
        return null;
    }

    public static KhachHang LayDuaVaoMaLoaiKH(int MaLoaiKH) {
        try {
            ResultSet rs = DAL.DALKhachHang.GetbyMaLoaiKH(MaLoaiKH);
            if (rs.next()) {
                KhachHang sp = new KhachHang();
                sp.setMaKH(rs.getInt("MaKH"));
                sp.setTenKH(rs.getString("TenKH"));
                sp.setDiaChi(rs.getString("DiaChi"));
                sp.setGioiTinh(rs.getString("GioiTinh"));
                sp.setDienThoai(rs.getString("DienThoai"));
                sp.setMaLoaiKH(rs.getInt("MaLoaiKH"));
                sp.setGhiChu(rs.getString("GhiChu"));

                return sp;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn !");
        }
        return null;
    }

    //3. Hàm đổ dữ liệu vào Combobox 
    public static void DoDuLieuVaoCBBLoaiKH(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALLoaiKhachHang.GetAll();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenLoaiKH"),
                        rs.getInt("MaLoaiKH"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    //4. Hàm gán dữ liệu cho combobox 
    public static void SetCBBLoaiKH(JComboBox cbb, int MaLoaiKH) {
        try {
            ResultSet rs = DAL.DALLoaiKhachHang.GetbyMaLoaiSP(MaLoaiKH);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenLoaiKH"),
                        rs.getInt("MaLoaiKH"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    //Khai Báo Biến Toàn Cục (Hàm Kiểm Tra Kí Tự Đặc Biệt)
    static String TenKH_Pattern = "^[a-zÃ-ỸA-Z\\s_]{3,50}$$";
    static String daucach = "^\\s+";

    public static boolean KiemTra(int MaKH, String TenKH, String DiaChi, String GioiTinh, String DienThoai, int MaLoaiKH, String GhiChu) {
        if (TenKH.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Khách Hàng Không Được Bỏ Trống !");
            return false;
        }
        //hàm kiểm tra dấu cách
        Pattern pattern1 = Pattern.compile(daucach);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (pattern1.matcher(TenKH).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Khách Hàng Không được để khoảng trống !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
//Hàm Kiểm Tra Tên Khách Hàng
        Pattern pattern = Pattern.compile(TenKH_Pattern);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (!pattern.matcher(TenKH).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Khách Hàng Không Hợp Lệ !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }

        if (TenKH.length() < 2) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Khách Hàng tối thiểu 2 kí tự !");
            return false;
        }
        if (TenKH.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Khách Hàng tối đa 50 kí tự !");
            return false;
        }

        //Địa chỉ
        if (DiaChi.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Địa Chỉ Không Được Bỏ Trống !");
            return false;
        }
        if (DiaChi.length() < 2) {
            GUI.frmMain.ThongBao("Thông Báo !", "Địa Chỉ tối thiểu 2 kí tự !");
            return false;
        }
        if (DiaChi.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Địa Chỉ tối đa 50 kí tự !");
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

        //Ghi Chú
        if (GhiChu.length() > 255) {
            GUI.frmMain.ThongBao("Thông Báo !", "GhiChu tối đa 255 kí tự !");
            return false;
        }
        return true;
    }
}
