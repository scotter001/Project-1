/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.HoaDon;
import DTO.NhanVien;
import DTO.PhieuNhap;
import GUI.frmMain;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DALNhanVien {
    //1. hàm lấy tất cả 

    public static ResultSet GetAll() {

        String cauTruyVan = "select * from NhanVien";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);

    }
    //2. hàm lấy theo ID

    public static ResultSet GetbyMaNV(int MaNV) {
        String cauTruyVan = "select * from NhanVien where MaNV =  " + MaNV;
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    //3. hàm xóa theo ID
    public static void Xoa(int MaNV) {

        String cauTruyVan = "delete from NhanVien where MaNV = " + MaNV;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        if (cauTruyVan.contains(cauTruyVan) == true) {
            GUI.frmMain.ThongBao("Thông báo", "Nhân Viên này đang hoạt động bên Phiếu Nhập và Hóa Đơn, Không thể xóa");
        } else {
            GUI.frmMain.ThongBao("Thông báo", "Xóa thành công !");

        }

    }
    //Tìm Kiếm Theo Từ Khóa   

    public static ResultSet GetByTenNV(String tuKhoa) {
        String cauTruyVan = "select * from NhanVien where TenNV like N'%" + tuKhoa + "%'";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    public static DTO.NhanVien Login(String TenDangNhap, String MatKhau) {
        try {
            String query = "select * from NhanVien where TenDangNhap = '" + TenDangNhap + "' and MatKhau = '" + MatKhau + "'"
                    + "";
            ResultSet rs = frmMain.connection.ExcuteQueryGetTable(query);

            if (rs.next()) {
                NhanVien NV = new DTO.NhanVien(rs.getInt("MaNV"), rs.getString("TenNV"), rs.getString("NgaySinh"), rs.getString("NgayVaoLam"), rs.getString("GioiTinh"), rs.getDouble("Luong"), rs.getString("SoCMND"), rs.getString("DiaChi"), rs.getString("DienThoai"), rs.getInt("MaQuyen"), rs.getString("TenDangNhap"), rs.getString("MatKhau"));

                return NV;
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        }
        return null;
    }

    //4. hàm sửa toàn bộ 
    public static void Sua(NhanVien NV) {
        String cauTruyVan = "update NhanVien set TenNV = N'" + NV.getTenNV() + "' , NgaySinh = '" + NV.getNgaySinh() + "' , NgayVaoLam = '" + NV.getNgayVaoLam() + "' , GioiTinh = '" + NV.getGioiTinh() + "' , Luong = '" + NV.getLuong() + "' , SoCMND = '" + NV.getSoCMND() + "' , DiaChi = N'" + NV.getDiaChi() + "' , DienThoai = '" + NV.getDienThoai() + "' , MaQuyen = " + NV.getMaQuyen() + " , TenDangNhap = '" + NV.getTenDangNhap() + "' , MatKhau = '" + NV.getMatKhau() + "' where MaNV = " + NV.getMaNV() + "";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Sửa Thành Công");
    }

    // hàm thêm
    public static void Them(NhanVien NV) {
        String cauTruyVan = "insert into NhanVien values(N'" + NV.getTenNV() + "','" + NV.getNgaySinh() + "','" + NV.getNgayVaoLam() + "'," + NV.getGioiTinh() + "," + NV.getLuong() + ",'" + NV.getSoCMND() + "',N'" + NV.getDiaChi() + "','" + NV.getDienThoai() + "'," + NV.getMaQuyen() + ",'" + NV.getTenDangNhap() + "','" + NV.getMatKhau() + "')";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Thêm Thành Công");
    }
  

}
