/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.MyCombobox;
import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLSanPham {

    // Đổ Dữ Liệu Vào Bảng
    public static void DoDuLieu(JTable table) {
        try {
            ResultSet rs = DAL.DALSanPham.GetAll();
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

    //Đổ dữ liệu vào bảng Loại Sản Phẩm
    public static void DoDuLieuLoaiSP(JTable table, int MaLoaiSP) {
        try {
            ResultSet rs = DAL.DALSanPham.GetbyMaLoaiSP(MaLoaiSP);
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

    //Tìm Kiếm Sản Phẩm Theo Từ Khóa
    public static void TimSanPhamTheoTuKhoaSP(JTable table, String tuKhoa) {
        try {
            ResultSet rs = DAL.DALSanPham.GetByTenSP(tuKhoa);
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
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu tìm Sản Phẩm !");
        }
    }

    //Hàm Thêm
    public static void InsertInto(SanPham SP) {
        DAL.DALSanPham.Them(SP);
    }

    //Hàm Sửa
    public static void Update(SanPham SP) {
        DAL.DALSanPham.Sua(SP);
    }

    //Hàm Xóa
    public static void Delete(int MaSP) {
        DAL.DALSanPham.Xoa(MaSP);
    }

    //Hàm Lấy Dựa Vào Tên 
    public static SanPham LayDuaVaoTenSP(String TenSP) {
        try {
            ResultSet rs = DAL.DALSanPham.GetByTenSP(TenSP);
            if (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setGia(rs.getDouble("Gia"));
                sp.setMaLoaiSP(rs.getInt("MaLoaiSP"));
                sp.setGhiChu(rs.getString("GhiChu"));
                return sp;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn Lấy Tên Sản Phẩm !");
        }
        return null;
    }

    //Hàm Lấy Dựa Vào Mã
    public static SanPham LayDuaVaoMaSP(int MaSP) {
        try {
            ResultSet rs = DAL.DALSanPham.GetbyMaSP(MaSP);
            if (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setGia(rs.getDouble("Gia"));
                sp.setMaLoaiSP(rs.getInt("MaLoaiSP"));
                sp.setGhiChu(rs.getString("GhiChu"));
                return sp;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn !");
        }
        return null;
    }

    //Hàm Lấy Dựa Vào Mã Loại
    public static SanPham LayDuaVaoMaLoaiSP(int MaLoaiSP) {
        try {
            ResultSet rs = DAL.DALSanPham.GetbyMaLoaiSP(MaLoaiSP);
            if (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setGia(rs.getDouble("Gia"));
                sp.setMaLoaiSP(rs.getInt("MaLoaiSP"));
                sp.setGhiChu(rs.getString("GhiChu"));
                return sp;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn !");
        }
        return null;
    }

    //Hàm đổ dữ liệu vào Combobox 
    public static void DoDuLieuVaoCBBLoaiSP(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALLoaiSanPham.GetAll();
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenLoaiSP"),
                        rs.getInt("MaLoaiSP"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    //Hàm gán dữ liệu cho combobox 
    public static void SetCBBLoaiSP(JComboBox cbb, int MaLoaiSP) {
        try {
            ResultSet rs = DAL.DALLoaiSanPham.GetbyMaLoaiSP(MaLoaiSP);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenLoaiSP"),
                        rs.getInt("MaLoaiSP"));
                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    //Khai Báo Biến Toàn Cục (Hàm Kiểm Tra Kí Tự Đặc Biệt)
    static String TenSP_Pattern = "^[a-zÃ-ỸA-Z\\s_]{3,50}$$";
    static String daucach = "^\\s+";

    //Hàm Kiểm Tra

    public static boolean KiemTra(String TenSP, int SoLuong, String DonViTinh, String Gia, int MaLoaiSP, String GhiChu) {
        //Hàm Kiểm Tra Tên Sản Phẩm
        SanPham sp = BLL.BLLSanPham.LayDuaVaoTenSP(TenSP);
        if (TenSP.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Sản Phẩm Không Được Bỏ Trống !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (sp != null) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Sản Phẩm Này Đã Tồn Tại !");
            return false;
        }
        Pattern pattern1 = Pattern.compile(daucach);
        if (pattern1.matcher(TenSP).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên sản phẩm không được chứa dấu cách hoặc khoảng trắng !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        //Hàm Khởi Tạo Kiểm Tra Sản Phẩm
        Pattern pattern = Pattern.compile(TenSP_Pattern);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (!pattern.matcher(TenSP).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Sản Phẩm Không Hợp Lệ !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenSP.length() < 5) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Sản Phẩm Tối Thiểu 5 Kí Tự !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenSP.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Sản Phẩm Tối Đa 50 Kí Tự !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (SoLuong < 1) {
            GUI.frmMain.ThongBao("Thông Báo !", "Số lượng mua phải lớn hơn 0 !");
            return false;
        } else if (SoLuong > 0) {
//                GUI.frmMain.ThongBao("Thông Báo", "Thêm Thành Công");
        }
        //Hàm Kiểm Tra Đơn Vị Tính
        if (DonViTinh.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Đơn Vị Tính Không Được Bỏ Trống !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (DonViTinh.length() < 2) {
            GUI.frmMain.ThongBao("Thông Báo !", "Đơn Vị Tính Tối Thiểu 2 Kí Tự !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (DonViTinh.length() > 10) {
            GUI.frmMain.ThongBao("Thông Báo !", "Đơn Vị Tính Tối Đa 10 Kí Tự !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }

        //Hàm Kiểm Tra Gía
        if (Gia.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Giá Không Được Bỏ Trống !");
            return false;
        }
        try {
            double gia = Double.parseDouble(Gia);
        } catch (Exception e) {
            GUI.frmMain.ThongBao("Thông Báo !", "Giá Phải Là Số !");
        }

        //Hàm Kiểm Tra Ghi Chú
        if (GhiChu.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Ghi Chú Tối Đa 50 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        return true;
    }

    //Hàm Kiểm Tra

    public static boolean KiemTraSua(String TenSP, int SoLuong, String DonViTinh, String Gia, int MaLoaiSP, String GhiChu) {
        //Hàm Kiểm Tra Tên Sản Phẩm
        if (TenSP.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Sản Phẩm Không Được Bỏ Trống !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        Pattern pattern1 = Pattern.compile(daucach);
        if (pattern1.matcher(TenSP).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên sản phẩm không được chứa dấu cách hoặc khoảng trắng !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }

        //Hàm Khởi Tạo Kiểm Tra Sản Phẩm
        Pattern pattern = Pattern.compile(TenSP_Pattern);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (!pattern.matcher(TenSP).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Sản Phẩm Không Hợp Lệ !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenSP.length() < 5) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Sản Phẩm Tối Thiểu 5 Kí Tự !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenSP.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Sản Phẩm Tối Đa 50 Kí Tự !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (SoLuong < 1) {
            GUI.frmMain.ThongBao("Thông Báo !", "Số lượng mua phải lớn hơn 0 !");
            return false;
        } else if (SoLuong > 0) {
//                GUI.frmMain.ThongBao("Thông Báo", "Thêm Thành Công");
        }
        //Hàm Kiểm Tra Đơn Vị Tính
        if (DonViTinh.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Đơn Vị Tính Không Được Bỏ Trống !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (DonViTinh.length() < 2) {
            GUI.frmMain.ThongBao("Thông Báo !", "Đơn Vị Tính Tối Thiểu 2 Kí Tự !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (DonViTinh.length() > 10) {
            GUI.frmMain.ThongBao("Thông Báo !", "Đơn Vị Tính Tối Đa 10 Kí Tự !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }

        //Hàm Kiểm Tra Gía
        if (Gia.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Giá Không Được Bỏ Trống !");
            return false;
        }
        try {
            double gia = Double.parseDouble(Gia);
        } catch (Exception e) {
            GUI.frmMain.ThongBao("Thông Báo !", "Giá Phải Là Số !");
        }

        //Hàm Kiểm Tra Ghi Chú
        if (GhiChu.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Ghi Chú Tối Đa 50 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        return true;
    }

}
