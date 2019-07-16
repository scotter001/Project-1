/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.NhaCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DALNhaCungCap {


    //1. hàm lấy tất cả 
    public static ResultSet GetAll() {

        String cauTruyVan = "select * from NhaCungCap";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);

    }
    //2. hàm lấy theo ID

    public static ResultSet GetbyMaNCC(int MaLoaiNCC) {
        String cauTruyVan = "select * from NhaCungCap where MaLoaiNCC = " + MaLoaiNCC;
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    //3. hàm xóa theo ID
    public static void Xoa(int MaNCC) {
        String cauTruyVan = "delete from NhaCungCap where MaNCC = " + MaNCC;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Xóa Thành Công");

    }
    //Tìm Kiếm Theo Từ Khóa   

    public static ResultSet GetByTenNCC(String tuKhoa) {
        String cauTruyVan = "select * from NhaCungCap where TenNCC like N'%" + tuKhoa + "%'";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
        
    }
    //4. hàm sửa toàn bộ 

    public static void Sua(NhaCungCap NCC) {
        String cauTruyVan = "update NhaCungCap set TenNCC = N'" + NCC.getTenNCC() + "', DiaChi = N'" + NCC.getDiaChi() + "',DienThoai = '" + NCC.getDienThoai() + "',GhiChu = N'" + NCC.getGhiChu() + "', MaLoaiNCC = "+NCC.getMaLoaiNCC()+"  where MaNCC = " + NCC.getMaNCC() + "";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Sửa Thành Công");
    }

    // hàm thêm
    public static void Them(NhaCungCap NCC) {
        String cauTruyVan = "insert into NhaCungCap values(N'" + NCC.getTenNCC() + "',N'" + NCC.getDiaChi() + "','" + NCC.getDienThoai() + "',N'" + NCC.getGhiChu() + "',"+NCC.getMaLoaiNCC()+")";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Thêm Thành Công");
    }
}
