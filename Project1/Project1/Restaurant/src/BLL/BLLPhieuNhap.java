/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.MyCombobox;
import DTO.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLPhieuNhap {
    
    public static void DoDuLieu(JTable table) {
        try {
            ResultSet rs = DAL.DALPhieuNhap.GetAll();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[10];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = rs.getString(6);
                obj[7] = rs.getString(7);
                obj[8] = rs.getString(8);
                obj[9] = rs.getString(9);

                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn đổ dữ liệu thực đơn !");
        }
    }
    // 2. Hàm thêm

    public static void Them(PhieuNhap PN) {
        DAL.DALPhieuNhap.Them(PN);
    }

    // 3. Hàm sửa
    public static void Sua(PhieuNhap PN) {
        DAL.DALPhieuNhap.Sua(PN);
    }

    // 4. Hàm Xóa
    public static void Xoa(int MaPhieuNhapKho) {
        DAL.DALPhieuNhap.Xoa(MaPhieuNhapKho);
    }
    
    public static void DoDuLieuVaoCBBNCC(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALNhaCungCap.GetAll();
            
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenNCC"),
                        rs.getInt("MaNCC"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    //4. Hàm gán dữ liệu cho combobox 
    public static void SetCBBNCC(JComboBox cbb, int MaNCC) {
        try {
            ResultSet rs = DAL.DALNhaCungCap.GetbyMaNCC(MaNCC);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenNCC"),
                        rs.getInt("MaNCC"));
                
                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {
            
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }
    
    public static void DoDuLieuVaoCBBNhanVien(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALNhanVien.GetAll();
            
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenNV"), rs.getInt("MaNV"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }
    
    public static void SetCBBNhanVien(JComboBox cbb, int MaNV) {
        try {
            ResultSet rs = DAL.DALNhanVien.GetbyMaNV(MaNV);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenNV"),
                        rs.getInt("MaNV"));
                
                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {
            
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }
    //3. Hàm đổ dữ liệu vào Combobox 

    public static void DoDuLieuVaoCBBMaSP(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALSanPham.GetAll();
            
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenSP"),
                        rs.getInt("MaSP"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    //4. Hàm gán dữ liệu cho combobox 
    public static void SetCBBMaSP(JComboBox cbb, int MaSP) {
        try {
            ResultSet rs = DAL.DALSanPham.GetbyMaSP(MaSP);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenSP"),
                        rs.getInt("MaSP"));
                
                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {
            
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }
    
    public static PhieuNhap LayDuaVaoMaPhieuNhap(int MaPhieuNhapKho) {
        try {
            ResultSet rs = DAL.DALPhieuNhap.GetbyMaPhieuNhapKho(MaPhieuNhapKho);
            if (rs.next()) {
                PhieuNhap PN = new PhieuNhap();
                PN.setMaPhieuNhapKho(rs.getInt("MaPhieuNhapKho"));
                PN.setMaNCC(rs.getInt("MaNCC"));
                PN.setMaNV(rs.getInt("MaNV"));
                PN.setSoLuong(rs.getInt("SoLuong"));
                PN.setGiaTien(rs.getDouble("GiaTien"));
                PN.setNgayNhap(rs.getString("NgayNhap"));
                PN.setMaSP(rs.getInt("MaSP"));
                PN.setDonViTinh(rs.getString("DonViTinh"));
                PN.setGhiChu(rs.getString("GhiChu"));
                
                return PN;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn !");
        }
        return null;
    } //Khai Báo Biến Toàn Cục (Hàm Kiểm Tra Kí Tự Đặc Biệt)
//    static String DonViTinh_Pattern = "^[a-zÃ-ỸA-Z\\s_]{3,50}$$";
//    
//    public static boolean KiemTra(String Gia, String NgayNhap, String DonViTinh, int SoLuong) {
//        //Hàm Khởi Tạo Kiểm Tra Sản Phẩm
//        Pattern pattern = Pattern.compile(DonViTinh_Pattern);
//        //Hàm Kiểm Tra Kí Tự Đăc Biệt
//        //Giá
//        
//        if (SoLuong < 1) {
//                GUI.frmMain.ThongBao("Thông Báo !", "Số lượng mua phải lớn hơn 0 !");
//                return false;
//            } else if (SoLuong > 0) {
////                GUI.frmMain.ThongBao("Thông Báo", "Thêm Thành Công");
//            }
//        if (Gia.trim().equals("")) {
//            GUI.frmMain.ThongBao("Thông Báo !", "Giá Không được bỏ trống  !");
//            return false;
//        }
//        try {
//            double a = Double.parseDouble(Gia);
//        } catch (Exception e) {
//            GUI.frmMain.ThongBao("Thông Báo !", "Giá phải là số  !");
//            return false;
//        }
//        //Ngay Nhập
//        if (NgayNhap.length() == 0) {
//            GUI.frmMain.ThongBao("Thông Báo !", "Ngày nhập không được bỏ trống !");
//            return false;
//        }
//        try {
//            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//            date.parse(NgayNhap);
//        } catch (Exception e) {
//            GUI.frmMain.ThongBao("Thông Báo !", "Ngày nhập phải là ngày sau 2018 !");
//            return false;
//        }
//        if (DonViTinh.length() == 0) {
//            GUI.frmMain.ThongBao("Thông Báo !", "Đơn Vị Tính được bỏ trống  !");
//            return false;
//        }
//        return true;
//    }
    //Khai Báo Biến Toàn Cục (Hàm Kiểm Tra Kí Tự Đặc Biệt)
//    static String DonViTinh_Pattern = "^[a-zÃ-ỸA-Z\\s_]{3,50}$$";
//    static String daucach="^\\s+";

    public static boolean KiemTra(String Gia, String NgayNhap, String DonViTinh, int SoLuong) {
//        //Hàm Khởi Tạo Kiểm Tra Sản Phẩm
//        Pattern pattern = Pattern.compile(DonViTinh_Pattern);
//        //Hàm Kiểm Tra Kí Tự Đăc Biệt
//        //Giá

        if (SoLuong < 1) {
            GUI.frmMain.ThongBao("Thông Báo !", "Số lượng mua phải lớn hơn 0 !");
            return false;
        } else if (SoLuong > 0) {
//                GUI.frmMain.ThongBao("Thông Báo", "Thêm Thành Công");
        }
        if (Gia.trim().equals("")) {
            GUI.frmMain.ThongBao("Thông Báo !", "Giá Không được bỏ trống  !");
            return false;
        }
        try {
            double a = Double.parseDouble(Gia);
        } catch (Exception e) {
            GUI.frmMain.ThongBao("Thông Báo !", "Giá phải là số  !");
            return false;
        }
        //Ngay Nhập
        if (NgayNhap.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Ngày nhập không được bỏ trống !");
            return false;
        }
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            date.parse(NgayNhap);
        } catch (Exception e) {
            GUI.frmMain.ThongBao("Thông Báo !", "Sai định dạng ngày ,phải là yyyy-MM-dd");
            return false;
        }
        if (DonViTinh.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Đơn Vị Tính được bỏ trống  !");
            return false;
        }
        return true;
    }
}
