/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.MyCombobox;
import DTO.NhanVien;
import GUI.frmMain;
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
public class BLLNhanVien {

    public static boolean Login(String TenDangNhap, String MatKhau) {
        DTO.NhanVien acc = DAL.DALNhanVien.Login(TenDangNhap, MatKhau);

        if (acc != null) {
            frmMain.ThongBao("Thông Báo !", "Đăng nhập thành công !");
            frmMain.Quyen = acc.getMaQuyen();
            return true;
        }
        frmMain.ThongBao("Thông Báo !", "Đăng nhập thất bại !");
        return false;
    }

    public static void DoDuLieuVaoCBBQuyen(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALQuyen.GetAll();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenQuyen"),
                        rs.getInt("MaQuyen"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    //4. Hàm gán dữ liệu cho combobox 
    public static void SetCBBQuyen(JComboBox cbb, int MaQuyen) {
        try {
            ResultSet rs = DAL.DALQuyen.GetbyMaQuyen(MaQuyen);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenQuyen"),
                        rs.getInt("MaQuyen"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    //1. Đổ dữ liệu vào bảng Sản phẩm
    public static void DoDuLieu(JTable table) {

        try {
            ResultSet rs = DAL.DALNhanVien.GetAll();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[9];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString("MaNV");
                obj[2] = rs.getString("TenNV");
                obj[3] = rs.getString("NgayVaoLam");
                obj[4] = rs.getString("Luong");

                obj[5] = rs.getString("DiaChi");
                obj[6] = rs.getString("DienThoai");
                obj[7] = rs.getString("TenDangNhap");
                obj[8] = rs.getString("MatKhau");

                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu bảng nhân viên !");
        }
    }

    public static NhanVien LayDuaVaoMaNV(int MaNV) {
        try {
            ResultSet rs = DAL.DALNhanVien.GetbyMaNV(MaNV);
            if (rs.next()) {
                NhanVien sp = new NhanVien();
                sp.setMaNV(rs.getInt("MaNV"));
                sp.setTenNV(rs.getString("TenNV"));
                sp.setNgaySinh(rs.getString("NgaySinh"));
                sp.setNgayVaoLam(rs.getString("NgayVaoLam"));
                sp.setGioiTinh(rs.getString("GioiTinh"));
                sp.setLuong(rs.getDouble("Luong"));
                sp.setSoCMND(rs.getString("SoCMND"));
                sp.setDiaChi(rs.getString("DiaChi"));
                sp.setDienThoai(rs.getString("DienThoai"));
                sp.setMaQuyen(rs.getInt("MaQuyen"));
                sp.setTenDangNhap(rs.getString("TenDangNhap"));
                sp.setMatKhau(rs.getString("MatKhau"));

                return sp;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn !");
        }
        return null;
    }
      //2. tim san theo tu khoa
     public static void TimNhanVienTheoTuKhoa(JTable table , String tuKhoa){
        
        try {
            ResultSet rs = DAL.DALNhanVien.GetByTenNV(tuKhoa);
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while(rs.next()){
                Object obj[] = new Object[9];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString("MaNV");
                obj[2] = rs.getString("TenNV");
                obj[3] = rs.getString("NgayVaoLam");
                obj[4] = rs.getString("Luong");

                obj[5] = rs.getString("DiaChi");
                obj[6] = rs.getString("DienThoai");
                obj[7] = rs.getString("TenDangNhap");
                obj[8] = rs.getString("MatKhau");                        
  
                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu.tìm Sản Phẩm !");
        }
    }

    // 2. Hàm thêm
    public static void Them(NhanVien NV) {
        DAL.DALNhanVien.Them(NV);
    }

    // 3. Hàm sửa
    public static void Sua(NhanVien NV) {
        DAL.DALNhanVien.Sua(NV);
    }

    // 4. Hàm Xóa
    public static void Xoa(int MaNV) {
        DAL.DALNhanVien.Xoa(MaNV);
    }

     //Khai Báo Biến Toàn Cục (Hàm Kiểm Tra Kí Tự Đặc Biệt)
    static String NhanVien_Pattern = "^[a-zÃ-ỸA-Z\\s_]{3,50}$$";
    static String daucach="^\\s+";
    public static boolean KiemTra(int MaNV, String TenNV, String NgaySinh, String NgayVaoLam, String GioiTinh, String Luong, String SoCMND, String DiaChi, String DienThoai, int MaQuyen, String TenDangNhap, String MatKhau) {
        if (TenNV.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Nhân Viên Không Được Bỏ Trống !");
            return false;
        }
        Pattern pattern1 =Pattern.compile(daucach);
        if (pattern1.matcher(TenNV).matches()) {
             GUI.frmMain.ThongBao("Thông Báo !", "Tên Nhân Viên không được có khoảng trắng hoặc kí tự đặc biệt !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        //Hàm Khởi Tạo Kiểm Tra Sản Phẩm
        Pattern pattern = Pattern.compile(NhanVien_Pattern);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (!pattern.matcher(TenNV).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Nhân Viên Không Hợp Lệ !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
       
        if (TenNV.length() < 2) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Nhân Viên tối thiểu 2 kí tự !");
            return false;
        }
        if (TenNV.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Nhân Viên tối đa 50 kí tự !");
            return false;
        }
//        if (TenNV.matches("^[a-z0-9._-]{3,15}$")) {
//            GUI.frmMain.ThongBao("Thông Báo", "Tên Nhân Viên chỉ chứa kí tự alphabet và kí tự trắng !!!");
//            return false;
//        }

        //Ngay Sinh----------
        if (NgaySinh.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Ngày sinh không được bỏ trống !");
            return false;
        }
        //chuyển đổi ngày
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            date.parse(NgaySinh);
        } catch (Exception e) {
            GUI.frmMain.ThongBao("Thông Báo !", "Ngày sinh phải là ngày trước 2018 !");
            return false;
        }

        //Ngày vào làm---------------
        if (NgayVaoLam.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Ngày vào làm không được bỏ trống !");
            return false;
        }
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            date.parse(NgayVaoLam);
        } catch (Exception e) {
            GUI.frmMain.ThongBao("Thông Báo !", "Ngày vào làm phải là ngày sau 2018 !");
            return false;
        }
        
        //Lương
        if (Luong.trim().equals("")) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lương Không được bỏ trống  !");
            return false;
        }
        try {
            double a = Double.parseDouble(Luong);
        } catch (Exception e) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lương phải là số  !");
            return false;
        }
        
        //số CMND --------------
        if (SoCMND.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Số CMND không được bỏ trống !");
            return false;
        }
        if (!SoCMND.matches("^[0-9]{2,9}")) {
            GUI.frmMain.ThongBao("Thông Báo !", "Số CMND phải đúng định dạng !");
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

        //Tên đăng nhập
        if (TenDangNhap.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên đăng nhập không được bỏ trống !");
            return false;
        }
        if (TenDangNhap.length() < 5) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên đăng nhập tối thiểu 5 kí tự !");
            return false;
        }
        if (TenDangNhap.length() > 20) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên đăng nhập tối đa 20 kí tự !");
            return false;
        }
        if (!TenDangNhap.matches("^[a-zẠ-ỹ0-9A-Z ]+")) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên đăng nhập không được nhập kí tự đặc biệt và không có khoảng trắng !");
            return false;
        }
        
        //mật khẩu
        if (MatKhau.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "MatKhau không được bỏ trống !");
            return false;
        }
//        if (MatKhau.length() < 3) {
//            GUI.frmMain.ThongBao("Thông Báo", "MatKhau tối thiểu 3 kí tự !!!");
//            return false;
//        }
//        if (MatKhau.length() > 50) {
//            GUI.frmMain.ThongBao("Thông Báo", "MatKhau tối đa 50 kí tự !!!");
//            return false;
//        }
        if (!MatKhau.matches("^[a-zẠ-ỹ0-9A-Z ]+")) {
            GUI.frmMain.ThongBao("Thông Báo !", "MatKhau không được có khoảng trắng và kí tự có dấu !");
            return false;
        }
        return true;
    }
}
